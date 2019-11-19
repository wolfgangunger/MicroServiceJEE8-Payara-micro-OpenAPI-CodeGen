package com.unw.ms.base.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Embeddable
public class Audit {

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "updated_by")
  private String updatedBy;



}
