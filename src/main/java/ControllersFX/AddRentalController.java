package ControllersFX;

import database.Model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddRentalController {
    @FXML
    private ComboBox<Car> carCombo;
    @FXML
    private ComboBox<Customer> customerCombo;
    @FXML
    private TextField daysInput;
    @FXML
    private Label costSummary;
    @FXML
    private Button button;
    
    private ObservableList<Customer> dataCustomers;
    private ObservableList<Car> dataCars;    
    @FXML
    public void initialize() {
        daysInput.textProperty().addListener(
        (observable, oldValue, newValue) -> {
         if(!newValue.equals("")&&!newValue.matches("\\d{0,3}"))
            ((StringProperty)observable).setValue(oldValue);
            calculateCost();
         }
        );
        
        dataCustomers=FXCollections.observableArrayList();
        ArrayList<Customer> listCustomers = MenuButtonsController.getDatabaseController().getCustomers();
        listCustomers.forEach((customer) -> {
            dataCustomers.add(customer);
        });
        customerCombo.getItems().addAll(dataCustomers);
        
        dataCars=FXCollections.observableArrayList();
        ArrayList<Car> listCars = MenuButtonsController.getDatabaseController().getCars(true);
        listCars.forEach((car) -> {
            dataCars.add(car);
        });
        carCombo.getItems().addAll(dataCars);

    }    
    
    @FXML
    public void InsertToDatabase() throws ParseException{
        Rental rental;
        if (carCombo.getValue()!=null && customerCombo.getValue()!=null && !daysInput.getText().equals("")){
            rental=new Rental();
            Car car=carCombo.getValue();
            rental.setCarId(car.getId());
            rental.setCustomerId(customerCombo.getValue().getId());
            rental.setCost(car.getCost() * Integer.parseInt(daysInput.getText()));
            
            DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            
            Date convertedStartDate = parser.parse(LocalDate.now().toString());
            String outputStartDate = formatter.format(convertedStartDate);
            rental.setStartDate(outputStartDate);
            
            Date convertedEndDate = parser.parse(LocalDate.now().plusDays(Integer.parseInt(daysInput.getText())).toString());
            String outputEndDate = formatter.format(convertedEndDate);
            rental.setEndDate(outputEndDate);
            
           
            carCombo.setValue(null);
            customerCombo.setValue(null);
            costSummary.setText("");
            carCombo.getItems().remove(car);
            MenuButtonsController.getDatabaseController().addRental(rental);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wystąpił błąd");
            alert.setContentText("Wypełnij wszystkie pola");
            alert.showAndWait();
        }

        
    }
    @FXML
    public void calculateCost(){
        costSummary.setText("");
        Integer cost;
        if(carCombo.getValue()!=null)
            if(!daysInput.getText().equals("")){
                cost =(carCombo.getValue().getCost()*Integer.parseInt(daysInput.getText()));
                costSummary.setText("Koszt: " + cost.toString()+ " zł");
            }
    }
    
}
