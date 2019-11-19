package com.unw.ms.sample.control;


import com.unw.ms.base.control.AbstractService;
import com.unw.ms.sample.model.SalesOrderDetail;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class SalesOrderDetailService extends AbstractService<SalesOrderDetail> {

  @PersistenceContext()
  private EntityManager em;

  @Override
  protected Class<SalesOrderDetail> getEntityClass() {
    return SalesOrderDetail.class;
  }

  @Override
  protected EntityManager getEnityManager() {
    return em;
  }

  @Override
  public SalesOrderDetail create() {
    return new SalesOrderDetail();
  }

  public List<SalesOrderDetail> getAllSalesOrderDetails() {
    TypedQuery<SalesOrderDetail> query = em.createNamedQuery(SalesOrderDetail.FIND_ALL, SalesOrderDetail.class);
    return query.getResultList();
  }

  public List<SalesOrderDetail> findSalesOrderDetailsByOrder(BigInteger orderId) {
    Query query = em.createNamedQuery(SalesOrderDetail.FIND_BY_ORDER, SalesOrderDetail.class);
    query.setParameter("orderId", orderId);
    return query.getResultList();
  }

}
