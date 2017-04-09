/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersFX;

import database.Model.RentalView;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class OpenRentalsListController {

    @FXML
    private TableView<RentalView> tableView;
    @FXML
    private TableColumn<RentalView, Integer> col_customerId;
    @FXML
    private TableColumn<RentalView, String> col_firstname;
    @FXML
    private TableColumn<RentalView, String> col_lastname;
    @FXML
    private TableColumn<RentalView, String> col_carId;
    @FXML
    private TableColumn<RentalView, String> col_brand;
    @FXML
    private TableColumn<RentalView, String> col_model;
    @FXML
    private TableColumn<RentalView, String> col_start;
    @FXML
    private TableColumn<RentalView, String> col_end;    
    
    private ObservableList<RentalView> data;

    @FXML
    public void initialize() {
        data=FXCollections.observableArrayList();
        ArrayList<RentalView> list = MenuButtonsController.getDatabaseController().getRentalsInfo();
        list.forEach((rentalInfo) -> {
            data.add(rentalInfo);
        });

        
        col_customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        col_carId.setCellValueFactory(new PropertyValueFactory<>("carId"));
        col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        col_start.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        col_end.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        
        tableView.setItems(data);
    }    
    
}
