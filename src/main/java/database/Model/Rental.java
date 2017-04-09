
package database.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rental 
{
    private IntegerProperty id;
    private IntegerProperty carId;
    private IntegerProperty customerId;
    private StringProperty startDate;
    private StringProperty endDate;
    private IntegerProperty cost;

    public Rental() {
        this.id = new SimpleIntegerProperty();
        this.carId = new SimpleIntegerProperty();
        this.customerId = new SimpleIntegerProperty();
        this.startDate = new SimpleStringProperty();
        this.endDate = new SimpleStringProperty();
        this.cost = new SimpleIntegerProperty();
    }
    
    public String getStartDate(){return startDate.getValue();}
    public void setStartDate(String date){startDate.setValue(date);}
    
    public String getEndDate(){return endDate.getValue();}
    public void setEndDate(String date){endDate.setValue(date);}
    
    public int getCarId(){return carId.getValue();}
    public void setCarId(int carId) {this.carId.setValue(carId);}
    
    public int getCustomerId(){return customerId.getValue();}
    public void setCustomerId(int customerId) {this.customerId.setValue(customerId);}
    
    public int getCost(){return cost.getValue();}
    public void setCost(int cost) {this.cost.setValue(cost);}
        
    public int getId(){return id.getValue();}
    public void setId(int id){this.id.setValue(id);}
}
