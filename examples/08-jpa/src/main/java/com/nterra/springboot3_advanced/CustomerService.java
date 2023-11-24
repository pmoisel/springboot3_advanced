package com.nterra.springboot3_advanced;

import com.nterra.springboot3_advanced.entity.Customer;
import com.nterra.springboot3_advanced.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;

  public List<Customer> sucheKunden(String name, String foo) {
    if (name != null) {
      Customer c = new Customer();
      c.setName(name);
      Example<Customer> example = Example.of(c);
      return customerRepository.findAll(example);
    }

    return customerRepository.findByFoo(foo);
  }

  @Transactional
  public void update(Customer customer) {
    Optional<Customer> byId = customerRepository.findById(customer.getId());
    byId.ifPresent(customer1 -> customer1.setSettings(customer.getSettings()));
  }
}
