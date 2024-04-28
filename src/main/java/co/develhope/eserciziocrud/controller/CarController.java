package co.develhope.eserciziocrud.controller;

import co.develhope.eserciziocrud.entities.Car;
import co.develhope.eserciziocrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carRepository.findById(id)
                .orElse(new Car());
    }

    @PutMapping("/{id}")
    public Car updateCarType(@PathVariable Long id, @RequestParam String type) {
        Car car = carRepository.findById(id).orElse(null);
        if (car == null) {
            return null;
        }
        car.setType(type);
        return carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id) {
        carRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
