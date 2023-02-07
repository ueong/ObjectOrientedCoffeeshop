package com.example.objectorientedcoffeeshop.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BellSpec {
    @Test
    public void 진동벨_알림을_하면_고객에게_알림이_간다() {
        // given
        NotifyTestCustomer customer = new NotifyTestCustomer();
        Bell bell = new Bell(customer);
        Clerk clerk = new Clerk();

        // when
        bell.notifyCustomer(clerk);

        // then
        assertTrue(customer.isNotified);
        assertEquals(clerk, customer.notifyClerk);
    }

    public static class NotifyTestCustomer extends Customer {
        public boolean isNotified = false;
        public Clerk notifyClerk = null;

        @Override
        public void onDrinkReady(Clerk clerk) {
            isNotified = true;
            this.notifyClerk = clerk;
        }

    }
}
