package k23cnt3_hqmDay03.service;

import k23cnt3_hqmDay03.entity.HqmStudent;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class HqmServiceStudent {
    List<HqmStudent> HqmStudents;

    public  HqmServiceStudent(){
        HqmStudents = List.of(
                new HqmStudent(1, "Ha Quang Minh", 20, true, "Hà Nội", "0846409694", "haquangminhk23cnt3@gmail.com"),
                new HqmStudent(2, "Đỗ Thị Hạnh", 20, false, "Vĩnh Long", "0923456789", "hanh.do@example.com")
        );
    }
    // Các phương thức
    // Lấy toàn bộ danh sách sinh viên
    public List<HqmStudent> getHqmStudents() {
        return HqmStudents;
    }

    // Lấy sinh viên theo id
    public HqmStudent getHqmStudent(Long HqmId) {
        return HqmStudents.stream()
                .filter(student -> student
                        .getHqmId() == HqmId)
                .findFirst().orElse(null);
    }
    // Thêm mới một sinh viên
    public HqmStudent addHqmStudent(HqmStudent student) {
        HqmStudents.add(student);
        return student;
    }
}
