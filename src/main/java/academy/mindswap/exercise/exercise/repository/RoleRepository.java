package academy.mindswap.exercise.exercise.repository;

import academy.mindswap.exercise.exercise.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
