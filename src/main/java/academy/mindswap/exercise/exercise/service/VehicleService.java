package academy.mindswap.exercise.exercise.service;

import academy.mindswap.exercise.exercise.command.vehicle.VehicleDto;
import academy.mindswap.exercise.exercise.model.Vehicle;

import java.util.List;

public interface VehicleService {
    VehicleDto saveVehicle(Vehicle vehicle);

    List<VehicleDto> getAllVehicles();
}
