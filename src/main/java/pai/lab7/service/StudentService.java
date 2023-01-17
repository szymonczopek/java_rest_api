package pai.lab7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pai.lab7.entity.Student;
import pai.lab7.exception.StudentNotFoundException;
import pai.lab7.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAll() {
        return (List<Student>) studentRepository.findAll();
    }

    public void addStudent(Student student) {

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) throws StudentNotFoundException{

        Optional<Student> probablyStudent = studentRepository.findStudentById(id);

        if(probablyStudent.isEmpty())
        {
            throw new StudentNotFoundException(id);
        }
        else{
            studentRepository.delete(probablyStudent.get());
        }
    }
    @Transactional
    public void updateStudent(Student student) throws StudentNotFoundException{

        Optional<Student> probablyStudent = studentRepository.findStudentById(student.getId());

        if(probablyStudent.isEmpty())
        {
      throw new StudentNotFoundException(student.getId());
        }
        else{
      studentRepository.updateStudentDataWithNewName(
          student.getName(), student.getSurName(), student.getAverage(), student.getId());
        }

    }

}
