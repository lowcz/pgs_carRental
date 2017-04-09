package ControllersFX;

import database.Controller.CarRental;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import database.Model.Car;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class AddCarController {
    private static CarRental databaseController;

    @FXML
    private TextField costText;
    @FXML
    private TextField modelText;
    @FXML
    private TextField brandText;
    @FXML
    private TextField yearText;
    @FXML
    private TextField mileageText;
    @FXML
    private TextField colorText;

    
    
    @FXML
    public void initialize() {
        AddCarController.databaseController=MenuButtonsController.getDatabaseController();
        yearText.textProperty().addListener(
        (observable, oldValue, newValue) -> {
         if(!newValue.matches("\\d+")&&!newValue.equals(""))
            ((StringProperty)observable).setValue(oldValue);
         }
        );
        costText.textProperty().addListener(
        (observable, oldValue, newValue) -> {
         if(!newValue.matches("\\d+")&&!newValue.equals(""))
            ((StringProperty)observable).setValue(oldValue);
         }
        );        
        mileageText.textProperty().addListener(
        (observable, oldValue, newValue) -> {
         if(!newValue.matches("\\d+")&&!newValue.equals(""))
            ((StringProperty)observable).setValue(oldValue);
         }
        );        
    }
    
    @FXML
    public void InsertToDatabase(){
        Car car;
        if (!brandText.getText().equals("") && !modelText.getText().equals("") && !colorText.getText().equals("") 
            && !costText.getText().equals("") && !mileageText.getText().equals("") && !yearText.getText().equals(""))
        {
            car = new Car();
            car.setBrand(brandText.getText());
            car.setModel(modelText.getText());
            car.setColor(colorText.getText());
            car.setCost(Integer.parseInt(costText.getText()));
            car.setMileage(Integer.parseInt(mileageText.getText()));
            car.setYear(Integer.parseInt(yearText.getText()));
            car.setIsAvailable(1);//new car is available
            databaseController.addCar(car);
            brandText.setText("");
            modelText.setText("");
            colorText.setText("");
            costText.setText("");
            mileageText.setText("");
            yearText.setText("");
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wystąpił błąd");
            alert.setContentText("Wypełnij wszystkie pola");
            alert.showAndWait();
        }
    }
    
}
