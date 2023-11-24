package com.nterra.springboot3_advanced;

import com.nterra.springboot3_advanced.entity.Customer;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService service;

  @GetMapping(value = "/customer")
  public ResponseEntity<List<Customer>> getByName(
      @RequestParam(name = "name", required = false) String name, @RequestParam(name = "foo", required = false) String foo) {
    return ResponseEntity.ok(service.sucheKunden(name, foo));
  }

  @PutMapping(value = "/customer")
  public void update(@RequestBody Customer customer) {
    service.update(customer);
  }
}
