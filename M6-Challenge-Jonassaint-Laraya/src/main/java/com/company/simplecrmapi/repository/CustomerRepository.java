package com.company.simplecrmapi.repository;

import com.company.simplecrmapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    Optional<Customer> findById(Integer id);

    List<Customer> findByState(String state);





}
