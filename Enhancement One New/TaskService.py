import random
import Task


class TaskService:
    def __init__(self):
        self.task_list = []
        self.task_count = 0

    # list of tasks
    def get_task_list(self):
        return self.task_list

    # count tasks
    def get_task_count(self):
        return self.task_count

    # print
    def print_task_list(self):
        for task in self.task_list:
            print("Task ID: " + task.get_id() + " Name: " + task.get_task_name())
            print("Description: " + task.get_task_description() + "\n")

    # add task
    def add_task(self, p_name, p_description):
        if p_name is None or len(p_name) > 20:
            raise ValueError("Invalid Name")
        if p_description is None or len(p_description) > 50:
            raise ValueError("Invalid Description")

        new_id = self.generate_unique_id()
        new_task = Task(new_id, p_name, p_description)
        self.task_list.append(new_task)
        self.task_count += 1
        print("Task " + new_task.get_task_name() + " created and added successfully")

    def remove_task_instance(self, task):
        self.task_list.remove(task)
        self.task_count -= 1

    def remove_task(self, task_id):
        if not self.task_list:
            print("There are no tasks to remove")
            return

        if task_id is None or len(task_id) > 10:
            raise ValueError("Invalid ID")

        index = -1
        for idx, task in enumerate(self.task_list):
            if task.get_id() == task_id:
                index = idx
                break

        if index == -1:
            print("Task not found")
            return
        else:
            self.remove_task_instance(self.task_list[index])
            print("Task was removed from the list")

    def update_task(self, task_id, update, selection):
        if task_id is None or len(task_id) > 10 or update is None or selection < 0:
            raise ValueError("Invalid Request")

        if not self.task_list:
            print("There are no tasks to update")
            return

        index = -1
        for idx, task in enumerate(self.task_list):
            if task.get_id() == task_id:
                index = idx
                break

        if index == -1:
            print("Task not found")
            return

        update_task = self.task_list[index]

        # conditional for updates
        # 1 is for name
        # 2 is for description
        if selection == 1:
            update_task.set_task_name(update)
        elif selection == 2:
            update_task.set_task_desc(update)
        else:
            print("Task not updated, error")
            return

        self.remove_task_instance(self.task_list[index])
        self.task_list.append(update_task)

    def generate_unique_id(self):
        rand = random.Random()
        new_id = rand.randint(0, 999999999)
        unique_id = str(new_id)

        id_list = [task.get_id() for task in self.task_list]
        while unique_id in id_list or len(unique_id) > 10:
            new_id = rand.randint(0, 999999999)
            unique_id = str(new_id)

        print("New Task ID created:", unique_id)
        return unique_id


