package academy.mindswap.exercise.exercise.service;

import academy.mindswap.exercise.exercise.command.vehicle.VehicleDto;
import academy.mindswap.exercise.exercise.command.vehicle.VehicleDtoConverter;
import academy.mindswap.exercise.exercise.model.Vehicle;
import academy.mindswap.exercise.exercise.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImplement implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImplement(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public VehicleDto saveVehicle(Vehicle vehicle) {
        return VehicleDtoConverter.convertToDto(vehicleRepository.save(vehicle));
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
