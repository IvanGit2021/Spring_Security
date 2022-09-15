package academy.mindswap.exercise.exercise.service;

import academy.mindswap.exercise.exercise.command.person.PersonDto;
import academy.mindswap.exercise.exercise.command.person.PersonDtoModel;
import academy.mindswap.exercise.exercise.command.vehicle.VehicleDto;
import academy.mindswap.exercise.exercise.command.vehicle.VehicleDtoModel;
import academy.mindswap.exercise.exercise.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<PersonDto> getAllPerson();

    PersonDto addPerson(PersonDtoModel personDtoModel);

    VehicleDto addVehicle(VehicleDtoModel vehicle, Integer personId);

    PersonDto findById(Integer id);

    void deletePerson(Integer personId);

    public Optional<Person> findByEmail(String email);

    List<VehicleDto> getAllVehicles();
}
