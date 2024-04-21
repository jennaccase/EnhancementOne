package projectpackage;

public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String contactAddress;
	
	public Contact(String id, String fName, String lName, String phone, String address) {
		
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		if(lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		if(phone == null || phone.length() > 10 || phone.length() < 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		contactID = id;
		firstName = fName;
		lastName = lName;
		phoneNum = phone;
		contactAddress = address;
	}
	
	//getters
	public String getID() {
		return contactID;
	}
	public String getFullName() {
		return firstName + " " + lastName;
	}
	public String getPhoneNumber() {
		return phoneNum;
	}
	public String getAddress() {
		return contactAddress;
	}
	
	//setters
	public void setFirstName(String fName) {
		if(fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		firstName = fName;
	}
	
	public void setLastName(String lName) {
		if(lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		lastName = lName;
	}
	
	public void setPhoneNumber(String phone) {
		if(phone == null || phone.length() > 10 || phone.length() < 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		phoneNum = phone;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		contactAddress = address;
	}
	
	
}