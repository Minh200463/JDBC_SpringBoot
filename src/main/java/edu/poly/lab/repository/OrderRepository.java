package edu.poly.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.lab.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
