package Models;

import Models.enums.PaymentMode;
import Models.enums.PaymentStatus;

public class Payment extends BaseClass {
    private PaymentMode paymentMode;
    private long refernceId;
    private int amount;
    private PaymentStatus paymentStatus;
}
