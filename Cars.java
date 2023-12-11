package org.carbase;

public class Cars {
    private String CarType;
    private String CarFirm;
    private String CarModel;
    public Cars(String carType, String carFirm, String carModel) {
        CarType = carType;
        CarFirm = carFirm;
        CarModel = carModel;

    }

    public String getCarType() {
        return CarType;
    }
    public void setCarType(String carType) {
        CarType = carType;
    }
    public String getCarFirm() {
        return CarFirm;
    }
    public void setCarFirm(String carFirm) {
        CarFirm = carFirm;
    }
    public String getCarModel() {
        return CarModel;
    }
    public void setCarModel(String carModel) {
        CarModel = carModel;
    }

    public String toString() {
        return getClass().getSimpleName() + "{type:" + CarType + " firm:" + CarFirm +
                " model:" + CarModel + "}";
    }
}
