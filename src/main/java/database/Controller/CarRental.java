
package database.Controller;
import database.Model.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarRental {

    private Connection con;
    private static String driverName = "org.sqlite.JDBC";
    private static String databaseURL = "jdbc:sqlite:carDB;create=true;user=user1&password=pass";

    public CarRental() {
        this.init();
    }
    
    private void init(){
        try {
            Class.forName(driverName);
            con=DriverManager.getConnection(databaseURL);
            createTables();
        } catch (Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Could not establish connection with database", ex);
            con = null;
        }
        
    }
    private void createTables(){
        try {
            Statement st = con.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS CARS " +
                    "(id INTEGER primary key autoincrement, " +
                    "brand varchar(25), " +
                    "model varchar(25), " +
                    "prodYear integer, " +
                    "mileage integer, " +
                    "color varchar(20), " +
                    "costPerDay integer, " +
                    "isAvailable boolean);");
            st.execute("CREATE TABLE IF NOT EXISTS CUSTOMERS " +
                    "(id integer primary key autoincrement, " +
                    "firstname varchar(25), " +
                    "lastname varchar(25), " +
                    "dateOfBirth char(10), " +
                    "phoneNumber integer);");
            st.execute("CREATE TABLE IF NOT EXISTS RENTALS " +
                    "(id integer primary key autoincrement, " +
                    "carId integer, " +
                    "customerId integer, " +
                    "startDate Text, " +
                    "endDate Text," +
                    "cost integer," +
                    "FOREIGN KEY(carId) REFERENCES CARS(id)" +
                    "FOREIGN KEY(customerID) REFERENCES CUSTOMERS(id)); ");    
            st.execute("CREATE VIEW IF NOT EXISTS RENTALS_INFO AS " +
                        "SELECT " +
                        "c.id AS customerId, " +
                        "c.firstname AS firstname, " +
                        "c.lastname AS lastname, " +
                        "car.id AS carId, " +
                        "car.brand AS brand, " +
                        "car.model AS model, " +
                        "r.startDate AS start, " +
                        "r.endDate AS end " +
                        "FROM RENTALS r LEFT JOIN CUSTOMERS c on r.customerId=c.id " +
                        "LEFT JOIN CARS car on r.carId=car.id;");
        } catch (Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Error while creating tables", ex);
        }
    }
    
    public void addCar(Car car){

        try{
        Statement st = con.createStatement();
        st.execute(String.format("insert into CARS(brand, model, prodYear, mileage, color, costPerDay, isAvailable) values ('%s', '%s', %d, %d, '%s', %d, %d);", 
                car.getBrand(), car.getModel(), car.getYear(), car.getMileage(), car.getColor(), car.getCost(), car.getIsAvailable()));
        }
        catch (Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Error occured while adding values to database", ex);
        }
      }
    public void addCustomer(Customer customer){
        try{
        Statement st = con.createStatement();
        st.execute(String.format("insert into CUSTOMERS(firstname, lastname, dateOfBirth, phoneNumber) values ('%s', '%s', '%s', %d);", 
                customer.getFirstName(), customer.getLastName(), customer.getDate(), customer.getPhoneNumber()));
        }
        catch (Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Error occured while adding values to database", ex);
        }
    }
    public void addRental(Rental rental){
        try{
        Statement st = con.createStatement();
        st.execute(String.format("insert into RENTALS(carId, customerId, startDate, endDate, cost) values (%d, %d, '%s', '%s', %d);", 
                rental.getCarId(), rental.getCustomerId(), rental.getStartDate(), rental.getEndDate(), rental.getCost()));
        st.execute(String.format("update cars set isAvailable=0 where id=%d", rental.getCarId()));
        }
        catch (Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Error occured while adding values to database", ex);
        }
    }
    
    public ArrayList<Rental> getRentals(){
        ArrayList<Rental> list = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RENTALS;");
            Rental rental;
            while(rs.next()){
                rental=new Rental();
                rental.setId(rs.getInt("id"));
                rental.setCarId(rs.getInt("carId"));
                rental.setCustomerId(rs.getInt("customerId"));
                rental.setStartDate(rs.getString("startDate"));
                rental.setEndDate(rs.getString("endDate"));
                rental.setCost(rs.getInt("cost"));
                list.add(rental);
                }
        }
        catch(Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Error occured while reading from database", ex);
        }
        
        return list;
    }
    public ArrayList<Car> getCars(boolean availableOnly){
        ArrayList<Car> list = new ArrayList<>();
        String condition = availableOnly ? "WHERE isAvailable=1" : "WHERE 1";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM CARS %s;", condition));
            Car car;
            while(rs.next()){
                car=new Car();
                car.setId(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString ("model"));
                car.setYear(rs.getInt("prodYear"));
                car.setMileage(rs.getInt("mileage"));
                car.setColor(rs.getString("color"));
                car.setCost(rs.getInt("costPerDay"));
                car.setIsAvailable(rs.getInt("isAvailable"));
                list.add(car);
                }
        }
        catch(Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Error occured while reading from database", ex);
        }
        
        return list;
    }
    public ArrayList<Customer> getCustomers(){
        ArrayList<Customer> list = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMERS;");
            Customer customer;
            while(rs.next()){
                customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString ("lastname"));
                customer.setDate(rs.getString("dateOfBirth"));
                customer.setPhoneNumber(rs.getLong("phoneNumber"));
                list.add(customer);
                }
        }
        catch(Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Error occured while reading from database", ex);
        }
        
        return list;
    }
    public ArrayList<RentalView> getRentalsInfo(){
        ArrayList<RentalView> list = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RENTALS_INFO;");
            RentalView rentalView;
            while(rs.next()){
                rentalView = new RentalView();
                rentalView.setCustomerId(rs.getInt("customerId"));
                rentalView.setFirstname(rs.getString("firstname"));
                rentalView.setLastname(rs.getString("lastname"));
                rentalView.setCarId(rs.getInt("carId"));
                rentalView.setBrand(rs.getString("brand"));
                rentalView.setModel(rs.getString("model"));
                rentalView.setStartDate(rs.getString("start"));
                rentalView.setEndDate(rs.getString("end"));
                
                list.add(rentalView);
            }
           
        }
        catch(Exception ex) {
            Logger.getLogger(CarRental.class.getName()).log(Level.SEVERE, "Error occured while reading from database", ex);
        }
        
        return list;
    }
    
    
}
