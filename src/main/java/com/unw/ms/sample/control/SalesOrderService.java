package com.unw.ms.sample.control;


import com.unw.ms.base.control.AbstractService;
import com.unw.ms.sample.model.SalesOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class SalesOrderService extends AbstractService<SalesOrder> {

  @PersistenceContext()
  private EntityManager em;

  @Override
  protected Class<SalesOrder> getEntityClass() {
    return SalesOrder.class;
  }

  @Override
  protected EntityManager getEnityManager() {
    return em;
  }

  @Override
  public SalesOrder create() {
    SalesOrder order = new SalesOrder();
    // do initialization
    order.setOrderNumber("0001"); // e.g. Nummerkreis
    return order;
  }

  public List<SalesOrder> getAllSalesOrders() {
    TypedQuery<SalesOrder> query = em.createNamedQuery(SalesOrder.FIND_ALL, SalesOrder.class);
    return query.getResultList();
  }

  public SalesOrder findBySalesOrderByNumber(String orderNumber) {
    Query query = em.createNamedQuery(SalesOrder.FIND_BY_ORDER_NUMBBER, SalesOrder.class);
    query.setParameter("orderNumber", orderNumber);
    if (!query.getResultList().isEmpty()) {
      return (SalesOrder) query.getResultList().get(0);
    } else {
      return null;
    }
  }

}
