package com.ht.service;

import java.util.List;

import com.ht.pojo.TAppointment;

public interface AppointmentService extends BaseService<String, TAppointment> {

	public abstract List<TAppointment> appointmentlist(String column,String ifvalue);
	public abstract void updatestatus(TAppointment appointment);
	public abstract void updateuserstatus(TAppointment appointment);
	public abstract int buyhousecount(String userid,int appstatus);

}
