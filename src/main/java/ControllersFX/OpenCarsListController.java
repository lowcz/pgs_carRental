/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersFX;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import database.Model.Car;
import java.util.ArrayList;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;


public class OpenCarsListController{

    @FXML
    private TableView<Car> tableView;
    @FXML
    private TableColumn<Car, Integer> col_id;
    @FXML
    private TableColumn<Car, String> col_brand;
    @FXML
    private TableColumn<Car, String> col_model;
    @FXML
    private TableColumn<Car, String> col_color;
    @FXML
    private TableColumn<Car, Integer> col_year;
    @FXML
    private TableColumn<Car, Integer> col_mileage;
    @FXML
    private TableColumn<Car, Integer> col_cost;    
   // @FXML
   // private TableColumn<Car, Integer> col_available;
    @FXML//TODO
    private TableColumn<Car, Boolean> col_available;//TODO
    @FXML
    private ToggleButton switchButton;
    
    private ObservableList<Car> data;
    
    private void loadData(boolean mode){
        data=FXCollections.observableArrayList();
        data.clear();
        ArrayList<Car> list = MenuButtonsController.getDatabaseController().getCars(mode);
        list.forEach((car) -> {
            data.add(car);
        });
    }            
    
    @FXML
    public void initialize() {
        /*data=FXCollections.observableArrayList();
        ArrayList<Car> list = MenuButtonsController.getDatabaseController().getCars(false);
        list.forEach((car) -> {
            data.add(car);
        });*/
        loadData(false);
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        col_color.setCellValueFactory(new PropertyValueFactory<>("color"));
        col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        col_mileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        //col_available.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
        
        //col_available.setCellValueFactory(cellData -> new SimpleIntegerProperty(new ReadOnlyObjectWrapper<>(cellData.getValue().getIsAvailable())));
        col_available.setCellValueFactory(cellData -> cellData.getValue().getAvailabilityProperty());
        
        col_available.setCellFactory(col -> new TableCell<Car, Boolean>() {
    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty) ;
        setText(empty ? null : item ? "TAK" : "NIE" );
    }
});
        
        tableView.setItems(data);
    }
    @FXML
    public void switchButtonAction(){
        switchButton.setText(switchButton.isSelected() ? "pokaż wszystkie" : "pokaż tylko dostępne");
        loadData(switchButton.isSelected());
        tableView.setItems(data);
        col_available.setVisible(!switchButton.isSelected());
    }
    
}
