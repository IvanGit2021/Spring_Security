package academy.mindswap.exercise.exercise.repository;

import academy.mindswap.exercise.exercise.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
