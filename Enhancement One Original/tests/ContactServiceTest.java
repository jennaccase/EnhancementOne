package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import projectpackage.ContactService;
import projectpackage.Contact;

class ContactServiceTest {

	@Test
	void testAddContactMethod() {
		ContactService contactService = new ContactService();
		String testID = contactService.generateUniqueID();
		Contact contact = new Contact(testID, "Jenna", "Case", "7175555555", "6064 Terrace St.");
		
		contactService.addContact(contact);
		
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService.getContactList().elementAt(0).getID().equals(testID));
		assertTrue(contactService.getNumContacts() > 0);
	}
	
	@Test
	void testRemoveContactMethod() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("123456", "Jenna", "Case", "7175555555", "6064 Terrace St.");
		
		//remove with null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("");
		});
		//remove with too long id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("12345678901");
		});
		//remove from empty list
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("1234567890");
		});
		
		contactService.addContact(contact);
		//remove a contact that is not there
		contactService.removeContact("123457");
		
		//contact list not empty, count not zero, contact not removed because it does not eist
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService.getNumContacts() != 0);
		contactService.removeContact("123456");;
		assertTrue(contactService.getNumContacts() == 0);
		assertTrue(contactService.getContactList().isEmpty());
	}
	
	@Test
	void testUpdateContact() {
		ContactService contactService = new ContactService();
		//list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456",  "Jennifer", 1);
		});
		//create new contact and add to list
		Contact contact = new Contact("123456", "Jenna", "Case", "7175555555", "6064 Terrace St.");
		contactService.addContact(contact);
		assertTrue(!contactService.getContactList().isEmpty());
		
		//id too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", "123456789012", 1);
		});
		//id is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(null, "123456", 1);
		});
		
		//value is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", null, 1);
		});
		contactService.updateContact("123457", "Jennifer", 1);
		contactService.updateContact("123456", "Jennifer", 5);
	
	}
	
	@Test
	void testUpdateContactMethod() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("123456", "Jen", "Case", "7175555555", "6064 Terrace St.");
		contactService.addContact(contact);
		assertTrue(!contactService.getContactList().isEmpty());
		
		//update first name
		contactService.updateContact("123456", "Jenna", 1);
		assertTrue(contactService.getContactList().elementAt(0).getFullName().equals("Jenna Case"));
		
		//update last name
		contactService.updateContact("123456", "Corbin", 2);
		assertTrue(contactService.getContactList().elementAt(0).getFullName().equals("Jenna Corbin"));
		
		//update phone number
		contactService.updateContact("123456", "7176457140", 3);
		assertTrue(contactService.getContactList().elementAt(0).getPhoneNumber().equals("7176457140"));
		
		//update address
		contactService.updateContact("123456", "3921 Rauch St.", 4);
		assertTrue(contactService.getContactList().elementAt(0).getAddress().equals("3921 Rauch St."));
		
		//first name too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456",  "JenniferCorbin", 1);
		});

	}

}
