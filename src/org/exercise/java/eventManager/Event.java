package org.exercise.java.eventManager;

import java.time.LocalDate;

public class Event {
    // constants
    protected final int INITIAL_RESERVED_SEATS = 0;
    protected LocalDate TODAY_DATE = LocalDate.now();

    // attributes
    protected String nameEvent;
    protected LocalDate dateEvent;
    protected final int totalSeats;
    protected int reservedSeats;

    // constructor


    public Event(String nameEvent, LocalDate dateEvent, int totalSeats) throws EventExceptions{
        if (totalSeats <= 0){
            throw new EventExceptions("invalid number of seats, need a positive number");
        } else if (dateEvent.isBefore(TODAY_DATE)) {
            throw new EventExceptions("we don't have a time machine, insert a date in the future");
        }
        this.nameEvent = nameEvent;
        this.dateEvent = dateEvent;
        this.totalSeats = totalSeats;
        this.reservedSeats = INITIAL_RESERVED_SEATS;
    }

    //getter & setter
        // name event
        public String getNameEvent() {
            return nameEvent;
        }

        public void setNameEvent(String nameEvent) {
            this.nameEvent = nameEvent;
        }

        // date event
        public LocalDate getDateEvent() {
            return dateEvent;
        }

        public void setDateEvent(LocalDate dateEvent) {
            this.dateEvent = dateEvent;
        }

        // seats info
        public int getTotalSeats() {
            return totalSeats;
        }

        public int getReservedSeats() {
            return reservedSeats;
        }

    // methods

    public void toReserve(int n){
        if (dateEvent.isBefore(TODAY_DATE)){
            throw new EventExceptions("your a little too late for this event, choose another one");
        } else if (n > getAvailableSeats()) {
            throw new EventExceptions("there are too many people, choose who comes and who not");
        }
        this.reservedSeats += n;
    }

    public void toCancelReservation(int n) {
        if (dateEvent.isBefore(TODAY_DATE)){
            throw new EventExceptions("the event already happened");
        } else if (n > this.reservedSeats) {
            throw new EventExceptions("there are too few people");
        }
        this.reservedSeats -= n;
    }


    public int getAvailableSeats() {
        return this.totalSeats - this.reservedSeats;
    }


    // overrides
    @Override
    public String toString() {
        return "Event{" +
                "nameEvent='" + nameEvent + '\'' +
                ", dateEvent=" + dateEvent +
                '}';
    }


}
