package org.exercise.java.eventManager.bonus;

import org.exercise.java.eventManager.Event;
import org.exercise.java.eventManager.EventExceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEvent {
    // attributes
    private String title;
    private List<Event> events;


    // constructor

    public ProgrammEvent(String title) {
        this.title = title;
        this.events = new ArrayList<>();
    }


    // methods

    public void setNewListElement (Event x) {
        events.add(x);
    }

    public List<Event> getListEventByDate (LocalDate date) throws EventExceptions{
        List<Event> filteredList = new ArrayList<>();
        for (Event ev : events) {
            if (ev.getDateEvent().isEqual(date)){
                filteredList.add(ev);
            }
        }
        if (filteredList.isEmpty()) {
            throw new EventExceptions("no events for this date");
        }
        return  filteredList;
    }

    public int getHowManyEvents () {
        return events.size();
    }

    public void setClearList () {
        this.events = new ArrayList<>();
    }

    public void getAllEvents () {
        System.out.println(this.title);
        for (Event ev : events) {
            System.out.println("   " + ev.getDateEvent() + " " + ev.getNameEvent());
        }
    }
}
