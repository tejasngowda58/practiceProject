package practice.LLD.MachineCoding.ParkingLot.Entities;

import java.util.Date;
import java.util.List;

public class Invoice {
    int id;
    int invoiceNumber;
    Date entryTime;
    Date exitTime;
    float amount;
    Gate exitGate;
    Operator operator;
    FeeCalculationStrategy feeCalculationStrategy;
    List<Payment> payments;
}
