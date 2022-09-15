package academy.mindswap.exercise.exercise.command.person;

import academy.mindswap.exercise.exercise.model.Vehicle;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
public class PersonDtoModel {

    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Must insert city")
    private String city;
    @Min(value = 0, message = "Age must be bigger than 0")
    private Integer age;
    @Email(message = "Please insert a valid email")
    private String email;
    @NotBlank
    @Size(min = 6, message = "Must be more than 6 characters long")
    private String password;
    private Vehicle vehicle;
}
