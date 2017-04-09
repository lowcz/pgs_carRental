package database.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer 
{
    private IntegerProperty id;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty date;
    private LongProperty phoneNumber;

    public Customer() {
        this.id = new SimpleIntegerProperty();
        this.firstname = new SimpleStringProperty();
        this.lastname = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        this.phoneNumber = new SimpleLongProperty();
    }
    
    public String getFirstName(){return firstname.getValue();}
    public void setFirstName(String firstname) {this.firstname.setValue(firstname);}
    
    public String getLastName(){return lastname.getValue();}
    public void setLastName(String lastname) {this.lastname.setValue(lastname);}
    
    public String getDate(){return date.getValue();}
    public void setDate(String dateOfBirth) {this.date.setValue(dateOfBirth);}
    
    public long getPhoneNumber(){return phoneNumber.getValue();}
    public void setPhoneNumber(long phoneNumber) {this.phoneNumber.setValue(phoneNumber);}
    
    public int getId(){return id.getValue();}
    public void setId(int id){this.id.setValue(id);}

    @Override
    public String toString() {
        return firstname.getValue() + " " + lastname.getValue() + " (" + id.getValue() + ")";
    }
   
    
}
