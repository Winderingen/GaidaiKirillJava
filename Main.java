package org.carbase;

import com.sun.jdi.CharType;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Scanner start = new Scanner(System.in);

        System.out.println("Выберите операцию: " + "\n" + "1: Добавить авто" +
                "\n" + "2: Продать авто" + "\n" + "3: Просмотр базы авто" + "\n" + "4: Просмотр базы клиентов");
        int Operation = start.nextInt();
        start.nextLine();
        if (Operation == 1) {
            AddCar addCar = new AddCar();
            addCar.CarCreate();
        } else if (Operation == 2) {
            AddClient addClient = new AddClient();
            addClient.ClientCreate();
        } else if (Operation == 3) {
            String query = "select * from cars";
            try {
                Statement statement = dbHandler.getDbConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Cars car = new Cars(query,query,query);
                    car.setCarType(resultSet.getString(2));
                    car.setCarFirm(resultSet.getString(3));
                    car.setCarModel(resultSet.getString(4));
                    System.out.println(car);
                }
            } finally {

            }
        } else if (Operation == 4) {
            String query = "select * from clients";
            try {
                Statement statement = dbHandler.getDbConnection().createStatement();
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
            } finally {

            }
        }else {
            System.out.println("ERROR");
        }

    }
}