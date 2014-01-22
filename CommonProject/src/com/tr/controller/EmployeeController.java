package com.tr.controller;

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

import com.tr.model.Employee;
import com.tr.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(
			// method used for saving
			@ModelAttribute("command") Employee employeeBean,
			BindingResult result) {
		Employee employee = prepareModel(employeeBean);
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() { // method used for retrieving the data
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",
				prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList", model); // display the contents
															// of model map
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(
			// create or add data
			@ModelAttribute("command") Employee employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",
				prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model); // store n display

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index"); // display welcome page

	}

	// login

	/*
	 * @RequestMapping(value = "/logout", method = RequestMethod.GET) public
	 * ModelAndView logout() { return new ModelAndView("logoutEmployee"); }
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(
			// deletion of row
			@ModelAttribute("command") Employee employeeBean,
			BindingResult result) {
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees",
				prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model); // store n display

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(
			// updation of a row
			@ModelAttribute("command") Employee employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService
				.getEmployee(employeeBean.getId())));
		model.put("employees",
				prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	private Employee prepareModel(Employee employeeBean) {
		Employee employee = new Employee();
		employee.setAddress(employeeBean.getAddress());
		employee.setAge(employeeBean.getAge());
		employee.setName(employeeBean.getName());
		employee.setLastname(employeeBean.getLastname());
		employee.setSalary(employeeBean.getSalary());
		employee.setId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}

	private List<Employee> prepareListofBean(List<Employee> employees) {
		List<Employee> beans = null;
		if (employees != null && !employees.isEmpty()) {
			beans = new ArrayList<Employee>();
			Employee bean = null;
			for (Employee employee : employees) {
				bean = new Employee();
				bean.setName(employee.getName());
				bean.setLastname(employee.getLastname());
				bean.setId(employee.getId());
				bean.setAddress(employee.getAddress());
				bean.setSalary(employee.getSalary());
				bean.setAge(employee.getAge());
				beans.add(bean);
			}
		}
		return beans;
	}

	private Employee prepareEmployeeBean(Employee employee) {
		Employee bean = new Employee();
		bean.setAddress(employee.getAddress());
		bean.setAge(employee.getAge());
		bean.setName(employee.getName());
		bean.setLastname(employee.getLastname());
		bean.setSalary(employee.getSalary());
		bean.setId(employee.getId());
		return bean;
	}
}
