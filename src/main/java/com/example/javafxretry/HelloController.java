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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

//import com.mysql.jdbc.ResultSet;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Button button;
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
            System.out.println(Query);
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2018g29","in2018g29_d", "vtF1zs6O"); // "jdbc:mysql://localhost:3306/in2018g29","in2018g29_d", "vtF1zs6O" "jdbc:mysql://hostname:port/dbname","username", "password"
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(Query);
                rs.next();
                System.out.println(rs.getString("Username"));

                System.out.println(rs.getString("Username")+", "+ Username);
                System.out.println(rs.getString("Password")+", "+ Password);
                System.out.println(rs.getString("Role")+", "+ Role);

                if (rs.getString(1) == ""){
                    System.out.println("No account found");
                    Warning_Message.setVisible(true);
                }

                else if (rs.getString("Username").equals(Username)  && rs.getString("Password").equals(Password) && rs.getString("Role").equals(Role)){
                    System.out.println("Log in successful");
                    if (Role.toUpperCase().equals("MANAGER")) { // This code switches the Screen to the Office manager control panel
                        Root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Office-Manager-Control-Panel.fxml")));
                        Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        Scene = new Scene(Root);
                        Stage.setScene(Scene);
                        Stage.show();
                    }
                    else if (Role.toUpperCase().equals("ADMIN") || Role.toUpperCase().equals("SYSTEM ADMINISTRATOR")) { // This code switches the Screen to the System Admin control panel
                        Root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("System-Admin-Control-Panel.fxml")));
                        Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        Scene = new Scene(Root);
                        Stage.setScene(Scene);
                        Stage.show();
                    }
                    else if (Role.toUpperCase().equals("ADVISOR") || Role.toUpperCase().equals("SALES ADVISOR")) { // This code switches the Screen to the Advisor control panel
                        System.out.println("Sales Advisor");
                        Root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Advisor-Control-Panel.fxml")));
                        Stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        Scene = new Scene(Root);
                        Stage.setScene(Scene);
                        Stage.show();
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
}

