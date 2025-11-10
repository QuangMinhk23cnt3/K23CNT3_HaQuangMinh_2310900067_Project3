package k23cnt3_hqmDay03.controller;


import k23cnt3_hqmDay03.entity.HqmStudent;
import k23cnt3_hqmDay03.service.HqmServiceStudent;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class HqmStudentController {
    @Autowired
    public HqmServiceStudent hqmServiceStudent;

    @GetMapping("/student-list")
    public List<HqmStudent> getAllStudents() {
        return  hqmServiceStudent.getHqmStudents();
    }

    @GetMapping("/student/{hqmId}")
    public HqmStudent getHqmStudentById(@PathVariable String hqmId)
    {
        Long param = Long.parseLong(hqmId);
        return  hqmServiceStudent.getHqmStudent(param);
    }

    public HqmStudent addStudent(HqmStudent student){
        students.add(student);
        return student;
    }

}
