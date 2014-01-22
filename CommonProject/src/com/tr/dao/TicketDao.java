package com.tr.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.Ticket;

@Transactional
public interface TicketDao {

	public void addTicket(Ticket ticket);

	public List<Ticket> listTicketes();

	public Ticket getTicket(int ticketid);

	public void deleteTicket(Ticket ticket);

}
