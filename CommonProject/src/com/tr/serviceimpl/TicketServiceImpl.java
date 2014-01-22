package com.tr.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tr.dao.TicketDao;
import com.tr.model.Ticket;
import com.tr.service.TicketService;

@Service("ticketService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTicket(Ticket ticket) {
		ticketDao.addTicket(ticket);
	}

	public List<Ticket> listTicketes() {
		return ticketDao.listTicketes();
	}

	public Ticket getTicket(int ticketid) {
		return ticketDao.getTicket(ticketid);
	}

	public void deleteTicket(Ticket ticket) {
		ticketDao.deleteTicket(ticket);
	}

}
