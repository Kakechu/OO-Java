package Events;

import Utilities.*;

import Park.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManager {
    public Scanner scanner = new Scanner(System.in);
    private Park park;
    private List<Event> events;
    //private List<Ticket> tickets = new ArrayList<>();

    public EventManager(Park park) {
        this.events = new ArrayList<>();
        this.park = park;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void planEvent(Park park) {
        Event event = null;
        System.out.println("Event types: ");
        System.out.println("1. Flying Show");
        System.out.println("2. Swimming Show");
        System.out.println("3. Dance Show");
        System.out.println("4. Cancel");
        int choice = Helper.getValidInt("Choose type: ");
        System.out.println("Event name: ");
        String name = scanner.nextLine();
        int availableTickets = Helper.getValidInt("Amount of tickets available: ");
        switch (choice) {
            case 1:event = new FlyingShow(park, name, availableTickets); break;
            case 2: event = new SwimmingShow(park, name, availableTickets); break;
            case 3: event = new DanceShow(park, name, availableTickets); break;
            case 4: return;
        }

        addEvent(event);
    }

    public void listEvents() {
        for (Event event : events) {
            System.out.println(event);
            System.out.println("");
        }
    }

    public void buyEventTicket() {
        System.out.println("Our events: ");
        listEvents();
        System.out.println("Choose an event: ");
        String eventName = scanner.nextLine();
        Event e = findEvent(eventName);
        int ticketAmount = Helper.getValidInt("Number of tickets: ");
        e.buyTicket(ticketAmount);

    }

    private Event findEvent(String eventName) {
        for (Event e : this.events) {
            if (e.getEventName().equalsIgnoreCase(eventName)) {
                return e;
            }
        }
        return null;

    }

    public void startEvent(String eventName) {
        Event e = findEvent(eventName);
        e.startEvent();
    }


    public void readEventsFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("events.txt"));

        while (scanner.hasNext()) {
            try {
                String eventName = scanner.nextLine();  // Tapahtuman nimi
                int availableTickets = Integer.parseInt(scanner.nextLine());  // Lippujen määrä
                String eventType = scanner.nextLine().toLowerCase();  // Tapahtuman tyyppi

                Event event = null;

                // Määritetään tapahtuman tyyppi ja luodaan vastaava olio
                switch (eventType) {
                    case "flying":
                        event = new FlyingShow(this.park, eventName, availableTickets);
                        break;
                    case "swimming":
                        event = new SwimmingShow(this.park, eventName, availableTickets);
                        break;
                    case "dancing":
                        event = new DanceShow(this.park, eventName, availableTickets);
                        break;
                    default:
                        System.out.println("Unknown event type: " + eventType);
                        continue;  // Jos tyyppi on tuntematon, siirry seuraavaan tapahtumaan
                }

                addEvent(event);  // Lisää tapahtuma listalle
                System.out.println("Event loaded: " + eventName + " (" + eventType + ") with " + availableTickets + " tickets.");
            } catch (NumberFormatException e) {
                System.out.println("Error parsing available tickets for event.");
                // Ohita virheelliset rivit ja siirry seuraavaan tapahtumaan
                if (scanner.hasNextLine()) scanner.nextLine();
                if (scanner.hasNextLine()) scanner.nextLine();
            }
        }

        scanner.close();
    }
}