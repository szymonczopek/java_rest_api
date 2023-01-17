package pai.lab7.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pai.lab7.entity.Student;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

  Optional<Student> findStudentById(Long id);

  @Modifying
  @Query("update student set name = :name, surName = :surname, average = :average where id = :id")
  void updateStudentDataWithNewName(
      @Param("name") String name,
      @Param("surname") String surname,
      @Param("average") Double average,
      @Param("id") Long id);
}
