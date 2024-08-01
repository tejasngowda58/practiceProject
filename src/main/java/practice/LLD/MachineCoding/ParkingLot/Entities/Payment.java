package practice.LLD.MachineCoding.ParkingLot.Entities;

import java.util.Date;

public class Payment {
    int id;
    int referenceNumber;
    PaymentMode paymentMode;
    Date time;
    float amount;
    PaymentStatus paymentStatus;
}
