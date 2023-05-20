package fit5171.monash.edu.collection;

import fit5171.monash.edu.Util;
import fit5171.monash.edu.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketCollection {

	public static List<Ticket> tickets = new ArrayList<>();

	private TicketCollection() {
	}

	public static void addTickets(List<Ticket> ticketsDb) throws IllegalArgumentException {
		for (Ticket ticket : ticketsDb) {
			if (ticket.getTicketId() <= 0) {
				throw new IllegalArgumentException("Invalid ticket ID: " + ticket.getTicketId());
			}
		}
		TicketCollection.tickets.addAll(ticketsDb);
	}

	public static void getAllTickets() {
		// display all available tickets from the Ticket collection
		for (Ticket ticket : tickets) {
			Util.log(ticket.toString());
		}
	}

	public static Ticket getTicketInfo(int ticketId) {
		// SELECT a ticket where ticket id = ticketId
		for (Ticket ticket : tickets) {
			if (ticket.getTicketId() == ticketId) {
				return ticket;
			}
		}
		return null;
	}

}
