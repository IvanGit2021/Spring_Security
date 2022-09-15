package academy.mindswap.exercise.exercise.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String city;
    private Integer age;
    private String email;
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicleList;

    @ManyToMany(mappedBy = "personList",fetch = FetchType.EAGER)
    private List<Role> roles;

    public Person() {
    }
}
