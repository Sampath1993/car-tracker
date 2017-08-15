package io.egen.repository;

import io.egen.entity.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Car> findAll() {
        TypedQuery<Car> query = entityManager.createNamedQuery("Car.findAll", Car.class);
        return query.getResultList();
    }

    public Car findOne(String vin) {
        return entityManager.find(Car.class, vin);
    }

    public Car create(Car car) {
        entityManager.persist(car);
        return car;
    }

    public Car update(Car car) {
        return entityManager.merge(car);
    }

    public void delete(Car car) {
        entityManager.remove(car);
    }
}
