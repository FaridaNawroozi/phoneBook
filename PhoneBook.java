import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {

    // Class to represent a single contact
    static class Contact {
        String name;
        String phone;

        Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\n--- PhoneBook ---");
            System.out.println("1. Add contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search contact");
            System.out.println("4. Delete contact");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            // Check if input is a number
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number.");
                scanner.next(); // skip wrong input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    // Add contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine().trim();
                    contacts.add(new Contact(name, phone));
                    System.out.println("Contact added.");
                    break;

                case 2:
                    // View all contacts
                    System.out.println("--- Contacts ---");
                    for (Contact c : contacts) {
                        System.out.println(c.name + ": " + c.phone);
                    }
                    break;

                case 3:
                    // Search contact by name
                    System.out.print("Enter name to search: ");
                    String search = scanner.nextLine().trim();
                    boolean found = false;
                    for (Contact c : contacts) {
                        if (c.name.equalsIgnoreCase(search)) {
                            System.out.println("Found: " + c.name + " - " + c.phone);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    // Delete contact by name
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine().trim();
                    boolean removed = false;
                    for (int i = 0; i < contacts.size(); i++) {
                        if (contacts.get(i).name.equalsIgnoreCase(deleteName)) {
                            contacts.remove(i);
                            System.out.println("Contact deleted.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
