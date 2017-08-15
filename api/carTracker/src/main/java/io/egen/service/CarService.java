package io.egen.service;

import io.egen.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car findOne(String id);

    Car create(Car emp);

    Car update(String id, Car emp);

    void delete(String id);
}