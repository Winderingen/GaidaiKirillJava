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

        switch (Operation) {
            case 1:
                AddCar addCar = new AddCar();
                addCar.CarCreate();
                break;
            case 2:
                AddClient addClient = new AddClient();
                addClient.ClientCreate();
                break;
            case 3:
                SelectCar selectCar = new SelectCar();
                selectCar.ViewCar();
                break;
            case 4:
                SelectClient selectClient = new SelectClient();
                selectClient.ViewClient();
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
}