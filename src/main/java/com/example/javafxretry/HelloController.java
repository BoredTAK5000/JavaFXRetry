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
import java.util.Random;

//import com.mysql.jdbc.ResultSet;
import javafx.stage.Stage;

public class HelloController {


    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-- Manager Buttons ----------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //-- Control Panel buttons ---------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button Manager_Manage_Blanks_Button;

    @FXML
    private Button Manager_Go_To_Manager_Customers;

    //-- Manage Blanks ------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Button Manader_Go_To_Allocate_Blanks_Button;

    //-- Manage Customers ---------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Manager_Go_To_Create_Customer;

    @FXML
    private Button Manager_Go_To_Delete_Customer_Button;

    //-- Create Customer ----------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Create_Customer_Button;

    @FXML
    private TextField Customer_1st_Address_Line;

    @FXML
    private TextField Customer_City;

    @FXML
    private TextField Customer_Country;

    @FXML
    private TextField Customer_Email;

    @FXML
    private TextField Customer_Name;

    @FXML
    private TextField Customer_Phone_Number;

    @FXML
    private TextField Customer_Postcode;

    @FXML
    private TextField Flex_Or_Fixed_Discount;

    //-- Delete Customer ----------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Delete_Customer_Button;

    @FXML
    private TextField Manager_Account_ID_To_Delete;

    @FXML
    private TextField Manager_Email_Of_Customer_To_Delete;

    @FXML
    private TextField Manager_Name_Of_Customer_To_Delete;

    //-- Alter Customer------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Alter_Customer_Account_Button;

    @FXML
    private TextField Customer_New_Address;

    @FXML
    private TextField Customer_New_City;

    @FXML
    private TextField Customer_New_Country;

    @FXML
    private TextField Customer_New_Email;

    @FXML
    private TextField Customer_New_Fix_Or_Fle_Discount;

    @FXML
    private TextField Customer_New_ID;

    @FXML
    private TextField Customer_New_Name;

    @FXML
    private TextField Customer_New_Phone_Number;

    @FXML
    private TextField Customer_New_Postcode;

    //-- Manage Discount ----------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextField Manager_Alter_Customer_Flex_Or_Fix;

    @FXML
    private Button Manager_Alter_Discount_Button;

    @FXML
    private TextField Manager_Customer_ID_To_Change;

    @FXML
    private TextField Manager_Percentage_Discount;

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

    @FXML
    private Button Admin_Go_To_Manage_Accounts_Button;

    //-- Manage Accounts ----------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Admin_Go_To_Alter_Account_Button;

    @FXML
    private Button Admin_Go_To_Create_Account_Button;

    @FXML
    private Button Admin_Go_To_Delete_Account_Button;

    //-- Alter Accounts -----------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button Admin_Go_To_Change_Username_Button;


    @FXML
    private Button Admin_Go_To_Change_Password_Button;

    @FXML
    private Button Admin_Go_To_Change_Role_Button;

    //-- Change Username ----------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextField Admin_Account_ID_To_Change_Username;

    @FXML
    private TextField Admin_New_Username;

    @FXML
    private TextField Admin_Password_Of_Account;

    @FXML
    private Button Change_Username_Button;

    //-- Change Password ----------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private TextField Admin_Change_Password_Account_ID;

    @FXML
    private TextField Admin_Current_Password_Of_Account;

    @FXML
    private TextField Admin_New_Password1;

    @FXML
    private TextField Admin_New_Password2;

    @FXML
    private Button Admin_Change_Password_Button;

    //-- Change Role ---------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextField Admin_Account_ID_To_Change_Role;

    @FXML
    private TextField Admin_Account_Password_To_Give_Password;

    @FXML
    private TextField Admin_Account_Username;

    @FXML
    private Button Admin_Change_Role_Button;

    @FXML
    private TextField Admin_New_Role;

    //-- Create Account -----------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextField Admin_Create_Account_Agency;

    @FXML
    private Button Admin_Create_Account_Button;

    @FXML
    private TextField Admin_Create_Account_Full_Name;

    @FXML
    private PasswordField Admin_Create_Account_Password;

    @FXML
    private TextField Admin_Create_Account_Phone_Number;

