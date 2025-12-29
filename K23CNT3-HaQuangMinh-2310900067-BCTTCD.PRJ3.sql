-- Tạo database
CREATE DATABASE IF NOT EXISTS hqm_petshop;
USE hqm_petshop;

-- Bảng danh mục sản phẩm
CREATE TABLE danhmucsp (
    MaDMSP INT AUTO_INCREMENT PRIMARY KEY,
    TenDMSP VARCHAR(100) NOT NULL,
    MoTa TEXT
);

-- Bảng sản phẩm
CREATE TABLE sanpham (
    MaSP INT AUTO_INCREMENT PRIMARY KEY,
    TenSP VARCHAR(150) NOT NULL,
    Gia DECIMAL(15,2) NOT NULL,
    SoLuong INT DEFAULT 0,
    HinhAnh VARCHAR(255),
    MaDMSP INT,
    FOREIGN KEY (MaDMSP) REFERENCES danhmucsp(MaDMSP)
);

-- Bảng khách hàng + tài khoản user
CREATE TABLE khachhang (
    MaKH INT AUTO_INCREMENT PRIMARY KEY,
    HoTen VARCHAR(100) NOT NULL,
    SDT VARCHAR(20) NOT NULL,
    DiaChi VARCHAR(255),
    Email VARCHAR(100),
    Username VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL
);

-- Bảng hóa đơn
CREATE TABLE hoadon (
    MaHD INT AUTO_INCREMENT PRIMARY KEY,
    MaKH INT,
    NgayLap DATE NOT NULL,
    TongTien DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (MaKH) REFERENCES khachhang(MaKH)
);

-- Bảng chi tiết hóa đơn
CREATE TABLE chitiethoadon (
    MaCTHD INT AUTO_INCREMENT PRIMARY KEY,
    MaHD INT,
    MaSP INT,
    SoLuong INT NOT NULL,
    DonGia DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (MaHD) REFERENCES hoadon(MaHD),
    FOREIGN KEY (MaSP) REFERENCES sanpham(MaSP)
);

-- Bảng admin
CREATE TABLE admin (
    MaAdmin INT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    HoTen VARCHAR(100)
);
 


 USE hqm_petshop;
-- ========================
-- Dữ liệu bảng danh mục sản phẩm
INSERT INTO danhmucsp (MaDMSP, MoTa, TenDMSP) VALUES
(1, 'Các giống chó cảnh phổ biến', 'Chó cảnh'),
(2, 'Các giống mèo cảnh dễ nuôi', 'Mèo cảnh'),
(3, 'Thức ăn dành cho chó mèo', 'Thức ăn thú cưng'),
(4, 'Đồ dùng, phụ kiện cho thú cưng', 'Phụ kiện thú cưng'),
(5, 'Dịch vụ chăm sóc thú cưng', 'Dịch vụ');

-- Dữ liệu bảng sản phẩm
INSERT INTO sanpham (MaSP, Gia, HinhAnh, SoLuong, TenSP, madmsp) VALUES
(1, 15000000, 'cho_poodle.jpg', 5, 'Chó Poodle thuần chủng', 1),
(2, 12000000, 'cho_corgi.jpg', 4, 'Chó Corgi chân ngắn', 1),
(3, 10000000, 'meo_anh_long_ngan.jpg', 6, 'Mèo Anh lông ngắn', 2),
(4, 9000000, 'meo_tai_cup.jpg', 5, 'Mèo tai cụp Scottish Fold', 2),
(5, 350000, 'thucan_cho.jpg', 50, 'Thức ăn cho chó Pedigree', 3),
(6, 320000, 'thucan_meo.jpg', 45, 'Thức ăn cho mèo Whiskas', 3),
(7, 180000, 'vong_co.jpg', 60, 'Vòng cổ cho thú cưng', 4),
(8, 250000, 'khay_cat.jpg', 30, 'Khay vệ sinh cho mèo', 4),
(9, 500000, 'tam_thu_cung.jpg', 20, 'Dịch vụ tắm thú cưng', 5),
(10, 800000, 'cat_tia_long.jpg', 15, 'Dịch vụ cắt tỉa lông', 5);

-- Dữ liệu bảng khách hàng (có username + password)
INSERT INTO khachhang (MaKH, DiaChi, Email, HoTen, Password, SDT, Username) VALUES
(1, 'Hà Nội', 'khach1@gmail.com', 'Nguyễn Minh Tuấn', '123456', '0912345678', 'user1'),
(2, 'TP.HCM', 'khach2@gmail.com', 'Trần Thị Mai', '123456', '0987654321', 'user2'),
(3, 'Đà Nẵng', 'khach3@gmail.com', 'Phạm Văn Long', '123456', '0933555777', 'user3'),
(4, 'Hải Phòng', 'khach4@gmail.com', 'Lê Thị Hoa', '123456', '0977888999', 'user4'),
(5, 'Cần Thơ', 'khach5@gmail.com', 'Hoàng Văn Nam', '123456', '0909001122', 'user5');
-- Dữ liệu bảng hóa đơn
INSERT INTO hoadon (MaHD, NgayLap, TongTien, MaKH) VALUES
(1, '2025-11-20', 27300000, 1),
(2, '2025-11-21', 9000000, 2),
(3, '2025-11-22', 1050000, 3);
-- Dữ liệu bảng chi tiết hóa đơn
INSERT INTO chitiethoadon (MaCTHD, DonGia, SoLuong, MaHD, MaSP) VALUES
(1, 15000000, 1, 1, 1),  
(2, 12000000, 1, 1, 2),  
(3, 180000, 5, 1, 7),   
(4, 9000000, 1, 2, 4),  
(5, 250000, 4, 3, 8);    



INSERT INTO admin (MaAdmin, HoTen, Password, Username) VALUES
(2,'Quang Minh','123456','minh'),
(1,'Quản trị viên','123456','admin');

SELECT MaSP, TenSP, CONCAT('[', HinhAnh, ']') 
FROM sanpham;