package academy.mindswap.exercise.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@ToString(exclude = "owner")
@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    @ManyToOne
    @JsonIgnore
    private Person owner;

    public Vehicle() {
    }
}
