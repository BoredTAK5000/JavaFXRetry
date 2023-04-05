package com.example.javafxretry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import com.mysql.jdbc.Statement;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

//import com.mysql.jdbc.ResultSet;
import javafx.stage.Stage;

public class HelloController {


    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-- Manager Buttons ----------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //-- Control Pannel buttons ---------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button Manager_Manage_Blanks_Button;

    //-- Manage Blanks ------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button Manader_Go_To_Allocate_Blanks_Button;

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-- Systems Admin Buttons ----------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //-- Login Page ---------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button button;

    //-- Control Panel ------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button Manage_Blanks_Button;

    //-- Manage Blanks ------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Admin_Go_To_Sell_Ticket;

    @FXML
    private Button Admin_Go_To_Validate_Ticket_Button;

    @FXML
    private Button Go_To_BlackList_Blank_Button;

    @FXML
    private Button Go_To_Allocate_Blanks_Button;

    @FXML
    private Button To_Create_Blank_Button;

    @FXML
    private Button Admin_Go_To_Void_Ticket_Button;

    //-- Blacklist Blank Page -----------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button BlackList_Blank_Button;

    @FXML
    private TextField Blacklist_Blank_ID;

    //-- Allocate Blanks ----------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private TextField Account_ID_To_Send_Blank;

    @FXML
    private Button Allocate_Blanks_Button;

    @FXML
    private TextField Blank_ID_To_Send;

    //-- Create blank -------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button Create_Blank_Button;

    @FXML
    private TextField Discount_ID_1;

    @FXML
    private TextField Discount_ID_2;

    @FXML
    private TextField Discount_ID_3;

    @FXML
    private TextField Discount_ID_4;

    //-- Sell Ticket --------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private TextField Blank_ID;

    @FXML
    private TextField Currency_Purchased;

    @FXML
    private TextField Customer_ID;

    @FXML
    private TextField Date;

    @FXML
    private TextField From_Location;

    @FXML
    private TextField Merchant_ID;

    @FXML
    private TextField Price;

    @FXML
    private Button Sell_Ticket_Button;

    @FXML
    private TextField To_Loaction;

    //-- Validate Tickets ---------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Admin_Validate_Ticket_Button;

    @FXML
    private TextField Ticket_ID_To_Validate;

    //-- Void Tickets -------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextField Ticket_ID_To_Void;

    @FXML
    private Button Void_Ticket_Button;

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------


    private Accounts Currently_Logged_In;
    @FXML
    private PasswordField Password_Entered;

    @FXML
    private TextField Role_Entered;

    @FXML
    private TextField Username_Entered;

    @FXML
    private Label Warning_Message;

    private Stage Stage;
    private Scene Scene;
    private Parent Root;

