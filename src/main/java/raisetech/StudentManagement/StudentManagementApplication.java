package raisetech.StudentManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.Student;
import raisetech.StudentManagement.StudentRepository;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

    @Autowired
    private StudentRepository repository;

    private String name ="Fujitaka Jubiro";
    private String age = "60";

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    @GetMapping("/student")
    public String getStudentInfo() {
        Student student = repository.searchByName("TakahasiRyouji");
        return student.getName() + " " + student.getAge() + "歳";
        //提出
    }

    @PostMapping("/student")
    public void registerStudent(String name,String age) {
        this.name = name;
        this.age = age;
    }

    @PatchMapping("/student")
    public void updateStudent(String name, int age) {
        repository.updateStudent(name, age);
    }

    @DeleteMapping("/student")
    public void deleteStudent(String name) {
        repository.deleteStudent(name);
    }
}