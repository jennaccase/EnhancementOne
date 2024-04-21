package projectpackage;

import java.util.Vector;
import java.util.Random;

public class ContactService {
	//vector to store contacts
	private Vector<Contact> myContacts = new Vector<Contact>();
	
	//int counter to store the number of contacts
	private int numContacts = 0;
	
	//getters
	public int getNumContacts() {
		return numContacts;
	}
	public Vector<Contact> getContactList() {
		return myContacts;
	}
	
	//add a contact to the list
	public void addContact(String id, String fName, String lName, String phone, String address) {
		Contact newContact = new Contact(id, fName, lName, phone, address);
		myContacts.add(newContact);
		numContacts++;
	}
	public void addContact(Contact contact) {
		myContacts.add(contact);
		numContacts++;
	}
	
	//remove a contact from the list
	public void removeContact(String id) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("No contacts are saved.");
		}
		int index = -1;
		for (Contact c: myContacts) {
			if(c.getID() == id) {
				index = myContacts.indexOf(c);
			}
		}
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		else {
			myContacts.remove(index);
			numContacts--;
			System.out.println("Removed");
		}
	}
	public void removeContact(Contact contact) {
		myContacts.remove(contact);
		numContacts--;
	}
	
	//update a contact
	public void updateContact(String ID, String update, int selection) {
		if (ID == null || ID.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("There are no contacts to update.");
		}
		int index = -1;
		for (Contact c: myContacts) {
			if (c.getID() == ID) {
				index = myContacts.indexOf(c);
			}
		}
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		Contact updatedContact = myContacts.get(index);
		
		switch(selection) {
		case 1:{
			updatedContact.setFirstName(update);
			break;
		}
		case 2:{
			updatedContact.setLastName(update);
			break;
		}
		case 3:{
			updatedContact.setPhoneNumber(update);
			break;
		}
		case 4:{
			updatedContact.setAddress(update);
			break;
		}
		default:{
			removeContact(myContacts.elementAt(index));
			addContact(updatedContact);
			return;
		}
		}
	}
	
	public void updatedContact(String id, String fName, String lName, String phone, String address) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("There are no contacts found.");
		}
		int index = -1;
		for (Contact c: myContacts) {
			if (c.getID() == id) {
				index = myContacts.indexOf(c);
			}
		}
		if (index == -1) {
			System.out.println("Not found");
			return;
		}
		Contact tempContact = myContacts.get(index);
		
		tempContact.setFirstName(fName);
		tempContact.setLastName(lName);
		tempContact.setPhoneNumber(phone);
		tempContact.setAddress(address);
		
		myContacts.remove(index);
		myContacts.add(tempContact);
	}
	
	public String generateUniqueID() {
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		for (Contact c: myContacts) {
			while(c.getID() == uniqueID) {
				newID = rand.nextInt(1000000000);
				uniqueID = Integer.toString(newID);
			}
		}
		System.out.println("New Contact ID created: " + uniqueID);
		return uniqueID;
		
	}
}
		
