package com.tr.service;

import java.util.List;

import com.tr.model.Ticket;

public interface TicketService {

	public void addTicket(Ticket ticket);

	public List<Ticket> listTicketes();

	public Ticket getTicket(int ticketid);

	public void deleteTicket(Ticket ticket);

}
