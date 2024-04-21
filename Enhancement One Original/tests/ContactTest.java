package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import projectpackage.Contact;

class ContactTest {
	
	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
			
	}
	
	@Test
	void testSetFirstAndLastName() {
		Contact contact = new Contact("123456", "Jenna", "Case", "7175555555", "6064 Terrace St.");
		contact.setFirstName("Jenna");
		contact.setLastName("Case");
		assertTrue(contact.getFullName().equals("Jenna Case"));
	}
	
	@Test
	void testSetPhoneNumberAndAddress() {
		Contact contact = new Contact("123456", "Jenna", "Case", "7176457140", "6064 Terrace St.");
		contact.setPhoneNumber("7176457140");
		contact.setAddress("6064 Terrace St.");
		assertTrue(contact.getPhoneNumber().equals("7176457140"));
		assertTrue(contact.getAddress().equals("6064 Terrace St."));
	}
	
	@Test
	void testNullSetAttributes() {
		Contact contact = new Contact("123456", "Jenna", "Case", "7175555555", "6064 Terrace St.");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);
		});		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setAddress(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhoneNumber(null);
		});
	}
	
	@Test
	void testAllGetters() {
		Contact contact = new Contact("123456789", "Jenna", "Case", "7176457555", "6064 Terrace St.");
		Assertions.assertEquals(contact.getID(), "123456789");
		Assertions.assertEquals(contact.getFullName(), "Jenna Case");
		Assertions.assertEquals(contact.getPhoneNumber(), "7176457555");
		Assertions.assertEquals(contact.getAddress(), "6064 Terrace St.");
	}

}
