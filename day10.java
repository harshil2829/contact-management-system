import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " | " + phone;
    }
}

public class day10 {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Contact Book =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        System.out.println("\nName | Phone");
        System.out.println("----------------");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    static void searchContact() {
        System.out.print("Enter name to search: ");
        String search = sc.nextLine();

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(search)) {
                System.out.println("Found: " + c);
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();

        contacts.removeIf(c -> c.name.equalsIgnoreCase(name));
        System.out.println("Contact deleted (if existed).");
    }
}
