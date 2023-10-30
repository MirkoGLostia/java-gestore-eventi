package org.exercise.java.eventManager.bonus;

import org.exercise.java.eventManager.Event;
import org.exercise.java.eventManager.EventExceptions;

import java.time.LocalDate;

public class MainBonus {
    public static void main(String[] args) {
        // debug elements
            // events
            Event event1 = new Event("event 1", LocalDate.of(2024, 12, 10), 100);
            Event event2 = new Event("event 2", LocalDate.of(2027, 7, 15), 120);
            Event event3 = new Event("event 3", LocalDate.of(2025, 6, 20), 80);

            // variables
            LocalDate presentDateInList = LocalDate.of(2027, 7, 15);
            LocalDate absentDateInList = LocalDate.of(2030, 12, 10);

        // list
        ProgrammEvent listOfEvents = new ProgrammEvent("list 1");

        // adding elements to the list
        listOfEvents.setNewListElement(event1);
        listOfEvents.setNewListElement(event2);
        listOfEvents.setNewListElement(event3);


        // check search by date
        System.out.println("We search an element by this date: " + presentDateInList);
        try {
            System.out.println(listOfEvents.getListEventByDate(presentDateInList));
        } catch (EventExceptions e) {
            System.out.println(e.getMessage());
        }

        System.out.println("We search an element by this date: " + absentDateInList);
        try {
            System.out.println(listOfEvents.getListEventByDate(absentDateInList));
        } catch (EventExceptions e) {
            System.out.println(e.getMessage());
        }

        System.out.println(" ");
        System.out.println("*****************************");
        System.out.println(" ");


        // check method to see all elements
        System.out.println("this are all the events of the list:");
        listOfEvents.getAllEvents();
        System.out.println(" ");
        System.out.println("****************");
        System.out.println(" ");


        // check method for how many elements
        System.out.println("How many elements are in the array?");
        System.out.println("there are this many elements: " + listOfEvents.getHowManyEvents());

        // check method to clear the list
        listOfEvents.setClearList();
        System.out.println(" ");
        System.out.println("after clear: " + listOfEvents.getHowManyEvents());




    }
}
