package projectpackage;

import java.util.Date;

public class Appointment {
	
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDesc;
	
	public Appointment(String id, Date date, String description) {
		//no longer than 10 charac and not null
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		//no previous date and not null
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		//no longer than 50 charac and not null
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		appointmentID = id;
		appointmentDate = date;
		appointmentDesc = description;
	}
	
	//getters
	public String GetID() {
		return appointmentID;
	}
	public Date GetAppointmentDate() {
		return appointmentDate;
	}
	public String GetAppointmentDesc() {
		return appointmentDesc;
	}
	
	//setters
	public void SetAppointmentDate(Date date) {
		if (date == null || date.before(new Date())){
			throw new IllegalArgumentException("Invalid Date");
		}
		appointmentDate = date;
	}
	public void SetAppointmentDesc(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		appointmentDesc = description;
	}

}
