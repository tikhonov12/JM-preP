package web.Model;

public class Car {
    private String carModel;
    private String color;
    private String series;

    public Car(String carModel, String color, String series) {
        this.carModel = carModel;
        this.color = color;
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", color='" + color + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}
