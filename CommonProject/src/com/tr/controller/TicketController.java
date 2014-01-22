package com.tr.controller;

import com.tr.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tr.model.Ticket;
import com.tr.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;

	Employee employee;

	@RequestMapping(value = "/saveticket", method = RequestMethod.POST)
	public ModelAndView saveTicket(
			@ModelAttribute("command") Ticket ticketBean, BindingResult result) {
		Ticket ticket = prepareModel(ticketBean);
		try {
			ticketService.addTicket(ticket);
		} catch (Exception e) {
			return new ModelAndView("redirect:/exception.html");
		}
		return new ModelAndView("redirect:/addticket.html");
	}

	@RequestMapping(value = "/saveticketuser", method = RequestMethod.POST)
	public ModelAndView saveTicketUser(
			@ModelAttribute("command") Ticket ticketBean, BindingResult result) {
		Ticket ticket = prepareModel(ticketBean);
		try {
			ticketService.addTicket(ticket);
		} catch (Exception e) {
			return new ModelAndView("redirect:/exception.html");
		}
		return new ModelAndView("redirect:/ticketuser.html");
	}

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public ModelAndView listTickets() { 
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tickets", prepareListofBean(ticketService.listTicketes()));
		return new ModelAndView("ticketsList", model); 
	}

	@RequestMapping(value = "/addticket", method = RequestMethod.GET)
	public ModelAndView addTicket(
			@ModelAttribute("command") Ticket ticketBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tickets", prepareListofBean(ticketService.listTicketes()));
		return new ModelAndView("addTicket", model);

	}

	@RequestMapping(value = "/ticketuser", method = RequestMethod.GET)
	public ModelAndView addTicketUser(
			@ModelAttribute("command") Ticket ticketBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("addTicketUser", model);

	}

	@RequestMapping(value = "/serviceticket", method = RequestMethod.GET)
	public ModelAndView editTicket(
			@ModelAttribute("command") Ticket ticketBean, BindingResult result) {
		ticketService.deleteTicket(prepareModel(ticketBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tickets", prepareListofBean(ticketService.listTicketes()));
		return new ModelAndView("addTicket", model);

	}

	@RequestMapping(value = "/editticket", method = RequestMethod.GET)
	public ModelAndView deleteTicket( 
			@ModelAttribute("command") Ticket ticketBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ticket", prepareTicketBean(ticketService
				.getTicket(ticketBean.getTicketid())));
		model.put("tickets", prepareListofBean(ticketService.listTicketes()));
		return new ModelAndView("addTicketEdit", model);
	}

	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("exception");

	}

	private Ticket prepareModel(Ticket ticketBean) {
		Ticket ticket = new Ticket();
		ticket.setTicketid(ticketBean.getTicketid());
		ticket.setTicketname(ticketBean.getTicketname());
		ticket.setTempID(ticketBean.getTempID());
		ticket.setService(ticketBean.getService());
		ticketBean.setTicketid(null);
		return ticket;
	}

	private List<Ticket> prepareListofBean(List<Ticket> tickets) {
		List<Ticket> beans = null;
		if (tickets != null && !tickets.isEmpty()) {
			beans = new ArrayList<Ticket>();
			Ticket bean = null;
			for (Ticket ticket : tickets) {
				bean = new Ticket();
				bean.setTicketid(ticket.getTicketid());
				bean.setTicketname(ticket.getTicketname());
				bean.setTempID(ticket.getTempID());
				bean.setService(ticket.getService());
				beans.add(bean);
			}
		}
		return beans;
	}

	private Ticket prepareTicketBean(Ticket ticket) {
		Ticket bean = new Ticket();
		bean.setTicketid(ticket.getTicketid());
		bean.setTicketname(ticket.getTicketname());
		bean.setTempID(ticket.getTempID());
		bean.setService(ticket.getService());
		return bean;
	}
}
