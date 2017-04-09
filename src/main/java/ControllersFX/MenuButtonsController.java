package ControllersFX;

import database.Controller.CarRental;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MenuButtonsController {
    public static final String OPEN_CARS_LISTFXML = "/fxml/OpenCarsList.fxml";
    public static final String ADD_CARFXML = "/fxml/AddCar.fxml";
    public static final String ADD_CUSTOMERFXML = "/fxml/AddCustomer.fxml";
    public static final String OPEN_CUSTOMERS_LISTFXML = "/fxml/OpenCustomersList.fxml";
    public static final String OPEN_RENTALS_LISTFXML = "/fxml/OpenRentalsList.fxml";
    public static final String ADD_RENTALFXML = "/fxml/AddRental.fxml";
    public static final String ABOUTFXML = "/fxml/About.fxml";
    
    private FXMLController mainController;
    private static CarRental databaseController;

    public static CarRental getDatabaseController() {
        return databaseController;
    }

    public static void setDatabaseController(CarRental databaseController) {
        MenuButtonsController.databaseController = databaseController;
    }

    
    @FXML
    public void initialize() {
        
    }

    public void setMainController(FXMLController mainController) {
        this.mainController = mainController;
    }
    
    @FXML
    public void OpenCustomersList( ){
        mainController.setCenter(OPEN_CUSTOMERS_LISTFXML);
    }
    @FXML
    public void AddCustomer( ){
        mainController.setCenter(ADD_CUSTOMERFXML);
    }
    
    @FXML
    public void OpenCarsList( ){
        mainController.setCenter(OPEN_CARS_LISTFXML);
    }
    @FXML
    public void AddCar( ){
        mainController.setCenter(ADD_CARFXML);
    }

    @FXML
    public void OpenRentalsList( ){
        mainController.setCenter(OPEN_RENTALS_LISTFXML);
    }
    @FXML
    public void AddRental( ){
        mainController.setCenter(ADD_RENTALFXML);
    }    
}
