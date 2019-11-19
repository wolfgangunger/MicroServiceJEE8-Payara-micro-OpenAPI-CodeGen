package com.unw.ms.base.model;

/**
 * use this interface for business entities which should be audited
 */
public interface Auditable {
 
    Audit getAudit();
 
    void setAudit(Audit audit);
}
