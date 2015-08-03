package org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.services;

import org.lunifera.dsl.dto.lib.services.impl.AbstractDTOServiceWithMutablePersistence;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.Person;
import org.lunifera.dsl.entity.xtext.tests.model.testcarstore2.dtos.PersonDto;

@SuppressWarnings("all")
public class PersonService extends AbstractDTOServiceWithMutablePersistence<PersonDto, Person> {
  public PersonService() {
    // set the default persistence ID
    setPersistenceId("TBD");
  }
  
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
    return dto.getId();
  }
}
