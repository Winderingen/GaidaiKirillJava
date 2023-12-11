package org.carbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Config{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://"+ dbaseHost + ":"
                + dbasePort + "/" + dbaseName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbaseUser, dbasePass);

        return dbConnection;

    }
    public void AddCarForDb(Cars cars) {
        String insert = "INSERT INTO "+ Constant.CAR_TABLE + "(" + Constant.CAR_TYPE + "," + Constant.CAR_FIRM + ","
                + Constant.CAR_MODEL + ")" + "VALUES (?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, cars.getCarType());
            prSt.setString(2, cars.getCarFirm());
            prSt.setString(3, cars.getCarModel());

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddClientForDb(Client client) {
        String insert = "INSERT INTO "+ Constant.CLIENT_TABLE + "(" + Constant.CLIENT_SURNAME + "," + Constant.CLIENT_NAME + ","
                + Constant.CLIENT_PATRONYMIC + "," + Constant.CLIENT_AGE + "," + Constant.CLIENT_GENDER + ","
                + Constant.CLIENT_CAR + ")" + "VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, client.getsurname());
            prSt.setString(2, client.getname());
            prSt.setString(3, client.getpatronymic());
            prSt.setString(4, client.getage());
            prSt.setString(5, client.getgender());
            prSt.setString(6, client.getcar());

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
