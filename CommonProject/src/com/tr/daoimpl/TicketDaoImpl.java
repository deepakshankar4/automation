package com.tr.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.dao.TicketDao;
import com.tr.model.Ticket;

@Repository("ticketDao")
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTicket(Ticket ticket) {

		sessionFactory.getCurrentSession().saveOrUpdate(ticket);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> listTicketes() {
		return (List<Ticket>) sessionFactory.getCurrentSession()
				.createCriteria(Ticket.class).list();
	}

	@Override
	public Ticket getTicket(int ticketid) {
		return (Ticket) sessionFactory.getCurrentSession().get(Ticket.class,
				ticketid);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		sessionFactory.getCurrentSession()
				.createQuery("UPDATE Ticket SET service='SERVICED' WHERE ticketid="+ticket.getTicketid())
				.executeUpdate();
	}
}