    @FXML
    void Log_In(ActionEvent event) throws IOException { // Log in button
        String Username = Username_Entered.getText();
        String Password = Password_Entered.getText();
        String Role = Role_Entered.getText();

        if ((Username.toUpperCase().contains("INSERT") || Password.toUpperCase().contains("INSERT") || Role.toUpperCase().contains("INSERT")) || (Username.toUpperCase().contains("SELECT") || Password.toUpperCase().contains("SELECT") || Role.toUpperCase().contains("SELECT"))) { //protection from SQL injections
            Warning_Message.setVisible(true);
        }
        else{
            String Query = "SELECT * FROM account WHERE Username = \""+ Username +"\" AND Password = \""+ Password +"\" AND Role = \""+ Role +"\";"; // This is the query that will be sent to the SQL server
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(Query);
                rs.next();
                System.out.println(rs.getString("Username"));

                if (rs.getString(1).equals("")){
                    System.out.println("No account found");
                    Warning_Message.setVisible(true);
                }

                else if (rs.getString("Username").equals(Username)  && rs.getString("Password").equals(Password) && rs.getString("Role").equals(Role)){
                    System.out.println("Log in successful");
                    if (Role.toUpperCase().equals("MANAGER")) { // This code switches the Screen to the Office manager control panel
                        String file = "Office-Manager-Control-Panel.fxml";
                        Change_Scene(event, file); // Make them the account that is currently signed in
                    }
                    else if (Role.toUpperCase().equals("ADMIN") || Role.toUpperCase().equals("SYSTEM ADMINISTRATOR")) { // This code switches the Screen to the System Admin control panel
                        String file = "System-Admin-Control-Panel.fxml";
                        Change_Scene(event, file);
                    }
                    else if (Role.toUpperCase().equals("ADVISOR") || Role.toUpperCase().equals("SALES ADVISOR")) { // This code switches the Screen to the Advisor control panel
                        String file = "Advisor-Control-Panel.fxml";
                        Change_Scene(event, file);
                    }
                    else {
                        Warning_Message.setVisible(true); // Displays warning message
                    }
                    Warning_Message.setVisible(false); // Put Scene transitions here


                }
                else{
                    System.out.println("Option 3");
                    Warning_Message.setVisible(true);
                }
                con.close();


            }
            catch (Exception e){
                System.out.println("RIP connection");
                System.out.println(e);

            }
        }
    }

    @FXML
    void Manage_Blanks(ActionEvent event) throws IOException { //Not working
        String file = "System-Admin-Manage-Blanks.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Go_To_Blacklist_Blank(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Blanks-Blacklist-Blank.fxml";
        Change_Scene(event, file);

    }

    @FXML
    void Go_To_Allocate_Blanks(ActionEvent event) throws IOException { // Make the page they visit depend on their role
        String file = "System-Admin-Manage-Blanks-Allocate-Blanks.fxml";
        Change_Scene(event, file);

    }

    @FXML
    void Blacklist_Blank(ActionEvent event) {
        String Blank_ID = Blacklist_Blank_ID.getText();
        if (Blank_ID.toUpperCase().contains("INSERT") || Blank_ID.toUpperCase().contains("UPDATE") || Blank_ID.toUpperCase().contains("SELECT")){
            //Make message visible
        }
        else{
            try{
                String Query = "SELECT * FROM Blanks where Blank_ID = \""+ Blank_ID +"\""; // Add SQL injection protection, make sure that blank exists
                Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(Query);
                rs.next();
                //Add if statement to see if blank is not there
                if (rs.getString(Blank_ID).equals("")){
                    //  Display message to say that no such account exists
                }
                else{
                    Query = "UPDATE Blanks SET Valid = '0' where Blank_ID = \"" + Blank_ID +"\"";
                    rs = s.executeQuery(Query);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    void Change_Scene(ActionEvent event, String File) throws IOException {
        Root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(File)));
        Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene = new Scene(Root);
        Stage.setScene(Scene);
        Stage.show();
    }

    @FXML
    void Allocate_Blank(ActionEvent event) throws SQLException {
        //Check the Recipient ID exists
        //Check the ID transferred exists
        //Update Database
        boolean Recever_ID_Exists;
        boolean Blank_ID_Exists;

        String Blank_ID = Blank_ID_To_Send.getText();
        String Recever_ID = Account_ID_To_Send_Blank.getText();

        String Query1 = "SELECT * FROM Blanks WHERE ID = \"" + Blank_ID + "\";";
        String Query2 = "SELECT * FROM account WHERE ID = \"" + Recever_ID + "\";";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29", "in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
            Statement s = con.createStatement();

            ResultSet rs1 = s.executeQuery(Query1);
            rs1.next();
            if (rs1.getString("Blank_ID").equals("")) {
                // display message
                Blank_ID_Exists = false;
            } else {
                Blank_ID_Exists = true;
            }

            ResultSet rs2 = s.executeQuery(Query2);
            rs2.next();
            if (rs2.getString("ID").equals("")) {
                //display message that account doesn't exist
                Recever_ID_Exists = false;
            } else {
                Recever_ID_Exists = true;
            }

            if (Recever_ID_Exists && Blank_ID_Exists) {
                if (rs2.getString("Blanks_To_Give").equals("")) {
                    String Query3 = "UPDATE account SET Blanks_To_Give = \"" + Recever_ID + "\"";
                    s.executeQuery(Query3);
                } else {
                    String Previous_Blanks = rs2.getString("Blanks_To_Give");
                    String Query3 = "UPDATE account SET Blanks_To_Give = \"" + Previous_Blanks + Blank_ID + "\"";
                    s.executeQuery(Query3);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void Manage_Blanks_Manager(ActionEvent event) throws IOException {
        String file = "Office-Manager-Manage-Blanks.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Manager_Go_To_Allocate_Blanks(ActionEvent event) throws IOException {
       String file = "Office-Manager-Manage-Blanks-Allocate-Blanks.fxml";
       Change_Scene(event, file);
    }

    @FXML
    void Go_To_Create_Blanks(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Blanks-Create-Blank.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Create_Blank(ActionEvent event) {
        boolean valid = true;
        if (Discount_ID_1.getText().length() != 8 || Discount_ID_2.getText().length() != 8 || Discount_ID_3.getText().length() != 8 || Discount_ID_4.getText().length() != 8){
            valid = false;
        }
        if (Discount_ID_1.getText().toUpperCase().contains("INSERT") || Discount_ID_1.getText().toUpperCase().contains("SELECT") || Discount_ID_1.getText().toUpperCase().contains("UPDATE") || Discount_ID_1.getText().toUpperCase().contains("DROP")){
            valid = false;
        }
        if (Discount_ID_2.getText().toUpperCase().contains("INSERT") || Discount_ID_2.getText().toUpperCase().contains("SELECT") || Discount_ID_2.getText().toUpperCase().contains("UPDATE") || Discount_ID_2.getText().toUpperCase().contains("DROP")){
            valid = false;
        }
        if (Discount_ID_3.getText().toUpperCase().contains("INSERT") || Discount_ID_3.getText().toUpperCase().contains("SELECT") || Discount_ID_3.getText().toUpperCase().contains("UPDATE") || Discount_ID_3.getText().toUpperCase().contains("DROP")){
            valid = false;
        }
        if (Discount_ID_4.getText().toUpperCase().contains("INSERT") || Discount_ID_4.getText().toUpperCase().contains("SELECT") || Discount_ID_4.getText().toUpperCase().contains("UPDATE") || Discount_ID_4.getText().toUpperCase().contains("DROP")){
            valid = false;
        }

        String[] Discount_IDs = {Discount_ID_1.getText(), Discount_ID_2.getText(), Discount_ID_3.getText(), Discount_ID_4.getText()};
        if (valid){
            Blank blank = new Blank(Discount_IDs);
        }
        else{
            //Display message
        }
    }

    @FXML
    void Go_To_Sell_Ticket(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Blanks-Sell-Tickets.fxml";
        Change_Scene(event, file);
    }

    boolean Check_SQL_Injection(String[] string){
        for (int i = 0; i < string.length; i++){
            if (string[i].toUpperCase().contains("INSERT") || string[i].toUpperCase().contains("SELECT") || string[i].toUpperCase().contains("DROP") || string[i].toUpperCase().contains("UPDATE")){
                return false;
            }
        }
        return true;
    }

    boolean Check_SQL_Injection(String string){
        if (string.toUpperCase().contains("INSERT") || string.toUpperCase().contains("SELECT") || string.toUpperCase().contains("DROP") || string.toUpperCase().contains("UPDATE")){
            return false;
        }
        else{
            return true;
        }
    }

    @FXML
    void Sell_Ticket(ActionEvent event) {

        String Blank = Blank_ID.getText();
        String Currency_Purchased_In = Currency_Purchased.getText();
        String Customer_Purchaced_ID = Customer_ID.getText();
        String Destination = To_Loaction.getText();
        String From = From_Location.getText();
        String Seller_ID = Merchant_ID.getText();


        try{
            int Amount = Integer.getInteger(Price.getText());
            int Date_Purchaced = Integer.getInteger(Date.getText()); // Make sure it's an int
        }
        catch (Exception e){
            System.out.println(e);
            //Display message that Amount is invalid
        }

        if (Blank.length() == 8 && Customer_Purchaced_ID.length() == 8 && Seller_ID.length() == 8 && Currency_Purchased_In.length() > 5 && Date.getText().length() == 6){
            String[] Data = {Blank, Currency_Purchased_In, Customer_Purchaced_ID, Destination, From, Seller_ID};
            if (Check_SQL_Injection(Data)){
                // Store Values make sure tickets are unique
            }
            else{
                //Display error
            }
        }
        else{
            //Display error
        }
    }

    @FXML
    void Go_To_Validate_Ticket(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Blanks-Validate-Ticket.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Validate_Ticket(ActionEvent event) {
        String Ticket_ID = Ticket_ID_To_Validate.getText();
        if (Check_SQL_Injection(Ticket_ID) && Ticket_ID.length() == 8){
            //Do something to database
        }
        else{
            // Display error message
        }
    }

    @FXML
    void Go_To_Void_Ticket(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Tickets-Void-Ticket.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Void_Ticket(ActionEvent event) {
        String Ticket_ID = Ticket_ID_To_Void.getText();
        if (Ticket_ID.length() == 8){
            if (Check_SQL_Injection(Ticket_ID)){
                //Void ticket in database
            }
            else{
                //Scream at user
            }
        }
        else{
            //Display message
        }
    }
}
