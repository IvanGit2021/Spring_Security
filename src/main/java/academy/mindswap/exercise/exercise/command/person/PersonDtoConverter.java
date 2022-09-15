package academy.mindswap.exercise.exercise.command.person;

import academy.mindswap.exercise.exercise.model.Person;

public class PersonDtoConverter {

    public static Person convertToPersonModel (PersonDtoModel personDtoModel) {
        return Person.builder()
                .id(personDtoModel.getId())
                .name(personDtoModel.getName())
                .city(personDtoModel.getCity())
                .age(personDtoModel.getAge())
                .email(personDtoModel.getEmail())
                .password(personDtoModel.getPassword())
                .build();
    }

    public static PersonDto convertToDto (Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .city(person.getCity())
                .age(person.getAge())
                .email(person.getEmail())
                .vehicleList(person.getVehicleList())
                .build();
    }
}
