package academy.mindswap.exercise.exercise.config;

import academy.mindswap.exercise.exercise.model.Person;
import academy.mindswap.exercise.exercise.model.Role;
import academy.mindswap.exercise.exercise.model.RoleTypes;
import academy.mindswap.exercise.exercise.repository.PersonRepository;
import academy.mindswap.exercise.exercise.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository, PasswordEncoder encoder, RoleRepository roleRepository) {
        return args -> {
            Person person1 = Person.builder()
                    .name("Maria")
                    .age(24)
                    .email("a@gmail.com")
                    .password(encoder.encode("azerty"))
                    .build();
            personRepository.save(person1);


//          personRepository.save(new Person()); or this way (without builder)

            Person person2 = Person.builder()
                    .name("Maria")
                    .age(24)
                    .email("b@gmail.com")
                    .password(encoder.encode("qwerty"))
                    .build();
            personRepository.save(person2);


            Role role1 = Role.builder()
                    .type(RoleTypes.ROLE_ADMIN.toString())
                    .personList(List.of(person1))
                    .build();
            roleRepository.save(role1);

            Role role2 = Role.builder()
                    .type(RoleTypes.ROLE_USER.toString())
                    .personList(List.of(person1, person2))
                    .build();
            roleRepository.save(role2);
        };
    }
}


