package com.manoj.oodesign.LogisticSystem.domain;

import com.manoj.oodesign.LogisticSystem.enumeration.PaymentMode;
import com.manoj.oodesign.LogisticSystem.enumeration.PaymentStatus;

public class PaymentDetails {
    private String transactionId;
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String cardNumber;

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
