package com.unw.ms.base.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * super class for all parent entities - extend all business and parent entities
 * from this class with additional information createdBy, created ...
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public class BusinessEntity extends AbstractEntity implements Auditable {

  @Embedded
  private Audit audit;

  @Version
  @Column(name = "version")
  private Long version;

 

}
