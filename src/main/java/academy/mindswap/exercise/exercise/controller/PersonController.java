package academy.mindswap.exercise.exercise.controller;

import academy.mindswap.exercise.exercise.command.person.PersonDto;
import academy.mindswap.exercise.exercise.command.person.PersonDtoModel;
import academy.mindswap.exercise.exercise.command.vehicle.VehicleDto;
import academy.mindswap.exercise.exercise.command.vehicle.VehicleDtoModel;
import academy.mindswap.exercise.exercise.service.PersonServiceImplement;
import com.sun.istack.FinalArrayList;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {

    private final Logger LOGGER =  LoggerFactory.getLogger(PersonController.class);
    private final PersonServiceImplement personService;

    public PersonController(PersonServiceImplement personService) {
        this.personService = personService;
    }

    @GetMapping  //get All Person
    public ResponseEntity<List<PersonDto>> getAllPerson() {
        LOGGER.info("Get person from Database");
         List<PersonDto> personList = personService.getAllPerson();
         return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/vehicles") // Get all vehicles
    public List<VehicleDto> getAllVehicles () {
        return personService.getAllVehicles();
    }


    @GetMapping("/{id}")  //get person By Id
    public ResponseEntity<PersonDto> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")  //add Person
    public ResponseEntity<?> addPerson(@Valid @RequestBody PersonDtoModel personDtoModel, BindingResult result) {
        personService.addPerson(personDtoModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{personId}") //delete Person
    public ResponseEntity<PersonDto> deletePerson (@PathVariable Integer personId) {

        personService.deletePerson(personId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/addVehicleToPerson/{personId}")  // add Vehicle to Person
    public VehicleDto addVehicle(@RequestBody VehicleDtoModel vehicleDtoModel, @PathVariable Integer personId) {
        return personService.addVehicle(vehicleDtoModel, personId);
    }




}
