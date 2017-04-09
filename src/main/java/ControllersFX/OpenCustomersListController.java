/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllersFX;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import database.Model.Customer;
import java.util.ArrayList;


public class OpenCustomersListController{

    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableColumn<Customer, Integer> col_id;
    @FXML
    private TableColumn<Customer, String> col_firstname;
    @FXML
    private TableColumn<Customer, String> col_lastname;
    @FXML
    private TableColumn<Customer, String> col_dateOfBirth;
    @FXML
    private TableColumn<Customer, Integer> col_phoneNumber;


    private ObservableList<Customer> data;

    @FXML
    public void initialize() {
        data=FXCollections.observableArrayList();
        ArrayList<Customer> list = MenuButtonsController.getDatabaseController().getCustomers();
        list.forEach((customer) -> {
            data.add(customer);
        });

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        col_dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        tableView.setItems(data);
    }

    
}

