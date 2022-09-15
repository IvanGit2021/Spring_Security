package academy.mindswap.exercise.exercise.command.vehicle;

import academy.mindswap.exercise.exercise.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Builder
@Data
public class VehicleDtoModel {

    private Integer id;
    private String brand;
    private String model;
    private Person owner;
}
