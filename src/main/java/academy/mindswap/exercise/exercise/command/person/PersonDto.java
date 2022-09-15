package academy.mindswap.exercise.exercise.command.person;

import academy.mindswap.exercise.exercise.model.Vehicle;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Builder
@Data
public class PersonDto {

    private Integer id;
    private String name;
    private String city;
    private Integer age;
    private String email;
    private List<Vehicle> vehicleList;
}
