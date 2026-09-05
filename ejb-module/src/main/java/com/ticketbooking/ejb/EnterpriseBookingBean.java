package com.ticketbooking.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class EnterpriseBookingBean {

    public String healthCheck() {

        return "EJB module is running";
    }

    public double calculateTotal(
            int seats,
            double pricePerSeat
    ) {

        if (seats <= 0 || pricePerSeat < 0) {

            throw new IllegalArgumentException(
                    "Invalid booking values"
            );
        }

        return seats * pricePerSeat;
    }
}