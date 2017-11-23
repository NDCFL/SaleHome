package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.AppointmentDAO;
import com.ht.pojo.TAppointment;
import com.ht.service.AppointmentService;

public class AppointmentServiceimpl implements AppointmentService{

	private AppointmentDAO appointmentDAO;
	public AppointmentDAO getAppointmentDAO() {
		return appointmentDAO;
	}

	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public TAppointment queryById(String id) {
		return appointmentDAO.queryById(id);
	}

	@Override
	public void update(TAppointment t) {
		appointmentDAO.update(t);
		
	}

	@Override
	public void add(TAppointment t) {
		appointmentDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return appointmentDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TAppointment t) {
		appointmentDAO.delete(t);
		
	}

	@Override
	public List<TAppointment> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return appointmentDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TAppointment> appointmentlist(String column, String ifvalue) {
		return appointmentDAO.appointmentlist(column, ifvalue);
	}

	@Override
	public void updatestatus(TAppointment appointment) {
		appointmentDAO.updatestatus(appointment);
		
	}

	@Override
	public void updateuserstatus(TAppointment appointment) {
		appointmentDAO.updateuserstatus(appointment);
		
	}

	@Override
	public int buyhousecount(String userid, int appstatus) {
		return appointmentDAO.buyhousecount(userid, appstatus);
	}

}
