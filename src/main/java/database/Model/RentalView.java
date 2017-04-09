
package database.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class RentalView {
    private StringProperty firstname;
    private StringProperty lastname;    
    private StringProperty brand;
    private StringProperty model;
    private StringProperty startDate; 
    private StringProperty endDate; 
    private IntegerProperty carId;
    private IntegerProperty customerId;

    public RentalView() {
        this.firstname = new SimpleStringProperty();
        this.lastname = new SimpleStringProperty();
        this.brand = new SimpleStringProperty();
        this.model = new SimpleStringProperty();
        this.startDate = new SimpleStringProperty();
        this.endDate = new SimpleStringProperty();
        this.carId = new SimpleIntegerProperty();
        this.customerId = new SimpleIntegerProperty();
    }

    public String getFirstname() {
        return firstname.getValue();
    }

    public void setFirstname(String firstname) {
        this.firstname.setValue(firstname);
    }

    public String getLastname() {
        return lastname.getValue();
    }

    public void setLastname(String lastname) {
        this.lastname.setValue(lastname);
    }

    public String getBrand() {
        return brand.getValue();
    }

    public void setBrand(String brand) {
        this.brand.setValue(brand);
    }

    public String getModel() {
        return model.getValue();
    }

    public void setModel(String model) {
        this.model.setValue(model);
    }

    public String getStartDate() {
        return startDate.getValue();
    }

    public void setStartDate(String startDate) {
        this.startDate.setValue(startDate);
    }

    public String getEndDate() {
        return endDate.getValue();
    }

    public void setEndDate(String endDate) {
        this.endDate.setValue(endDate);
    }

    public int getCarId() {
        return carId.getValue();
    }

    public void setCarId(int carId) {
        this.carId.setValue(carId);
    }

    public int getCustomerId() {
        return customerId.getValue();
    }

    public void setCustomerId(int customerId) {
        this.customerId.setValue(customerId);
    }
    
}
