package projectpackage;

import java.util.Date;
import java.util.Random;
import java.util.Vector;

public class AppointmentService {
	
	private Vector<Appointment> appointmentList = new Vector<Appointment>();
	private int appointmentCount = 0;
	
	//getters
	public Vector<Appointment> GetAppointmentList() {
		return appointmentList;
	}
	public int GetAppointmentCount() {
		return appointmentCount;
	}
	
	//add appointments
	public void AddAppointment(Date date, String description) {
		Date today = new Date();
		if(date == null || date.before(today)) {
			throw new IllegalArgumentException("Invalid Date");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		String newID = GenerateUniqueID();
		var newAppointment = new Appointment(newID, date, description);
		appointmentList.add(newAppointment);
		appointmentCount = GetAppointmentCount() + 1;
	}
	//delete appointment
	public void DeleteAppointment(String id) {
		if(appointmentList.isEmpty()) {
			System.out.println("There are no appointments to print");
		}
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		//search for id
		int index = -1;
		for (Appointment a : appointmentList) {
			if (a.GetID() == id) {
				index = appointmentList.indexOf(a);
			}
		}
		//no appointment found
		if (index == -1) {
			System.out.println("Appointment ID no found");
			return;
		}
		else {
			//remove appointment
			appointmentList.remove(index);
			appointmentCount = GetAppointmentCount() - 1;
			System.out.println("Appointment removed");
		}
	}
	//make a unique id for the appointment
	public String GenerateUniqueID() {
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		Vector<String> idList = new Vector<String>();
		for (Appointment a : appointmentList) {
			idList.add(a.GetID());
		}
		while (idList.contains(uniqueID) || uniqueID.length() > 10) {
			newID = rand.nextInt(1000000000);
			uniqueID = Integer.toString(newID);
		}
		idList = null;
		return uniqueID;
	}

}
