package org.carbase;

import java.util.Scanner;

public class AddCar{
    public void CarCreate() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип авто: легковой/грузовой");
        String CarType = scanner.nextLine();
        System.out.println("Введите марку авто: ");
        String CarFirm = scanner.nextLine();
        System.out.println("Введите модель авто: ");
        String CarModel = scanner.nextLine();

        Cars cars = new Cars(CarType,CarFirm,CarModel);



        dbHandler.AddCarForDb(cars);

    }

}
