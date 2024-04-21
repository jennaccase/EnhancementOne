import random
import Contact


class ContactService:
    def __init__(self):
        self.my_contacts = []
        self.num_contacts = 0

    # getters
    def get_num_contacts(self):
        return self.num_contacts

    def get_contact_list(self):
        return self.my_contacts

    # add a contact to the list
    def add_contact(self, id, first_name, last_name, phone, address):
        new_contact = Contact(id, first_name, last_name, phone, address)
        self.my_contacts.append(new_contact)
        self.num_contacts += 1

    def add_contact_object(self, contact):
        self.my_contacts.append(contact)
        self.num_contacts += 1

    # remove a contact from the list
    def remove_contact_by_id(self, id):
        if id is None or len(id) > 10:
            raise ValueError("Invalid Contact ID")
        if not self.my_contacts:
            raise ValueError("No contacts are saved.")

        index = -1
        for idx, contact in enumerate(self.my_contacts):
            if contact.get_id() == id:
                index = idx
                break

        if index == -1:
            print("Not found")
        else:
            del self.my_contacts[index]
            self.num_contacts -= 1
            print("Removed")

    def remove_contact_object(self, contact):
        self.my_contacts.remove(contact)
        self.num_contacts -= 1

    # update a contact
    def update_contact(self, id, update, selection):
        if id is None or len(id) > 10 or update is None or selection < 0:
            raise ValueError("Invalid Contact ID")
        if not self.my_contacts:
            raise ValueError("There are no contacts to update.")

        index = -1
        for idx, contact in enumerate(self.my_contacts):
            if contact.get_id() == id:
                index = idx
                break

        if index == -1:
            print("Not found")
            return

        updated_contact = self.my_contacts[index]

        if selection == 1:
            updated_contact.set_first_name(update)
        elif selection == 2:
            updated_contact.set_last_name(update)
        elif selection == 3:
            updated_contact.set_phone_number(update)
        elif selection == 4:
            updated_contact.set_address(update)
        else:
            self.remove_contact_object(self.my_contacts[index])
            self.add_contact_object(updated_contact)
            return

    def update_contact_fields(self, id, first_name, last_name, phone, address):
        if id is None or len(id) > 10:
            raise ValueError("Invalid Contact ID")
        if not self.my_contacts:
            raise ValueError("There are no contacts found.")

        index = -1
        for idx, contact in enumerate(self.my_contacts):
            if contact.get_id() == id:
                index = idx
                break

        if index == -1:
            print("Not found")
            return

        temp_contact = self.my_contacts[index]
        temp_contact.set_first_name(first_name)
        temp_contact.set_last_name(last_name)
        temp_contact.set_phone_number(phone)
        temp_contact.set_address(address)

        del self.my_contacts[index]
        self.my_contacts.append(temp_contact)

    def generate_unique_id(self):
        rand = random.Random()
        new_id = rand.randint(0, 999999999)
        unique_id = str(new_id)

        for contact in self.my_contacts:
            while contact.get_id() == unique_id:
                new_id = rand.randint(0, 999999999)
                unique_id = str(new_id)

        print("New Contact ID created: " + unique_id)
        return unique_id


