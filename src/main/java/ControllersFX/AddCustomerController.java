package ControllersFX;

import database.Controller.CarRental;
import database.Model.Customer;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddCustomerController {

    @FXML
    private TextField firstnameText;
    @FXML
    private TextField lastnameText;
    @FXML
    private TextField dateText;
    @FXML
    private TextField phoneNumberText;


    
    
    @FXML
    public void initialize() {
        phoneNumberText.textProperty().addListener(
        (observable, oldValue, newValue) -> {
         if(!newValue.matches("\\d+")&&!newValue.equals(""))
            ((StringProperty)observable).setValue(oldValue);
         }
        );

    }
    
    @FXML
    public void InsertToDatabase(){
        Customer customer;
        if (!firstnameText.getText().equals("") && !lastnameText.getText().equals("") && !dateText.getText().equals("") && !phoneNumberText.getText().equals(""))
        {
            if (dateText.getText().matches("\\d{2}[.]\\d{2}[.]\\d{4}")){
                customer = new Customer();
                customer.setFirstName(firstnameText.getText());
                customer.setLastName(lastnameText.getText());
                customer.setPhoneNumber(Long.parseLong(phoneNumberText.getText()));
                customer.setDate(dateText.getText());

                MenuButtonsController.getDatabaseController().addCustomer(customer);
                firstnameText.setText("");
                lastnameText.setText("");
                dateText.setText("");
                phoneNumberText.setText("");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd");
                alert.setHeaderText("Wystąpił błąd");
                alert.setContentText("Nieprawidłowa data urodzenia. Podaj poprawną datę (DD.MM.RRRR)");
                alert.showAndWait();
            }
            

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wystąpił błąd");
            alert.setContentText("Wypełnij wszystkie pola");
            alert.showAndWait();
        }
    }
}
