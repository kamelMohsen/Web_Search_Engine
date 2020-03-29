package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Class.*;

public class DBManager {


    private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String jdbcURL = "jdbc:sqlserver://localhost:1433;databasename=SearchEngine;integratedSecurity=true;";
    private static Connection databaseConnection= null;


    public DBManager() throws SQLException {
        try
        {
            forName(jdbcDriver).newInstance();
            System.out.println("JDBC driver loaded");
        }catch(Exception err)
        {
            System.err.println("Error loading JDBC driver");
            err.printStackTrace(System.err);
            System.exit(0);
        }
    }

    public  Connection getDatabaseConnection() throws SQLException {

        try
        {
            //Connect to the database
            databaseConnection = DriverManager.getConnection(jdbcURL);
            System.out.println("Connected to the database");
        }
        catch(SQLException err)
        {
            System.err.println("Error connecting to the database");
            err.printStackTrace(System.err);
            System.exit(0);
        }
        return databaseConnection;
    }



}
