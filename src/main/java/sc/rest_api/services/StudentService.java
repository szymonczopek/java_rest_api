package sc.rest_api.services;

import sc.rest_api.entities.Student;
import sc.rest_api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentList() {
        return (List<Student>) studentRepository.findByOrderByIdAsc();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public boolean isInteger(String id) {
        if (!id.isEmpty()) {
            try {
                Integer i = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                // parsowanie się nie powiodło
                return false;
            }
            // parsowanie się powiodło
            return true;
        }
        // podany String jest pusty ("")
        return false;
    }

    public void deleteStudent(String id) {
        if (isInteger(id)) {
            Integer idStudent = Integer.parseInt(id);
            if (studentRepository.existsById(idStudent)) {
                studentRepository.deleteById(idStudent);
            }
        }
    }

    public void updateStudent(Student student, String id) {
        if (isInteger(id)) {
            Integer idStudent = Integer.parseInt(id);
            if (studentRepository.existsById(idStudent)) {
                student.setId(idStudent);
                studentRepository.save(student);
            }
        }
    }

    public Student getStudentById(String id) {
        if (isInteger(id)) {
            Integer idStudent = Integer.parseInt(id);
            if (studentRepository.existsById(idStudent)) {
                return studentRepository.findStudentById(idStudent);
            }
        }
        return null;
    }

}