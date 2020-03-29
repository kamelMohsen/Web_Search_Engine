package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        DBManager dbManager = new DBManager();
        Connection dbConnection = dbManager.getDatabaseConnection();

        Statement sqlStatement = dbConnection.createStatement();
        ResultSet rs = null;
        String queryString="INSERT INTO Word (Word,WordCount) VALUES ('Sameh',1) ";

        System.out.println("\nQuery string:");
        System.out.println(queryString);
/*
        try {
            sqlStatement.executeUpdate(queryString);
        }catch (Exception err)
        {
            System.err.println("Error Inserting");
        }*/
        queryString="SELECT * FROM Word WHERE Word = 'Kamel' ";
        System.out.println("\nQuery string:");
        System.out.println(queryString);
        rs = sqlStatement.executeQuery(queryString);
        rs.next();
        System.out.println("Answer " + rs.getString("Word"));
    }
}
