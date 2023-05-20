package fit5171.monash.edu.collection;

import fit5171.monash.edu.entity.Ticket;

import java.util.ArrayList;

public class TicketCollection {

	public static ArrayList<Ticket> tickets = new ArrayList<>();

	private TicketCollection() {
	}

	public static void addTickets(ArrayList<Ticket> tickets_db) throws IllegalArgumentException {
//		TicketCollection.tickets.addAll(tickets_db);

		for (Ticket ticket : tickets_db) {
			if (ticket.getTicket_id() <= 0) {
				throw new IllegalArgumentException("Invalid ticket ID: " + ticket.getTicket_id());
			}
		}
		TicketCollection.tickets.addAll(tickets_db);
	}

	public static void getAllTickets() {
		// display all available tickets from the Ticket collection
		for (Ticket ticket : tickets) {
			System.out.println(ticket);
		}
	}

	public static Ticket getTicketInfo(int ticket_id) {
		// SELECT a ticket where ticket id = ticket_id
		for (Ticket ticket : tickets) {
			if (ticket.getTicket_id() == ticket_id) {
				return ticket;
			}
		}
		return null;
	}

}
