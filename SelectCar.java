package org.carbase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectCar {
    public void ViewCar() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            Statement statement = databaseHandler.getDbConnection().createStatement();
            String query = "SELECT * FROM cars";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Cars car = new Cars(query,query,query);
                car.setCarType(resultSet.getString(2));
                car.setCarFirm(resultSet.getString(3));
                car.setCarModel(resultSet.getString(4));
                System.out.println(car);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
