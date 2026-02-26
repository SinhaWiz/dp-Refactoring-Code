package edu.iutcs.cr.persons;

import java.io.Serializable;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Buyer extends Person implements Serializable {

    private String paymentMethod;

    public Buyer(String name, String id, String email, String paymentMethod) {
        super(name, id, email);
        this.paymentMethod = paymentMethod;
    }

    /** Lookup-only constructor — only id is required for equality checks. */
    public Buyer(String id) {
        super(id);
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", paymentMethod='" + paymentMethod + '\'';
    }
}
