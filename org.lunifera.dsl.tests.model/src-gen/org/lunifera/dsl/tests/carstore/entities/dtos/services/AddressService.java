package org.lunifera.dsl.tests.carstore.entities.dtos.services;

import javax.persistence.EntityManagerFactory;

@SuppressWarnings("all")
public class AddressService {
  private EntityManagerFactory emf;
  
  /**
   * Binds the service {@link javax.persistence.EntityManagerFactory} to this component. 
   * <br>The cardinality is ONE_TO_ONE
   * 
   * @param emf the service
   */
  protected void bindEmf(final EntityManagerFactory emf) {
    this.emf = emf;
  }
  
  /**
   * Unbinds the service from this component. 
   * <br>The cardinality is ONE_TO_ONE
   * 
   * @param emf the service
   */
  protected void unbindEmf(final EntityManagerFactory emf) {
    this.emf = null;
  }
}
