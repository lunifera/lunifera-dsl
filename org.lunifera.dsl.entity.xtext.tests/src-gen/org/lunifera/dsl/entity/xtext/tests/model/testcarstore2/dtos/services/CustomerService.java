package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Customer;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.CustomerDto;

@SuppressWarnings("all")
public class CustomerService extends AbstractDTOServiceWithMutablePersistence<CustomerDto, Customer> {
  public CustomerService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
  public Class<CustomerDto> getDtoClass() {
    return CustomerDto.class;
  }
  
  public CustomerDto createDto() {
    return new CustomerDto();
  }
  
  public Customer createEntity() {
    return new Customer();
  }
  
  public Class<Customer> getEntityClass() {
    return Customer.class;
  }
  
  public Object getId(final CustomerDto dto) {
    return dto.getId();
  }
}
