import Task
import TaskService
import Appointment
import AppointmentService
import ContactService

class Contact:
    def __init__(self, contact_id, first_name, last_name, phone_num, address):
        if contact_id is None or len(contact_id) > 10:
            raise ValueError("Invalid ID")
        if first_name is None or len(first_name) > 10:
            raise ValueError("Invalid First Name")
        if last_name is None or len(last_name) > 10:
            raise ValueError("Invalid Last Name")
        if phone_num is None or len(phone_num) != 10:
            raise ValueError("Invalid Phone Number")
        if address is None or len(address) > 30:
            raise ValueError("Invalid Address")

        self.contact_id = contact_id
        self.first_name = first_name
        self.last_name = last_name
        self.phone_num = phone_num
        self.address = address

    # getters
    def get_id(self):
        return self.contact_id

    def get_full_name(self):
        return self.first_name + " " + self.last_name

    def get_phone_number(self):
        return self.phone_num

    def get_address(self):
        return self.address

    # setters
    def set_first_name(self, first_name):
        if first_name is None or len(first_name) > 10:
            raise ValueError("Invalid First Name")
        self.first_name = first_name

    def set_last_name(self, last_name):
        if last_name is None or len(last_name) > 10:
            raise ValueError("Invalid Last Name")
        self.last_name = last_name

    def set_phone_number(self, phone_num):
        if phone_num is None or len(phone_num) != 10:
            raise ValueError("Invalid Phone Number")
        self.phone_num = phone_num

    def set_address(self, address):
        if address is None or len(address) > 30:
            raise ValueError("Invalid Address")
        self.address = address
