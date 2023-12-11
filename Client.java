package org.carbase;

public class Client {
    private String surname;
    private String name;
    private String patronymic;
    private String age;
    private String gender;
    private String car;

    public Client(String Surname, String Name, String Patronymic, String Age, String Gender, String Car) {
        surname = Surname;
        name = Name;
        patronymic = Patronymic;
        age = Age;
        gender = Gender;
        car = Car;
    }
    public String getsurname () {return surname;}
    public void setsurname(String Surname) {surname = Surname;}

    public String getname () {return name;}
    public void setname(String Name) {name = Name;}

    public String getpatronymic () {return patronymic;}
    public void setpatronymic(String Patronymic) {patronymic = Patronymic;}

    public String getage () {return age;}
    public void setage(String Age) {age = Age;}

    public String getgender () {return gender;}
    public void setgender(String Gender ) {gender = Gender;}

    public String getcar () {return car;}
    public void setcar(String Car) {car = Car;}

    public String toString() {
        return getClass().getSimpleName() + "{surname:" + surname + " name:" + name +
                " patronymic:" + patronymic + " age:" + age + " gender:" + gender +
                " car:" + car + "}";
    }
}
