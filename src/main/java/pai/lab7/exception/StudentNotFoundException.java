package pai.lab7.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long id){
        super("Student o id " + id + " nie istnieje");
    }
}
