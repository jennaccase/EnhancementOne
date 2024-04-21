from datetime import datetime
import random
import Appointment


class AppointmentService:
    def __init__(self):
        self.appointment_list = []
        self.appointment_count = 0

    # getters
    def get_appointment_list(self):
        return self.appointment_list

    def get_appointment_count(self):
        return self.appointment_count

    # add appointments
    def add_appointment(self, date, description):
        today = datetime.now()
        if date is None or date < today:
            raise ValueError("Invalid Date")
        if description is None or len(description) > 50:
            raise ValueError("Invalid Description")

        new_id = self.generate_unique_id()
        new_appointment = Appointment(new_id, date, description)
        self.appointment_list.append(new_appointment)
        self.appointment_count += 1

    # delete appointment
    def delete_appointment(self, appointment_id):
        if not self.appointment_list:
            print("There are no appointments to delete")
            return

        if appointment_id is None or len(appointment_id) > 10:
            raise ValueError("Invalid ID")

        index = -1
        for idx, appointment in enumerate(self.appointment_list):
            if appointment.get_id() == appointment_id:
                index = idx
                break

        if index == -1:
            print("Appointment ID not found")
        else:
            del self.appointment_list[index]
            self.appointment_count -= 1
            print("Appointment removed")

    # generate a unique id for the appointment
    def generate_unique_id(self):
        rand = random.Random()
        new_id = rand.randint(0, 999999999)
        unique_id = str(new_id)

        id_list = [appointment.get_id() for appointment in self.appointment_list]
        while unique_id in id_list or len(unique_id) > 10:
            new_id = rand.randint(0, 999999999)
            unique_id = str(new_id)

        return unique_id

