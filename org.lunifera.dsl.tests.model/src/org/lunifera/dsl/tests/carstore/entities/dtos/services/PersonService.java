package org.lunifera.dsl.tests.carstore.entities.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOService;
import org.lunifera.dsl.tests.carstore.entities.Person;
import org.lunifera.dsl.tests.carstore.entities.dtos.PersonDto;

@SuppressWarnings("all")
public class PersonService extends AbstractDTOService<PersonDto, Person> {
  public Class<PersonDto> getDtoClass() {
    return PersonDto.class;
  }
  
  public PersonDto createDto() {
    return new PersonDto();
  }
  
  public Person createEntity() {
    return new Person();
  }
  
  public Class<Person> getEntityClass() {
    return Person.class;
  }
  
  public Object getId(final PersonDto dto) {
    return dto.getUuid();
  }
}
