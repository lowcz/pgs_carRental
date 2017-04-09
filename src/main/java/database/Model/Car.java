
package database.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Car 
{
    private IntegerProperty id;
    private StringProperty brand;
    private StringProperty model;
    private StringProperty color;
    private IntegerProperty year;
    private IntegerProperty mileage;
    private IntegerProperty cost;
    private IntegerProperty isAvailable; //used database doesn't support boolean type
    private BooleanProperty isAvailableBooleanProperty;

    public Car() {
        this.id = new SimpleIntegerProperty();
        this.brand = new SimpleStringProperty();
        this.model = new SimpleStringProperty();
        this.color = new SimpleStringProperty();
        this.year = new SimpleIntegerProperty();
        this.mileage = new SimpleIntegerProperty();
        this.cost = new SimpleIntegerProperty();
        this.isAvailable = new SimpleIntegerProperty();
        this.isAvailableBooleanProperty = new SimpleBooleanProperty();
    }


    public String getBrand(){return brand.getValue();}
    public void setBrand(String brand) {this.brand.setValue(brand);}
    
    public String getModel(){return model.getValue();}
    public void setModel(String model) {this.model.setValue(model);}
    
    public String getColor(){return color.getValue();}
    public void setColor(String color) {this.color.setValue(color);}
    
    public int getYear(){return year.getValue();}
    public void setYear(int year) {this.year.setValue(year);}
    
    public int getCost(){return cost.getValue();}
    public void setCost(int cost) {this.cost.setValue(cost);}
    
    public int getMileage(){return mileage.getValue();}
    public void setMileage(int mileage) {this.mileage.setValue(mileage);}
    
    public int getId(){return id.getValue();}
    public void setId(int id) {this.id.setValue(id);}
    
    public int getIsAvailable(){return isAvailable.getValue();}
    public void setIsAvailable(int state){
        isAvailable.setValue(state);
        isAvailableBooleanProperty.setValue((state==1));
    }
    
    public BooleanProperty getAvailabilityProperty(){return isAvailableBooleanProperty;}

    @Override
    public String toString() {
       return brand.getValue() + " " + model.getValue() + " (" + id.getValue() + ")";
    }
    
}
