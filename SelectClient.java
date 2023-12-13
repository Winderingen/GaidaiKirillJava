package org.carbase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectClient {
    public void ViewClient() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            Statement statement = databaseHandler.getDbConnection().createStatement();
            String query = "SELECT * FROM clients";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Client client = new Client(query,query,query,query,query,query);
                client.setsurname(resultSet.getString(2));
                client.setname(resultSet.getString(3));
                client.setpatronymic(resultSet.getString(4));
                client.setage(resultSet.getString(5));
                client.setgender(resultSet.getString(6));
                client.setcar(resultSet.getString(7));
                System.out.println(client);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
