package com.unw.ms.base.control;

import com.unw.ms.base.model.AbstractEntity;
import java.math.BigInteger;

import javax.persistence.EntityManager;


/**
 * superclass for all  services each parent entity object will have its own
 * service for CRUD and more . implement a EntityNameDataService and extend
 * this class. thus
 * you will get CRUD functionality for free. further methods (find ...) must be
 * implemented
 *
 * @param <T> entity class
 */
public abstract class AbstractService<T extends AbstractEntity> {

  protected abstract Class<T> getEntityClass();

  protected abstract EntityManager getEnityManager();


  public T find(BigInteger id) {
    return getEnityManager().find(this.getEntityClass(), id);
  }


  public void delete(T entity) {
    T pers = find(entity.getId());
    getEnityManager().remove(pers);
  }


  public void delete(BigInteger id) {
    T pers = find(id);
    getEnityManager().remove(pers);
  }


  public T merge(T entity) {
    return getEnityManager().merge(entity);
  }


  public abstract T create();

}
