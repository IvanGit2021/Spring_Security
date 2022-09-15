package academy.mindswap.exercise.exercise.command.vehicle;

import academy.mindswap.exercise.exercise.command.person.PersonDto;
import academy.mindswap.exercise.exercise.command.person.PersonDtoModel;
import academy.mindswap.exercise.exercise.model.Person;
import academy.mindswap.exercise.exercise.model.Vehicle;

public class VehicleDtoConverter {

    public static Vehicle convertToVehicleModel (VehicleDtoModel vehicleDtoModel) {
        return Vehicle.builder()
                .brand(vehicleDtoModel.getBrand())
                .model(vehicleDtoModel.getModel())
                .owner(vehicleDtoModel.getOwner())
                .build();
    }

    public static VehicleDto convertToDto (Vehicle vehicle) {
        return VehicleDto.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .build();
    }
}
