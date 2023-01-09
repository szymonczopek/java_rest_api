package sc.rest_api.controllers;

import sc.rest_api.entities.Student;
import sc.rest_api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String studentsListPage() {
        // zwrócenie widoku - studentsList.html
        return "studentsList";
    }

    @GetMapping("/addStudentPage")
    public String addStudentPage() {
        // zwrócenie widoku - addStudent.html
        return "addStudent";
    }

    @GetMapping("/editStudentPage/{id}")
    public String editStudentPage(Model m, @PathVariable String id) {
        // pobranie studenta z bazy danych
        Student student = studentService.getStudentById(id);
        if (student != null) {
            // dodanie do modelu pobranego studenta z bazy danych
            m.addAttribute("student", student);
            // zwrócenie nazwy widoku z edycją danych studenta - editStudent.html
            return "editStudent";
        }
        // zwrócenie widoku - studentsList.html
        return "studentsList";
    }

}
