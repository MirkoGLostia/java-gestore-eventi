package org.exercise.java.eventManager;

import java.time.LocalDate;
import java.util.Scanner;

public class MainEventDealer {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        // variables and arrays
        boolean exitCode = false;
        String eventName;
        LocalDate eventDate;
        int numberOfSeats;
        Event userEvent;
        int seatModifierChoice;


        do {
            // Event builder
            System.out.println("Name of the event?");
            eventName = userInput.nextLine();

            System.out.println("When is the event? (yyyy-MM-dd)");
            eventDate = LocalDate.parse(userInput.nextLine());

            System.out.println("How many seats are in the place of the event?");
            numberOfSeats = Integer.parseInt(userInput.nextLine());

            try {
                userEvent = new Event(eventName, eventDate, numberOfSeats);

                // seats manager
                do {
                    System.out.println(" ");
                    System.out.println("There are " + userEvent.getReservedSeats() + " reserved seats out of " + userEvent.getTotalSeats() + " seats");
                    System.out.println(" ");
                    System.out.println(userEvent.getAvailableSeats() + " seats are still available");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Do you want to (1) reserve seats, (2) cancel reservations or (3) exit?");
                    seatModifierChoice = Integer.parseInt(userInput.nextLine());

                    try {
                    switch (seatModifierChoice) {
                        case 1:
                            System.out.print("number of seats: ");
                            userEvent.toReserve(Integer.parseInt(userInput.nextLine()));
                            break;
                        case 2:
                            System.out.print("number of seats: ");
                            userEvent.toCancelReservation(Integer.parseInt(userInput.nextLine()));
                            break;
                        case 3:
                            exitCode = true;
                            System.out.println(userEvent);
                            break;
                        default:
                            System.out.println("invalid input");
                            break;
                    }
                    }catch (EventExceptions e){
                        System.out.println(e.getMessage());
                    }

                }while (!exitCode);

            }catch (EventExceptions e){
                System.out.println(e.getMessage());
            }


        }while (!exitCode);







        userInput.close();
    }
}
