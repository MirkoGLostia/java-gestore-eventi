package org.exercise.java.eventManager;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    // attributes
    LocalTime timeOfEvent;
    BigDecimal ticketPrice;


    // constructor
    public Concert(String nameEvent, LocalDate dateEvent, int totalSeats, LocalTime timeOfEvent, BigDecimal ticketPrice) throws EventExceptions {
        super(nameEvent, dateEvent, totalSeats);
        this.timeOfEvent = timeOfEvent;
        this.ticketPrice = ticketPrice;
    }


    // getter and setter

        // time of the event
        public LocalTime getTimeOfEvent() {
            return timeOfEvent;
        }

        public void setTimeOfEvent(LocalTime timeOfEvent) {
            this.timeOfEvent = timeOfEvent;
        }

        // price of the ticket
        public BigDecimal getTicketPrice() {
            return ticketPrice;
        }

        public void setTicketPrice(BigDecimal ticketPrice) {
            this.ticketPrice = ticketPrice;
        }


    // methods
    public String getFormatTime () {
        LocalDateTime variable = LocalDateTime.of(getDateEvent(), this.timeOfEvent);
        return variable.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getFormatPrice() {
        DecimalFormat x = new DecimalFormat("#.00");
        return x.format(this.ticketPrice);
    }

    @Override
    public String toString() {
        return "Concert{" +
                "timeOfEvent=" + getFormatTime() +
                ", nameEvent='" + nameEvent  +
                ", ticketPrice=" + getFormatPrice() + '\'' +
                '}';
    }
}
