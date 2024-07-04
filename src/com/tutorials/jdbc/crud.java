package com.tutorials.jdbc;

import java.sql.*;

public class crud {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rg";
        String user = "root";
        String password = "Pankaj@1166"; // Ensure this is the correct password for your MySQL root user

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database!");
            }


            createEmployee(conn, 26, "HAIDER", "Recreational");


            readEmployees(conn);


            updateEmployeeDepartment(conn, "INFLUENCER", "ACTOR");


            readEmployees(conn);


            deleteEmployee(conn, 26);


            readEmployees(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createEmployee(Connection conn, int id, String name, String department) {
        String query = "INSERT INTO EMPLOYEES (ID, NAME, DEPARTMENT) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, department);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Create: Number of rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readEmployees(Connection conn) {
        String query = "SELECT * FROM EMPLOYEES";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (!rs.isBeforeFirst()) {
                System.out.println("Read: No data found in the EMPLOYEES table.");
            } else {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();

                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateEmployeeDepartment(Connection conn, String oldDepartment, String newDepartment) {
        String query = "UPDATE EMPLOYEES SET DEPARTMENT = ? WHERE DEPARTMENT = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newDepartment);
            pstmt.setString(2, oldDepartment);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Update: Number of rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(Connection conn, int id) {
        String query = "DELETE FROM EMPLOYEES WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Delete: Number of rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
