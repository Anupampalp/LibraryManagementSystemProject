package com.librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static HashMap<Integer, Member> members = new HashMap<>();
    private static Connection connection;

    public static void main(String[] args) {
        connectToDatabase();
        displayMenu();
    }

    private static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "anupam@9696");
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        System.out.print("Enter Title: ");
        String title = sc.next();
        System.out.print("Enter Author: ");
        String author = sc.next();
        System.out.print("Enter Publisher: ");
        String publisher = sc.next();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        Book book = new Book(bookId, title, author, publisher, quantity);
        books.add(book);

        try {
            String sql = "INSERT INTO books (book_id, title, author, publisher, quantity) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, bookId);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setInt(5, quantity);
            ps.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title to search: ");
        String title = sc.next();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found!");
    }

    private static void issueBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

    }


}
