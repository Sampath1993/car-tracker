package io.egen.service;

import io.egen.entity.Car;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository repository;

    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Car findOne(String id) {
        Car existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Car with id " + id + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Car create(Car emp) {
        Car existing = repository.findOne(emp.getId());
        if (existing != null) {
            throw new BadRequestException("Car with id " + emp.getId() + " already exists.");
        }
        return repository.create(emp);
    }

    @Transactional
    public Car update(String id, Car emp) {
        Car existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Car with id " + id + " doesn't exist.");
        }
        return repository.update(emp);
    }

    @Transactional
    public void delete(String id) {
        Car existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Car with id " + id + " doesn't exist.");
        }
        repository.delete(existing);
    }
}