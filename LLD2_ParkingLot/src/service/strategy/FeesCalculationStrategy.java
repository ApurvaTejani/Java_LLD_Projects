package service.strategy;

import Models.enums.VehicleType;

import java.util.Date;

public interface FeesCalculationStrategy {
    Double calculateAmount(Date entryTime, Date exitTime, VehicleType vehicleType);
}
