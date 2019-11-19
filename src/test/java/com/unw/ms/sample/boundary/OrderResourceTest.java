/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unw.ms.sample.boundary;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.unw.ms.ArquillianTestBase;
import com.unw.ms.sample.model.SalesOrder;

/**
 *
 * @author UNGERW
 */
public class OrderResourceTest extends ArquillianTestBase {

  @Inject
  private OrderResource orderBF;

  private static final String ORDER_NO_1 = "order1";
  private static final String ORDER_NO_1B = "order1b";


  @Test
  public void testCreate() {
    Assert.assertNotNull(orderBF);
    SalesOrder so = orderBF.createSalesOrder();
    Assert.assertNotNull(so);
  }
  /**
   * simple test without existing testdata - testing all crud methods
   */
  @Test
  public void testSalesOrderCrud() {
    Assert.assertNotNull(orderBF);

    List<SalesOrder> salesOrders = orderBF.getAllSalesOrders();
    // must be 0
    Assert.assertEquals(0, salesOrders.size());

    SalesOrder so = orderBF.createSalesOrder();
    Assert.assertNotNull(so);
    so.setOrderNumber(ORDER_NO_1);
    Assert.assertNotNull(so);
    //update/persist
    orderBF.persistSalesOrder(null, so);
    
    //find
    SalesOrder persSO = orderBF.findSalesOrder(ORDER_NO_1);
    Assert.assertNotNull(persSO);
    BigInteger id = persSO.getId();
    System.out.println(id);
    persSO = orderBF.findSalesOrder(id);
    Assert.assertNotNull(persSO);
    //update/merge
    persSO.setOrderNumber(ORDER_NO_1B);
    SalesOrder persSO1b = orderBF.mergeSalesOrder(null, persSO);
    Assert.assertNotNull(persSO1b);
    Assert.assertEquals(ORDER_NO_1B, persSO1b.getOrderNumber());

    //cleanup
    persSO1b = orderBF.findSalesOrder(ORDER_NO_1B);
    Assert.assertNotNull(persSO1b);
    orderBF.deleteSalesOrder(persSO1b.getId());
    persSO1b = orderBF.findSalesOrder(ORDER_NO_1B);
    Assert.assertNull(persSO1b);
  }
  
  

}
