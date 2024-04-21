package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import projectpackage.AppointmentService;
import projectpackage.Appointment;

class AppointmentServiceTest {

	//create a good date
	Date goodDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 6);
		c.set(Calendar.DATE, 01);
		c.set(Calendar.YEAR, 2023);
		Date date = c.getTime();
		return date;
	}
	//create a bad date
	Date badDate() {
		Date date = new Date();
		date.setTime(10000);
		return date;
	}
	
	@Test
	void testAddAppointment() {
		//null date
		AppointmentService appointmentService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.AddAppointment(null, "Appointment Description");
		});
		//null description
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.AddAppointment(goodDate(), null);
		});
		//bad date
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.AddAppointment(badDate(), "Appointment Description");
		});
		//bad description
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.AddAppointment(goodDate(), "This appointment description is too long and will throw an error");
		});
	}
	
	@Test
	void testAddAppointmentGood() {
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.AddAppointment(goodDate(), "Appointment Description");
		assertEquals(appointmentService.GetAppointmentCount(), 1);
		assertTrue(!appointmentService.GetAppointmentList().isEmpty());
	}
	
	@Test
	void testDeleteAppointment() {
		//empty list
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.DeleteAppointment("1234567");
		
		//null id
		appointmentService.AddAppointment(goodDate(), "Remove");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.DeleteAppointment(null);
		});
		//id too long
		appointmentService.AddAppointment(goodDate(), "Remove");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.DeleteAppointment("1234567890123");
		});
	}
}
