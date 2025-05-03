package StepDefinitions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class databaseconn {
    String dbUrl;
    Connection connection;
    Statement stmt;
    ResultSet rs;
    @Given(": database url")
public void database_url() {
    // Write code here that turns the phrase above into concrete actions
     dbUrl = "jdbc:mysql://localhost:3306/awesome chocolates"; //Database URL - Contains jdbc , localhost, port & org is name of database

         
}
@When(": connect to database")
public void connect_to_database() throws SQLException, ClassNotFoundException {
    // Write code here that turns the phrase above into concrete actions
    String user = "root";  // username 

        String password = "pallavi";   //  password
        // Load the MySQL JDBC driver and establish connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to Database");

        connection = DriverManager.getConnection(dbUrl, user, password);
        // Check if the connection is successful
        if (connection == null) {
            System.out.println("Database Connection Failed");
        }else {
            System.out.println("Database Connection Successful");
        }
}
@Then(": validate the data from database with the table data")
public void validate_the_data_from_database_with_the_table_data() throws SQLException {
    // Write code here that turns the phrase above into concrete actions
    String query= "SELECT * FROM geo"; // SQL query to fetch data from the table
    Statement stmt=connection.createStatement(); // Create a statement object to execute the query
    ResultSet rs=stmt.executeQuery(query); // Execute the query and get the result set

    while(rs.next())
    {
        String geoId=rs.getString("GeoID"); // Get the value of the "geoId" column from the result set
        String Geo=rs.getString("Geo");
        String region=rs.getString("Region");
        System.out.println("GeoId: " + geoId+" Geo: "+Geo+" region: "+region); // Print the value of the "geoId" column
    }
}

    
}
