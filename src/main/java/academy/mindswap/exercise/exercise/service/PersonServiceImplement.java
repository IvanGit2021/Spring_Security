package academy.mindswap.exercise.exercise.service;

import academy.mindswap.exercise.exercise.command.person.PersonDto;
import academy.mindswap.exercise.exercise.command.person.PersonDtoConverter;
import academy.mindswap.exercise.exercise.command.person.PersonDtoModel;
import academy.mindswap.exercise.exercise.command.vehicle.VehicleDto;
import academy.mindswap.exercise.exercise.command.vehicle.VehicleDtoConverter;
import academy.mindswap.exercise.exercise.command.vehicle.VehicleDtoModel;
import academy.mindswap.exercise.exercise.exception.BadRequestException;
import academy.mindswap.exercise.exercise.exception.PersonNotFoundException;
import academy.mindswap.exercise.exercise.model.Person;
import academy.mindswap.exercise.exercise.model.Vehicle;
import academy.mindswap.exercise.exercise.repository.PersonRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImplement implements PersonService {

    private final PersonRepository personRepository;
    private final VehicleServiceImplement vehicleService;

    private final PasswordEncoder encoder;

    public PersonServiceImplement(PersonRepository personRepository, VehicleServiceImplement vehicleService, PasswordEncoder encoder) {
        this.personRepository = personRepository;
        this.vehicleService = vehicleService;
        this.encoder = encoder;
    }

    @Override
    public List<PersonDto> getAllPerson() {
        return personRepository.findAll()
                .stream()
                    .map(PersonDtoConverter::convertToDto)
                        .collect(Collectors.toList());
    }

    @Override
    public PersonDto addPerson(PersonDtoModel personDtoModel) {

       personDtoModel.setEmail(encoder.encode(personDtoModel.getPassword()));
       Person person = PersonDtoConverter.convertToPersonModel(personDtoModel);
       personRepository.save(person);
       return PersonDtoConverter.convertToDto(person);
    }

    @Override
    public VehicleDto addVehicle(VehicleDtoModel vehicle, Integer personId) {
        Person person = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        Vehicle vehicle1 = VehicleDtoConverter.convertToVehicleModel((vehicle));
        vehicle1.setOwner(person);
        person.getVehicleList().add(vehicle1);
        personRepository.save(person);
        return vehicleService.saveVehicle(vehicle1);

    }

    @Override
    public PersonDto findById(Integer id) {
        if (id == null) throw new BadRequestException();
        return PersonDtoConverter.convertToDto(personRepository.findById(id).orElseThrow(PersonNotFoundException::new));
    }

    public Optional<Person> findByEmail(String email) {
        return personRepository.findByEmail(email);
    }


    @Override
    public void deletePerson(Integer personId) {
        Person person = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
         personRepository.deleteById(personId);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}
