package com.unw.ms.base.control;

import com.unw.ms.base.model.Audit;
import com.unw.ms.base.model.Auditable;
import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListener {

  @PrePersist
  public void setCreatedOn(Auditable auditable) {
    Audit audit = auditable.getAudit();

    if (audit == null) {
      audit = new Audit();
      auditable.setAudit(audit);
    }

    audit.setCreatedAt(LocalDateTime.now());
    // we will need a serve oder util class to get the current user
//        audit.setCreatedBy(...);
  }

  @PreUpdate
  public void setUpdatedOn(Auditable auditable) {
    Audit audit = auditable.getAudit();
    audit.setUpdatedAt(LocalDateTime.now());
    // we will need a serve oder util class to get the current user
//        audit.setUpdatedBy(...);
  }
}
