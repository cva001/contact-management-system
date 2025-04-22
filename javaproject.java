import java.util.*;

class Contact { private String name; private String phoneNumber; private String email;

public Contact(String name, String phoneNumber, String email) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
}

public String getName() {
    return name;
}

public String getPhoneNumber() {
    return phoneNumber;
}

public String getEmail() {
    return email;
}

public void setName(String name) {
    this.name = name;
}

public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}

public void setEmail(String email) {
    this.email = email;
}

@Override
public String toString() {
    return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
}

}

class ContactManager { private List<Contact> contacts = new ArrayList<>();

public void addContact(Contact contact) {
    contacts.add(contact);
    System.out.println("Contact added successfully.");
}

public void viewContacts() {
    if (contacts.isEmpty()) {
        System.out.println("No contacts available.");
    } else {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

public void searchContact(String name) {
    boolean found = false;
    for (Contact contact : contacts) {
        if (contact.getName().equalsIgnoreCase(name)) {
            System.out.println(contact);
            found = true;
        }
    }
    if (!found) {
        System.out.println("Contact not found.");
    }
}

public void deleteContact(String name) {
    Iterator<Contact> iterator = contacts.iterator();
    boolean found = false;
    while (iterator.hasNext()) {
        Contact contact = iterator.next();
        if (contact.getName().equalsIgnoreCase(name)) {
            iterator.remove();
            System.out.println("Contact deleted successfully.");
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Contact not found.");
    }
}

}

public class ContactManagementSystem { public static void main(String[] args) { Scanner scanner = new Scanner(System.in); ContactManager manager = new ContactManager(); boolean exit = false;

while (!exit) {
        System.out.println("\n--- Contact Management System ---");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phone = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                manager.addContact(new Contact(name, phone, email));
                break;
            case 2:
                manager.viewContacts();
                break;
            case 3:
                System.out.print("Enter name to search: ");
                String searchName = scanner.nextLine();
                manager.searchContact(searchName);
                break;
            case 4:
                System.out.print("Enter name to delete: ");
                String deleteName = scanner.nextLine();
                manager.deleteContact(deleteName);
                break;
            case 5:
                exit = true;
                System.out.println("Exiting Contact Management System. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    scanner.close();
}

}