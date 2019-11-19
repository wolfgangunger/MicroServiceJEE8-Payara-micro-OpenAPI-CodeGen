package com.unw.ms.base.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * super class for all entities with ID - extend all simple child entities from
 * this class
 *
 */
@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {

  private static final long serialVersionUID = 1868447758611081029L;

  @Id
  @GeneratedValue
  @Column(name = "id")
  private BigInteger id;

}
