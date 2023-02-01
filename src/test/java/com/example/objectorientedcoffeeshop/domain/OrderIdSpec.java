package com.example.objectorientedcoffeeshop.domain;

import com.example.objectorientedcoffeeshop.domain.id.IdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderIdSpec {
    @Test
    public void 주문_ID를_만들어보기() {
        OrderId orderId = new OrderId();
        assertNotNull(orderId);
    }

    @Test
    public void 테스트용_주문_ID를_만들어보기() {
        OrderId orderId = new OrderId(new FixedStringIdGenerator("RANDOM_123"));
        assertEquals("RANDOM_123", orderId.value());
    }

    public static class FixedStringIdGenerator implements IdGenerator<String> {
        private final String fixedId;

        public FixedStringIdGenerator(String fixedId) {
            this.fixedId = fixedId;
        }

        @Override
        public String next() {
            return this.fixedId;
        }
    }
}
