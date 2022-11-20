package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class CarDaoImp {
    List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", "5-series", 2019));
        cars.add(new Car("Lexus", "LS200", 2012));
        cars.add(new Car("Mercedes-Benz", "S200", 2022));
        cars.add(new Car("Toyota", "Camry", 2022));
        cars.add(new Car("Volkswagen", "Passat", 2020));
    }

    public List<Car> index() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getSomeCars(int count) {

        return cars.stream().limit(count).toList();
    }

}