    @FXML
    private TextField Admin_Create_Account_Role;

    @FXML
    private TextField Admin_Create_Account_Username;

    //-- Delete Account -----------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextField Admin_Account_ID_To_Delete;

    @FXML
    private Button Admin_Delete_Account_Button;

    @FXML
    private PasswordField Admin_Password_To_Delete;

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

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-- Blanks -------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

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
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------



    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-- Accounts --------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    void Go_To_Manage_Accounts(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Accounts.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Admin_Go_To_Alter_Account(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Accounts-Alter.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Admin_Go_To_Change_Username(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Accounts-Alter-Change-Username.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Admin_Go_To_Change_Password(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Accounts-Alter-Change-Password.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Admin_Go_To_Change_Role(ActionEvent event) throws IOException { // Program
        String file = "System-Admin-Manage-Accounts-Alter-Change-Role.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Change_Username(ActionEvent event) throws SQLException {
        String Account_ID = Admin_Account_ID_To_Change_Username.getText();
        String New_Username = Admin_New_Username.getText();
        String Password = Admin_Password_Of_Account.getText();
        String[] Check = {Account_ID, New_Username, Password};
        if (Check_SQL_Injection(Check) && Check_Account_Exists(Account_ID)){
            try {
                String Query = "SELECT * FROM accounts where ID = \""+ Account_ID +"\""; // Add SQL injection protection, make sure that blank exists
                Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(Query);
                rs.next();
                if (rs.getString("Password").equals(Password)){
                    String Query1 = "UPDATE account SET Username = \" "+New_Username+"\" WHERE ID = \""+Account_ID+"\"";
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29", "in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                    Statement s1 = con1.createStatement();
                    ResultSet rs1 = s1.executeQuery(Query1);
                }
                else{
                    //Display Message
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            //Display Error
        }
    }
    boolean Check_Account_Exists(String Account_ID) throws SQLException {
        try{
            String Query = "SELECT * FROM accounts where ID = \""+ Account_ID +"\""; // Add SQL injection protection, make sure that blank exists
            Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            rs.next();
            if (rs.getString("ID") == ""){
                return false;
            }
            else{
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @FXML
    void Change_Password(ActionEvent event) throws SQLException {
        String New_Password1 = Admin_New_Password1.getText();
        String New_Password2 = Admin_New_Password2.getText();
        String Old_Password = Admin_Current_Password_Of_Account.getText();
        String ID = Admin_Change_Password_Account_ID.getText();

        String[] Data = {New_Password1, New_Password2, Old_Password, ID};
        if (New_Password1.equals(New_Password2) && Check_Account_Exists(ID) && Check_SQL_Injection(Data)){
            if (Check_Password(ID, Old_Password)){
                String Query = "UPDATE account SET Password = \""+New_Password1+" \" WHERE ID =\""+ID+"\"";
                Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(Query);
            }
            else{
                //Display message
            }
        }
        else{
            //Display error
        }
    }

    boolean Check_Password(String ID, String Password){
        try{
            String Query = "SELECT * FROM accounts where ID = \""+ ID +"\""; // Add SQL injection protection, make sure that blank exists
            Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            rs.next();
            if (rs.getString("Password").equals(Password)){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @FXML
    void Change_Role(ActionEvent event) throws SQLException {

        String ID = Admin_Account_ID_To_Change_Role.getText();
        String Password = Admin_Account_Password_To_Give_Password.getText();
        String Username = Admin_Account_Username.getText();
        String New_Role = Admin_New_Role.getText();
        String[] Data = {ID, Password, Username, New_Role};

        if (Check_SQL_Injection(Data) &&  Check_Account_Exists(ID)){
            if (Check_Password(ID, Password)){
                String Query = "UPDATE account SET Role = \""+New_Role+" \" WHERE ID =\""+ID+"\"";
                Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(Query);
            }
            else{
                //Display message
            }
        }
        else{
            //Display Message
        }
    }

    @FXML
    void Admin_Create_Account(ActionEvent event) {
        // Check length of phone number

        String Full_Name = Admin_Create_Account_Full_Name.getText();
        String Username = Admin_Create_Account_Username.getText();
        String Role = Admin_Create_Account_Role.getText();
        String Agency = Admin_Create_Account_Agency.getText();
        String Password = Admin_Create_Account_Password.getText();

        String[] Data = {Full_Name, Username, Role, Agency, Password};
        try {
            int Phone_Number1 = Integer.getInteger(Admin_Create_Account_Phone_Number.getText());
            String Phone_Number2 = Admin_Create_Account_Phone_Number.getText();
            if (Check_Account_Doesnt_Exist(Password) && Check_SQL_Injection(Data) && Phone_Number2.length() == 8){

                if(Role.toUpperCase().equals("MANAGER")){
                    // Make Manager Account
                }
                else if (Role.toUpperCase().equals("ADMIN")) {
                    // Make Admin Account
                }
                else if (Role.toUpperCase().equals("ADVISOR")) {
                    // Make Advisor Account
                }
                else{
                    //Display message
                }

            }
            else{
                //Display message
            }
        }
        catch (Exception e){
            //display Error message
        }
    }

    boolean Check_Account_Doesnt_Exist(String Password){
        try{
            String Query = "SELECT * FROM accounts where Password = \""+ Password +"\""; // Add SQL injection protection, make sure that blank exists
            Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            rs.next();
            if (rs.getString("ID") == ""){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @FXML
    void Admin_Go_To_Create_Account(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Accounts-Create-Account.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Admin_Go_To_Delete_Account(ActionEvent event) throws IOException {
        String file = "System-Admin-Manage-Accounts-Delete-Account.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Admin_Delete_Account(ActionEvent event) throws SQLException {
        String ID = Admin_Account_ID_To_Delete.getText();
        String Password = Admin_Password_To_Delete.getText();

        String[] Data = {ID, Password};

        if (Check_SQL_Injection(Data) && Check_Account_Exists(ID)){
            String Query = "SELECT * FROM accounts where Password = \""+ Password +"\" AND ID = \""+ ID +"\";"; // Add SQL injection protection, make sure that blank exists
            Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            rs.next();
            if (rs.getString("ID").equals("")){
                //display message
            }
            else{
                Query = "DELETE FROM account WHERE ID = \""+ID+"\";";
                Connection con1 = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s1 = con1.createStatement();
                ResultSet rs1 = s1.executeQuery(Query);
            }
        }
        else{
            // Display message
        }
    }

    @FXML
    void Manager_Go_To_Manager_Customer(ActionEvent event) throws IOException {
        String file = "Office-Manager-Manage-Customers.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Manager_Go_To_Create_Customer(ActionEvent event) throws IOException {
        String file = "Office-Manager-Manage-Customers-Create-Account.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Create_Customer(ActionEvent event) throws SQLException {

        String City = Customer_City.getText();
        String Country = Customer_Country.getText();
        String Email = Customer_Email.getText();
        String Name = Customer_Name.getText();
        String Postcode = Customer_Postcode.getText();

        String[] Data = {City, Country, Email, Name, Postcode};

        if (Flex_Or_Fixed_Discount.getText().toUpperCase().equals("FIXED")){
            boolean Discount = true;
        }
        else if (Flex_Or_Fixed_Discount.getText().toUpperCase().equals("FLEXED")) {
            boolean Discount = false;
        }
        else{
            //Display Error
        }

        char[] Characters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j',
                'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',};
        String ID = "";
        boolean ID_Created = false;

        while(!(ID_Created)){
            ID = "";
            Random random = new Random();
            for (int i = 0; i < 8; i++){
                int j = random.nextInt();
                while (j < 52){
                    j = random.nextInt();
                }
                ID = ID + Characters[j];
            }
            String Query = "SELECT * FROM Customers WHERE ID = \" "+ ID +" \" ";
            Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            if(rs.getString(ID).equals("")){
                ID_Created = true;
            }
        }

        if (Check_SQL_Injection(Data)){
            String Query = "SELECT * FROM Customers WHERE ID = \" "+ID+" \" ";
            Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(Query);
            if(rs.getString(Email).equals("")){
                Query = "INSERT INTO Customer VALUES (\""+ID+"\", \""+Name+"\", \""+Email+"\", \""+Postcode+"\", \""+City+"\", \""+Country+"\")";
                System.out.println(Query);
                Connection con1 = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s1 = con1.createStatement();
                ResultSet rs1 = s1.executeQuery(Query);
            }
            else{
                //Display Message
            }
        }
        else{
            //display message
        }
    }

    @FXML
    void Manager_Go_To_Delete_Customer(ActionEvent event) throws IOException {
        String file = "Office-Manager-Manage-Customers-Delete-Account.fxml";
        Change_Scene(event, file);
    }

    @FXML
    void Delete_Customer(ActionEvent event) throws SQLException {
        String ID = Manager_Account_ID_To_Delete.getText();
        String Email = Manager_Email_Of_Customer_To_Delete.getText();
        String Name = Manager_Name_Of_Customer_To_Delete.getText();

        String Query = "SELECT * FROM Customers WHERE ID = \" "+ID+" \" AND Name = \""+Name+"\" AND Email = \""+Email+"\";";
        Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(Query);
        rs.next();
        if (rs.getString("ID").equals("")){
            //Display message
        }
        else{
            Query = "DELETE FROM Customer WHERE ID = \""+ID+"\";";
            Connection con1 = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
            Statement s1 = con1.createStatement();
            ResultSet rs1 = s1.executeQuery(Query);
        }
    }

    @FXML
    void Alter_Customer_Account(ActionEvent event) throws SQLException {

        String ID = Customer_New_ID.getText();
        String City = Customer_New_City.getText();
        String Country = Customer_New_Country.getText();
        String Email = Customer_New_Email.getText();
        String Name = Customer_New_Name.getText();
        String Postcode = Customer_New_Postcode.getText();
        String Discount = Customer_New_Fix_Or_Fle_Discount.getText();
        String Address = Customer_New_Address.getText();
        boolean valid = true;

        String[] Data = {City, Country, Email, Name, Postcode, Discount, Address};

        try{
            int Phone = Integer.valueOf(Customer_New_Phone_Number.getText());
        }
        catch (Exception e){
            //display message
            valid = false;
        }

        if (Check_SQL_Injection(Data)){
            if (valid){
                String Query = "DELETE FROM Customer WHERE ID = \""+ID+"\";";
                Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(Query);
                rs.next();
                if(rs.getString("ID").equals("")){
                    //display message
                }
                else{
                    Query = "UPDATE Customer SET Name = \""+ Name +"\", Email = \""+Email+"\", Postcode = \""+Postcode+"\", City = \""+City+"\", ";
                    System.out.println(Query);
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                    Statement s1 = con1.createStatement();
                    ResultSet rs1 = s1.executeQuery(Query);
                }
            }
        }
        else{
            //Display message
        }
    }

    @FXML
    void Manager_Alter_Discount(ActionEvent event) throws SQLException {

        String ID = Manager_Customer_ID_To_Change.getText();
        String Flex_Or_Fixed = "";

        boolean valid = true;
        if (Manager_Alter_Customer_Flex_Or_Fix.getText().toUpperCase().equals("FLEX") || Manager_Alter_Customer_Flex_Or_Fix.getText().toUpperCase().equals("FIXED")){
            Flex_Or_Fixed = Manager_Alter_Customer_Flex_Or_Fix.getText();
        }
        else{
            //Display message
            valid = false;
        }

        String[] Data = {ID, Flex_Or_Fixed};
        int Discount = 0;

        try{
            Discount = Integer.valueOf(Manager_Percentage_Discount.getText());
        }
        catch (Exception e){
            //display message
            valid = false;
        }

        if (Check_SQL_Injection(Data)){
            if(valid){
                String Query = "SELECT * FROM Customer WHERE ID = \""+ID+"\";";
                Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(Query);
                rs.next();
                if (rs.getString("ID").equals("")){
                    //display message
                }
                else{
                    Query = "UPDATE Customer SET Discount \""+Discount+"\", Flex_Or_Fixed = \""+Flex_Or_Fixed+"\" WHERE ID = \""+ID+"\";";
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                    Statement s1 = con1.createStatement();
                    ResultSet rs1 = s1.executeQuery(Query);
                }
            }
        }
        else{
            //display message
        }
    }
}
