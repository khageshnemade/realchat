package com.chatapp.realchat.config;

import com.chatapp.realchat.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();
    private int idCounter = 1;

    // Create
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        student.setId(idCounter++);
        students.add(student);
        return student;
    }

    // Read all
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // Read one
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                return student;
            }
        }
        return null;
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        return removed ? "Student deleted" : "Student not found";
    }
}
