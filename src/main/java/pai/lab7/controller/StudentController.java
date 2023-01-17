package pai.lab7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.JstlUtils;
import pai.lab7.entity.Student;
import pai.lab7.exception.StudentNotFoundException;
import pai.lab7.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @CrossOrigin("http://localhost:63342")
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll(){

        return ResponseEntity.ok().body(
                studentService.getAll());
    }

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin("http://localhost:63342")
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().body("Student został usunięty");
        } catch (StudentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @CrossOrigin("http://localhost:63342")
    @PutMapping("/student")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){

        try {
            studentService.updateStudent(student);
            return ResponseEntity.ok().body("Student został zaktualizowany");
        } catch (StudentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

