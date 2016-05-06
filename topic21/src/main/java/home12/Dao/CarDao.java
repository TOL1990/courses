package home12.Dao;

import home12.Core.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid on 27.03.2016.
 */
public class CarDao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jh23q.9";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    // Сотворить конекшн

    public void addCar(String developer, String model, String vin, int created, String describe_more, int owner_id) {
        String addCarqQuery = "INSERT INTO carmarketschema.cars (developer, model, vin," +
                " created, describe_more,owner_id ) VALUES (?,?,?,?,?,?)";
        home12.Dao.DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(addCarqQuery);
            statement.setString(1, developer);
            statement.setString(2, model);
            statement.setString(3, vin);
            statement.setInt(4, created);
            statement.setString(5, describe_more);
            statement.setInt(6, owner_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DAOUtils.close(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Car getCarById(int id) throws SQLException {
        Car car = new Car();
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        String query = "SELECT car_id, developer, model, vin, created, describe_more, owner_id FROM carmarketschema.cars WHERE car_id = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resSet = statement.executeQuery(query);

        while (resSet.next()) {
            int car_id = resSet.getInt("car_id");
            String developer = resSet.getString("developer");
            String model = resSet.getString("model");
            String vin = resSet.getString("vin");
            String describe = resSet.getString("describe");
            Date created = resSet.getDate("created");
            int owner_id = resSet.getInt("owner_id");

//            Car car = new Car(car_id,developer, model, vin, describe, created,car_id,owner_id);
//            System.out.println(car);
        }

        DAOUtils.close(conn, statement, resSet);

        return car;
    }

    public List<Car> getAllCar() throws SQLException {
        Car car = new Car();
        List cars = new ArrayList();
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        String query = "SELECT car_id, developer, model, vin, created, describe_more, owner_id FROM carmarketschema.cars";
        Statement statement = conn.createStatement();
        ResultSet resSet = statement.executeQuery(query);
        while (resSet.next()) {
            int car_id = resSet.getInt("car_id");
            String developer = resSet.getString("developer");
            String model = resSet.getString("model");
            String vin = resSet.getString("vin");
            String describe_more = resSet.getString("describe_more");
            int created = resSet.getInt("created");
            int owner_id = resSet.getInt("owner_id");
            cars.add(new Car(car_id, developer, model, vin, describe_more, created, owner_id));
        }

        return cars;
    }



/* Инфа из видеоурока той самки
    private Connection myCon;

    public CarDao() throws Exception{
        Properties prop = new Properties();

        prop.load(new FileInputStream("info.properties"));

        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String dburl = prop.getProperty("dburl");

        //// Connection to db

        myCon = DriverManager.getConnection(dburl, user,password);
        System.out.println("DB connection is succesful to: " + dburl);


    }
    public void updateEmployee (Employee theEmployee) throws SQLException
    {
        PreparedStatement myStmt = null;
        try
        {
            myStmt = myCon.prepareStatement("update employee set first_name=?, last_name=?, email=?, salary=? where id=?");
            myStmt.setString(1, theEmployee.getFirstName());
            myStmt.setString(2, theEmployee.getLastName());
            myStmt.setString(3, theEmployee.getEmail());
            myStmt.setBigDecimal(4, theEmployee.getSalary());
            myStmt.executeUpdate();

        }finally {
            DAOUtils.close(myStmt);
        }
    }
    */

}

