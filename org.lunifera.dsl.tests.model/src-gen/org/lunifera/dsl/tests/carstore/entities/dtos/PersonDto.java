package org.lunifera.dsl.tests.carstore.entities.dtos;

import java.io.Serializable;
import org.lunifera.dsl.tests.carstore.entities.dtos.BaseDto;

@SuppressWarnings("all")
public class PersonDto extends BaseDto implements Serializable {
  private Object firstname;
  
  private Object lastname;
}
