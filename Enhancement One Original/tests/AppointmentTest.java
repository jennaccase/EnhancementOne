package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import projectpackage.Appointment;

class AppointmentTest {

	@Test
	void testAppointmentConstructor() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 6);
		c.set(Calendar.DATE, 01);
		c.set(Calendar.YEAR, 2023);
		Date date = c.getTime();
		
		//new date
		System.out.println("Date set to " + date);
		
		//id too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345678901", date, "Appointment Description");
		});
		//id null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, date, "Appointment Description");
		});
		//description too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", date, "This appointment description is too long and will throw an error");
		});
		//description null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", date, null);
		});
		//date null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", null, "Appointment Description");
		});
		//date before today
		date.setTime(0);
		System.out.println("Date set to " + date);
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890", date, "Appointment Description");
		});
		
		//everything is good
		Date newDate = c.getTime();
		Appointment appointment = new Appointment("1234567890", newDate, "Appointment Description");
		assertTrue(appointment.GetID().equals("1234567890"));
		assertTrue(appointment.GetAppointmentDate().equals(newDate));
		assertTrue(appointment.GetAppointmentDesc().equals("Appointment Description"));
	}
	@Test
	void testSetters() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 6);
		c.set(Calendar.DATE, 01);
		c.set(Calendar.YEAR, 2023);
		Date date = c.getTime();
		Date newDate = c.getTime();
		Date badDate = new Date();
		badDate.setTime(10000);
		
		//make instance
		Appointment appointment = new Appointment("1234567890", date, "Appointment Description");
		
		//null description
		appointment.SetAppointmentDesc("This is a description");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.SetAppointmentDesc(null);
		});
		//long description
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.SetAppointmentDesc("This appointment description is too long and will throw an error");
		});
		//check
		assertTrue(appointment.GetAppointmentDesc().equals("This is a description"));
		
		//date is before today
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.SetAppointmentDate(badDate);
		});
		//date is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appointment.SetAppointmentDate(null);
		});
		//check
		appointment.SetAppointmentDate(newDate);
		assertTrue(appointment.GetAppointmentDate().equals(newDate));
	}

}
