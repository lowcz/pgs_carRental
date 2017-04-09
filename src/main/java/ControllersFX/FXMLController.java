package ControllersFX;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import database.Controller.CarRental;
import java.util.HashSet;
import java.util.Set;

public class FXMLController {
    public CarRental databaseController;
    @FXML
    private MenuButtonsController menuButtonsController;
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    public void initialize() {
        menuButtonsController.setMainController(this);
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
        databaseController = new CarRental();
        menuButtonsController.setDatabaseController(databaseController);
        
        
    }    
    
    public void setCenter(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent=null;
        try {
            parent = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderPane.setCenter(parent);
    }
}
