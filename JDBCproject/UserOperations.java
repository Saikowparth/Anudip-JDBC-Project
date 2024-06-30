package com.Anudip.JDBCproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOperations {

    public void viewIssuedBooks(int userId) {
        String query = "SELECT * FROM IssuedBooks WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("---------------");
                System.out.println("Issue ID: " + rs.getInt("issue_id"));
                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Issue Date: " + rs.getDate("issue_date"));
                System.out.println("Return Date: " + rs.getDate("return_date"));
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewAllBooks() {
        String query = "SELECT * FROM Books";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("----------");
                System.out.println("Book ID: " + rs.getInt("book_id") +
                        ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") +
                        ", Published Year: " + rs.getInt("published_year") +
                        ", Copies: " + rs.getInt("copies"));
                System.out.println("----------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void issueBook(int bookId, int userId, String issueDate) {
        String query = "INSERT INTO IssuedBooks (book_id, user_id, issue_date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, userId);
            pstmt.setDate(3, java.sql.Date.valueOf(issueDate));
            pstmt.executeUpdate();
            System.out.println("Book issued successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void returnBook(int issueId, String returnDate) {
        String query = "UPDATE IssuedBooks SET return_date = ? WHERE issue_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDate(1, java.sql.Date.valueOf(returnDate));
            pstmt.setInt(2, issueId);
            pstmt.executeUpdate();
            System.out.println("Book returned successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
