package ControllersFX;


import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class AboutController {

    @FXML
    private Label labelPicture;

    

    @FXML
    public void initialize() {
        labelPicture.setVisible(false);
    }    
    
    @FXML
    public void mouseEntered(){
        labelPicture.setVisible(true);
    }
    @FXML
    public void mouseExited(){
        labelPicture.setVisible(false);
    }
}
