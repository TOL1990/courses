import Core.Car;
import Dao.DAOUtils;
import Dao.DBProcessor;

import java.sql.*;

/**
 * Created by Leonid on 30.03.2016.
 */
public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jh23q.9";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) throws SQLException {

/*
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        }
        catch (SQLException e) {
            System.out.println("Произшла ошибка при решистрации драйвера");
            return;
        }
//Поиск. обратиться к базе, слепит все в лист и в листе искать

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()){
//           statement.execute("insert into carmarketschema.owners (firstname, lastname, mobilenumber) VALUES (\"Leonardo\",\"Di Caprio\",\"777-55-12-11\")");
//            statement.executeUpdate("UPDATE carmarketschema.owners SET firstname = \"Geldrih\" WHERE owner_id = 5");

//            statement.addBatch("insert into carmarketschema.owners (firstname, lastname, mobilenumber) VALUES (\"Jorik\",\"Vartanov\",\"7654-45-11\")");
//            statement.addBatch("insert into carmarketschema.owners (firstname, lastname, mobilenumber) VALUES (\"Taisia\",\"Povali\",\"122-55-12-11\")");
//            statement.addBatch("insert into carmarketschema.owners (firstname, lastname, mobilenumber) VALUES (\"Rick\",\"Grimez\",\"700-55-30-11\")");
//           statement.executeBatch();
//            statement.clearBatch();

            ResultSet resultSet = statement.executeQuery("");
            System.out.println("code.....");
        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("Не удалось создать соединение!");
        }
*/
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        String query = "SELECT * from carmarketschema.cars";
        Statement statement = conn.createStatement();
        ResultSet resSet = statement.executeQuery(query);

        while (resSet.next())
        {
            int car_id = resSet.getInt("car_id");
            String developer = resSet.getString("developer");
            String model = resSet.getString("model");
            String vin = resSet.getString("vin");
            String describe = resSet.getString("describe");
            java.sql.Date created = resSet.getDate("created");
            int price = resSet.getInt("price");
            int owner_id = resSet.getInt("owner_id");

//            Car car = new Car(car_id,developer, model, vin, describe, created,car_id,owner_id);
//            System.out.println(car);
        }

        DAOUtils.close(conn,statement,resSet);
    }

}
