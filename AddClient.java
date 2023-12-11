package org.carbase;

import java.sql.*;
import java.util.Scanner;

public class AddClient {
    public void ClientCreate() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите фамилию клиента: ");
        String surname = scanner.nextLine();
        System.out.println("Введите имя клиента: ");
        String name = scanner.nextLine();
        System.out.println("Введите отчество клиента: ");
        String patronymic = scanner.nextLine();
        System.out.println("Введите возраст клиента: ");
        String age = scanner.nextLine();
        System.out.println("Выберите пол клиента: муж/жен ");
        String gender = scanner.nextLine();
        System.out.println("Введите номер приобретаемого авто: ");
        String car = null;
        int idCars = scanner.nextInt();// заданный id
        try {
            String query = "SELECT * FROM cars WHERE idCars = ?";
            Connection conn = dbHandler.getDbConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idCars);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firmValue = resultSet.getString(3); // Получаем значение столбца id из результата
                String modelValue = resultSet.getString(4); // Получаем значение столбца name из результата

                // Добавьте здесь свой код для обработки значений, например, сохранения их в переменные
                car = firmValue + " " + modelValue;
            } else {
                System.out.println("Строка не найдена");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String deleteQuery = "DELETE FROM cars WHERE idCars = " + idCars + "";
            Statement statement = dbHandler.dbConnection.createStatement();
            int rowsAffected = statement.executeUpdate(deleteQuery);

            System.out.println("Строка с авто успешно удалена. Марка и модель занесены в таблицу.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Client clients = new Client(surname, name, patronymic, age, gender, car);

        dbHandler.AddClientForDb(clients);

    }

}
