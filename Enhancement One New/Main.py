import TaskService
from TaskService import TaskService

def main():
    # Creating a TaskService instance
    task_service = TaskService()

    # Adding tasks
    try:
        task_service.add_task("Task 1", "Description for Task 1")
        task_service.add_task("Task 2", "Description for Task 2")
        task_service.add_task("Task 3", "Description for Task 3")
    except ValueError as e:
        print("Error:", e)

    # Printing task list
    print("\nTask List:")
    task_service.print_task_list()

    # Removing a task
    try:
        task_service.remove_task("1")  # Assuming "1" is the ID of the task to remove
    except ValueError as e:
        print("Error:", e)

    # Printing updated task list
    print("\nTask List After Removal:")
    task_service.print_task_list()

    # Updating a task
    try:
        task_service.update_task("2", "Updated Task 2", 1)  # Assuming "2" is the ID of the task to update
    except ValueError as e:
        print("Error:", e)

    # Printing updated task list
    print("\nTask List After Update:")
    task_service.print_task_list()

if __name__ == "__main__":
    main()