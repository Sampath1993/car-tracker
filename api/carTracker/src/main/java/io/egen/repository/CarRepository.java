package io.egen.repository;

import io.egen.entity.Car;

import java.util.List;

public interface CarRepository {

    List<Car> findAll();

    Car findOne(String id);

    Car create(Car car);

    Car update(Car car);

    void delete(Car car);
}
