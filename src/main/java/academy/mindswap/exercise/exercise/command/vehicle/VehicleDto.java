package academy.mindswap.exercise.exercise.command.vehicle;

import academy.mindswap.exercise.exercise.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VehicleDto {

    private Integer id;
    private String brand;
    private String model;
}
