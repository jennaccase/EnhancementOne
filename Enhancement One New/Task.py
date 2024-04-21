import TaskService
import Appointment
import AppointmentService
import Contact
import ContactService

class Task:
    def __init__(self, task_id, task_name, task_desc):
        if task_id is None or len(task_id) > 10:
            raise ValueError("Invalid ID")
        if task_name is None or len(task_name) > 20:
            raise ValueError("Invalid Name")
        if task_desc is None or len(task_desc) > 50:
            raise ValueError("Invalid Description")

        self.task_id = task_id
        self.task_name = task_name
        self.task_desc = task_desc

    # getters
    def get_id(self):
        return self.task_id

    def get_task_name(self):
        return self.task_name

    def get_task_description(self):
        return self.task_desc

    # setters
    def set_task_id(self, task_id):
        if task_id is None or len(task_id) > 10:
            raise ValueError("Invalid ID")
        self.task_id = task_id

    def set_task_name(self, task_name):
        if task_name is None or len(task_name) > 20:
            raise ValueError("Invalid Name")
        self.task_name = task_name

    def set_task_desc(self, task_desc):
        if task_desc is None or len(task_desc) > 50:
            raise ValueError("Invalid Description")
        self.task_desc = task_desc
