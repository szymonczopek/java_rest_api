package sc.rest_api.entities;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonView
    private String name;

    @JsonView
    private String surname;

    @JsonView
    private Double average;

//    public Student() {
//
//    }
//
//    public Student(String name, String surname, Double average) {
//        this.name = name;
//        this.surname = surname;
//        this.average = average;
//    }

//    @Override
//    public String toString() {
//        return "Student{ id=" + id + ", " + "name=" + name + ", "
//                + "surname=" + surname + ", " + "average=" + average + "}";
//    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public Double getAverage() {
//        return average;
//    }
//
//    public void setAverage(Double average) {
//        this.average = average;
//    }
}
