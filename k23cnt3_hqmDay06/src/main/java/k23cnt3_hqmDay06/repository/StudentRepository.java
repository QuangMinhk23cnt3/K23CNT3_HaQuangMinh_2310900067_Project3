package k23cnt3_hqmDay06.repository;


import k23cnt3_hqmDay06.entity.Student;
import
        org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends
        JpaRepository<Student, Long> {
}
