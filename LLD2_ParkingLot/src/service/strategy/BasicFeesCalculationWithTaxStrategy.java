package service.strategy;

import Models.enums.VehicleType;

import java.util.Date;

public class BasicFeesCalculationWithTaxStrategy implements FeesCalculationStrategy {
    @Override
    public Double calculateAmount(Date entryTime, Date exitTime, VehicleType vehicleType) {
        Double baseFare=0.0;
        long mul=0;
        long diff=exitTime.getTime()-entryTime.getTime();// Returns msec
        mul= diff/(60*60*1000);
        if(vehicleType.equals(VehicleType.SMALL)){
            baseFare=30.0;
            baseFare=(int)mul*baseFare;
        }
        else if(vehicleType.equals(VehicleType.MEDIUM)){
            baseFare=50.0;
            baseFare=(int)mul*baseFare*1.50;
        }
        else if(vehicleType.equals(VehicleType.HEAVY)){
            baseFare=80.0;
            baseFare=(int)mul*baseFare*1.70;
        }
        return baseFare;
    }
}
