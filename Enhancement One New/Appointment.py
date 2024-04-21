from datetime import datetime
import Task
import TaskService
import AppointmentService
import Contact
import ContactService


class Appointment:
    def __init__(self, appointment_id, appointment_date, appointment_desc):
        # no longer than 10 characters and not null
        if appointment_id is None or len(appointment_id) > 10:
            raise ValueError("Invalid ID")
        # no previous date and not null
        if appointment_date is None or appointment_date < datetime.now():
            raise ValueError("Invalid Date")
        # no longer than 50 characters and not null
        if appointment_desc is None or len(appointment_desc) > 50:
            raise ValueError("Invalid Description")

        self.appointment_id = appointment_id
        self.appointment_date = appointment_date
        self.appointment_desc = appointment_desc

    # getters
    def get_id(self):
        return self.appointment_id

    def get_appointment_date(self):
        return self.appointment_date

    def get_appointment_desc(self):
        return self.appointment_desc

    # setters
    def set_appointment_date(self, appointment_date):
        if appointment_date is None or appointment_date < datetime.now():
            raise ValueError("Invalid Date")
        self.appointment_date = appointment_date

    def set_appointment_desc(self, appointment_desc):
        if appointment_desc is None or len(appointment_desc) > 50:
            raise ValueError("Invalid Description")
        self.appointment_desc = appointment_desc