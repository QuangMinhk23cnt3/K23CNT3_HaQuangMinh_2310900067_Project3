package K23CNT3_HaQuangMinh_Prj3.config;

import K23CNT3_HaQuangMinh_Prj3.entity.*;
import K23CNT3_HaQuangMinh_Prj3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private HqmUserRepository userRepo;

    @Autowired
    private HqmCategoryRepository categoryRepo;

    @Autowired
    private HqmProductRepository productRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        // ===== USERS =====
        if (userRepo.count() == 0) {
            HqmUser admin = HqmUser.builder()
                    .username("admin")
                    .email("admin@petshop.com")
                    .password(passwordEncoder.encode("123456"))
                    .fullName("Administrator")
                    .role("ADMIN")
                    .enabled(true)
                    .build();

            HqmUser user = HqmUser.builder()
                    .username("minh")
                    .email("minh@gmail.com")
                    .password(passwordEncoder.encode("123456"))
                    .fullName("Khách hàng Minh")
                    .role("USER")
                    .enabled(true)
                    .build();

            userRepo.save(admin);
            userRepo.save(user);
        }

        // ===== CATEGORIES =====
        if (categoryRepo.count() == 0) {
            HqmCategory dog = new HqmCategory(null, "Chó");
            HqmCategory cat = new HqmCategory(null, "Mèo");
            HqmCategory food = new HqmCategory(null, "Thức ăn");

            categoryRepo.save(dog);
            categoryRepo.save(cat);
            categoryRepo.save(food);
        }

        // ===== PRODUCTS =====
        if (productRepo.count() == 0) {
            HqmCategory dog = categoryRepo  .findByName("Chó").orElse(null);
            HqmCategory food = categoryRepo.findByName("Thức ăn").orElse(null);

            if (dog != null) {
                productRepo.save(HqmProduct.builder()
                        .name("Chó Alaska")
                        .price(15000000.0)
                        .description("Chó Alaska thuần chủng")
                        .category(dog)
                        .imageUrl("dog1.jpg")
                        .build());
            }

            if (food != null) {
                productRepo.save(HqmProduct.builder()
                        .name("Thức ăn cho chó Royal Canin")
                        .price(350000.0)
                        .description("Thức ăn cao cấp cho chó")
                        .category(food)
                        .imageUrl("food1.jpg")
                        .build());
            }
        }
    }
}
