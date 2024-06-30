package com.Anudip.JDBCproject;

import java.util.Scanner;

public class LibraryManagementSystem {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            LibrarianOperations librarian = new LibrarianOperations();
            UserOperations user = new UserOperations();

            System.out.println("****** Welcome to the Library Management System ******");
            System.out.println("Are you a librarian or a user?");
            String role = scanner.nextLine();

            if (role.equalsIgnoreCase("librarian")) {
                while (true){
                    System.out.println("1. Add Book");
                    System.out.println("2. Update Book");
                    System.out.println("3. Delete Book");
                    System.out.println("4. Issue Book");
                    System.out.println("5. Return Book");
                    System.out.println("6. View all books");
                    System.out.println("7. Add User");
                    System.out.println("8. Delete User");
                    System.out.println("9. Exit.");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter published year: ");
                            int year = scanner.nextInt();
                            System.out.print("Enter copies: ");
                            int copies = scanner.nextInt();
                            librarian.addBook(title, author, year, copies);
                            break;
                        case 2:
                            System.out.print("Enter book ID: ");
                            int bookId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter title: ");
                            title = scanner.nextLine();
                            System.out.print("Enter author: ");
                            author = scanner.nextLine();
                            System.out.print("Enter published year: ");
                            year = scanner.nextInt();
                            System.out.print("Enter copies: ");
                            copies = scanner.nextInt();
                            librarian.updateBook(bookId, title, author, year, copies);
                            break;
                        case 3:
                            System.out.print("Enter book ID: ");
                            bookId = scanner.nextInt();
                            librarian.deleteBook(bookId);
                            break;
                        case 4:
                            System.out.print("Enter book ID: ");
                            bookId = scanner.nextInt();
                            System.out.print("Enter user ID: ");
                            int userId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter issue date (YYYY-MM-DD): ");
                            String issueDate = scanner.nextLine();
                            librarian.issueBook(bookId, userId, issueDate);
                            break;
                        case 5:
                            System.out.print("Enter issue ID: ");
                            int issueId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter return date (YYYY-MM-DD): ");
                            String returnDate = scanner.nextLine();
                            librarian.returnBook(issueId, returnDate);
                            break;
                        case 6:
                            librarian.viewAllBooks();
                            break;
                        case 7:
                            System.out.print("Enter username: ");
                            String username = scanner.nextLine();
                            System.out.print("Enter password: ");
                            String password = scanner.nextLine();
                            System.out.print("Enter role (librarian/user): ");
                            String userRole = scanner.nextLine();
                            librarian.addUser(username, password, userRole);
                            break;
                        case 8:
                            System.out.print("Enter user ID: ");
                            userId = scanner.nextInt();
                            librarian.deleteUser(userId);
                            break;
                        case 9:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            } else if (role.equalsIgnoreCase("user")) {
                while (true) {
                    System.out.println("1. View Issued Books");
                    System.out.println("2. Issue Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View all books");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter user ID: ");
                            int userId = scanner.nextInt();
                            user.viewIssuedBooks(userId);
                            break;
                        case 2:
                            System.out.print("Enter book ID: ");
                            int bookId = scanner.nextInt();
                            System.out.print("Enter user ID: ");
                            userId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter issue date (YYYY-MM-DD): ");
                            String issueDate = scanner.nextLine();
                            user.issueBook(bookId, userId, issueDate);
                            break;
                        case 3:
                            System.out.print("Enter issue ID: ");
                            int issueId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter return date (YYYY-MM-DD): ");
                            String returnDate = scanner.nextLine();
                            user.returnBook(issueId, returnDate);
                            break;
                        case 4:
                            librarian.viewAllBooks();
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            } else {
                System.out.println("Invalid role.");
            }
            scanner.close();
        }
    }
