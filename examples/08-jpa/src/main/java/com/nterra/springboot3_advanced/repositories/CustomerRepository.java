package com.nterra.springboot3_advanced.repositories;

import com.nterra.springboot3_advanced.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  List<Customer> findCustomerByNameOrderByIdDesc(String name);

  @Query(nativeQuery = true,
  value = "select * from customer where settings -> 'foo' = :foo")
  List<Customer> findByFoo(String foo);
}
