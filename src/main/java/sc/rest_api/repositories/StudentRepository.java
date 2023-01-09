package sc.rest_api.repositories;

import sc.rest_api.entities.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    public Student findStudentById(Integer id);

    public List<Student> findByOrderByIdAsc();
}