package org.exercise.java.eventManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainConcertTester {
    public static void main(String[] args) {
        Concert concert1 = new Concert("event1", LocalDate.of(2024, 10, 10), 100, LocalTime.of(10, 10), new BigDecimal("10.2"));

        System.out.println(concert1);
    }
}
