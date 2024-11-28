package Events;

import Park.Park;

public class Event {
    private String eventName;
    private int availableTickets;
    private int purchasedTickets;
    Park park;

    public Event(Park park, String eventName, int availableTickets) {
        this.eventName = eventName;
        this.availableTickets = availableTickets;
        this.purchasedTickets = 0;
        this.park = park;

    }

    public String getEventName() {
        return eventName;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public int getPurchasedTickets() {
        return purchasedTickets;
    }

    public boolean buyTicket(int ticketAmount) {
        if (ticketAmount <= availableTickets) {
            // Vähennetään ostettujen lippujen määrä
            availableTickets -= ticketAmount;
            purchasedTickets += ticketAmount;
            System.out.println(ticketAmount + " tickets bought for event: " + eventName);
            return true;
        } else {
            // Jos ei ole tarpeeksi lippuja saatavilla
            System.out.println("Not enough tickets available. Only " + availableTickets + " tickets left for this event.");
            return false;
        }
    }

    public void startEvent() {
        if (purchasedTickets >= 5) {
            System.out.println("Event " + eventName + " is starting!");
            performEvent();
        } else {
            System.out.println("Not enough tickets sold. At least 5 tickets are required to start the event.");
        }
    }

    public void performEvent() {
    }


    public String toString() {
        return "Event: " + getEventName() +
                "\nAvailable Tickets: " + getAvailableTickets() +
                "\nPurchased Tickets: " + getPurchasedTickets();
    }
}
