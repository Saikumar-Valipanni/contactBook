package com.codegnan.ContactBook;

import java.util.ArrayList;
import java.util.Scanner;

class contact {
	private String name;

	private String email;
	private int number;

	contact(String name, String email, int number) {
		this.name = name;
		this.email = email;
		this.number = number;

	}

	void DisplayContact() {
		System.out.println("Name :" + name);
		System.out.println("E-mail :" + email);
		System.out.println("Phone Number :" + number);
		System.out.println("--------------------");
	}

	String getName() {
		return name;
	}

}

class contactBook {
	// contact c1=new contact();
	ArrayList<contact> contacts = new ArrayList<contact>();
	Scanner sc = new Scanner(System.in);

	void Showmenu() {
		System.out.println("====================");
		System.out.println("1: Add Contact");
		System.out.println("2 : View All Contacts");
		System.out.println("3 :Search contact by name");
		System.out.println("4 : Delete contact by name");
		System.out.println("0: exit");
		System.out.println();
		System.out.println("Enter your choice:");
	}

	void AddContact() {
		System.out.println("Enter Name:");
		String name = sc.nextLine();
		System.out.println("Enter Email-ID");
		String email = sc.nextLine();
		System.out.println("Enter phone number:");
		int number = sc.nextInt();
		contact contact = new contact(name, email, number);
		contacts.add(contact);
		System.out.println("Contacct Added sucessfully");
	}

	void viewContact() {
		if (contacts.isEmpty()) {
			System.out.println("No contact found");

		} else {
			for (contact c : contacts) {
				c.DisplayContact();
			}
		}
	}

	void searchContact() {
		System.out.println("Enter name to Search");
		String Searchname = sc.nextLine();
		boolean found = false;
		for (contact c : contacts) {
			if (c.getName().equalsIgnoreCase(Searchname)) {
				c.DisplayContact();
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("contact not Found");
		}
	}

	void deleteContact() {
		System.out.println("Enter name to Delete");
		String name = sc.nextLine();
		boolean removed = contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
		if (removed) {
			System.out.println("Contact removed");

		} else {
			System.out.println("No contact found with the name");
		}
	}

	void run() {
		int choice = 0;
		do {
			Showmenu();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				AddContact();
				break;
			case 2:
				viewContact();
				break;
			case 3:
				searchContact();
				break;
			case 4:
				deleteContact();
				break;
			case 0:
				System.out.println("----------closing contact book---------:");
				break;
			default:
				System.out.println("Invalid choice");

			}
		} while (choice != 0);
	}

	public static void main(String[] args) {
		contactBook app = new contactBook();
		app.contacts.add(new contact("Alice", "alice@example.com", 1234567890));
		app.contacts.add(new contact("Bob", "bob@example.com", 987654321));
		app.contacts.add(new contact("Charlie", "charlie@example.com", 555123456));

		app.run();
	}
}