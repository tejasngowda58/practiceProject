package practice.LLD.MachineCoding.ParkingLot.Entities;

import java.util.Date;

public class Token {
    int id;
    int tokenNumber;
    Gate gate;
    Date entryTime;
    Operator operator;
    ParkingSlot parkingSlot;
    Vehicle vehicle;
}
