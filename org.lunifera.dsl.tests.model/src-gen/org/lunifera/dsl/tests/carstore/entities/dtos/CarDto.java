package org.lunifera.dsl.tests.carstore.entities.dtos;

import java.io.Serializable;
import org.lunifera.dsl.tests.carstore.entities.dtos.BaseDto;

@SuppressWarnings("all")
public class CarDto extends BaseDto implements Serializable {
  private Object number;
  
  private Object finishingDate;
}
