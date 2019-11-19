package com.unw.ms.sample.boundary;


import com.unw.ms.sample.control.SalesOrderDetailService;
import com.unw.ms.sample.control.SalesOrderService;
import com.unw.ms.sample.model.SalesOrder;
import com.unw.ms.sample.model.SalesOrderDetail;
import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

/**
 * Business Facade & REST example - Boundary this BF contains methods for sales
 * orders and sales order details <br>
 *
 */
@Path("/sample")
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class OrderResource {

  // sales order is more complex - needs a service class
  @Inject
  private SalesOrderService orderService;

  // details are simple - use data service directly - no service class required
  @Inject
  private SalesOrderDetailService orderDetailService;

  ///////////////// template BF methods //////////////
  //CRUD for Order entity ////////
  // C Create
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/initSalesOrder/")
  @Operation(description = "create sales order")
  @APIResponses({
    @APIResponse(responseCode = "201", description = "Successful, returning the value")
  })
  public SalesOrder createSalesOrder() {
    return orderService.create();
  }

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(description = "find sales order by id")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successful, returning the value")
  })
  public SalesOrder findSalesOrder(@PathParam("id") BigInteger id) {
    return orderService.find(id);
  }

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/salesOrderByOrderNumber/{orderNumber}")
  @Operation(description = "find sales order by number")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successful, returning the value")
  })
  public SalesOrder findSalesOrder(@PathParam("orderNumber") String orderNumber) {
    return orderService.findBySalesOrderByNumber(orderNumber);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/salesOrders")
  @Operation(description = "get all sales orders")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successful, returning the value")
  })
  public List<SalesOrder> getAllSalesOrders() {
    return orderService.getAllSalesOrders();
  }

  // U Update
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(description = "update sales")
  @APIResponses({
    @APIResponse(responseCode = "202", description = "Successful, returning the value")
  })
  @Path("/salesOrders/")
  public SalesOrder persistSalesOrder(@Context SecurityContext sc, SalesOrder order) {
    order = orderService.merge(order);
    return order;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(description = "update sales order ")
  @APIResponses({
    @APIResponse(responseCode = "202", description = "Successful, returning the value")
  })
  @Path("/salesOrders/")
  public SalesOrder mergeSalesOrder(@Context SecurityContext sc, SalesOrder order) {
    return orderService.merge(order);
  }

  @DELETE
  @Path("/salesOrders/{id}")
  @Operation(description = "delete sales order")
  @APIResponses({
    @APIResponse(responseCode = "204", description = "Successful, returning the value")
  })
  public void deleteSalesOrder(@PathParam("id") BigInteger id) {
    orderService.delete(id);
  }

  //CRUD for Order Detail entity - use dataService directly ////////
  // R Read one orderDetail by ID
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/salesOrderDetails/{id}")
  @Operation(description = "find sales order detail by id")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successful, returning the value")
  })
  public SalesOrderDetail findSalesOrderDetail(@PathParam("id") BigInteger id) {
    return orderDetailService.find(id);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/salesOrderDetails")
  @Operation(description = "get all sales order details")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successful, returning the value")
  })
  public List<SalesOrderDetail> getAllSalesOrderDetails() {
    return orderDetailService.getAllSalesOrderDetails();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(description = "find sales order detail by order")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successful, returning the value")
  })
  @Path("/salesOrderDetailsByOrder/{orderId}")
  public List<SalesOrderDetail> getSalesOrderDetailsByOrder(@PathParam("orderId") BigInteger orderId) {
    return orderDetailService.findSalesOrderDetailsByOrder(orderId);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(description = "find sales order detail by id")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successful, returning the value")
  })
  @Path("/salesOrderDetails/{id}")
  public SalesOrderDetail getSalesOrderDetail(@PathParam("id") BigInteger id) {
    return orderDetailService.find(id);
  }
  
  // test method to check version was build and commited to openshift
  @GET
  @Path("/checkversion/")
  public Response test() {
      return Response.status(200).entity("Rest Enpoint , Date 16.10.2019 V1").build();
  }
}
