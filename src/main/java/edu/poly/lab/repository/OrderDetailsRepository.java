package edu.poly.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.lab.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

}
