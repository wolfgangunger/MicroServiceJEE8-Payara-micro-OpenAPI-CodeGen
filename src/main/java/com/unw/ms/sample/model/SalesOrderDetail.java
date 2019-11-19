package com.unw.ms.sample.model;

import com.unw.ms.base.control.AuditListener;
import com.unw.ms.base.model.BusinessEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "SalesOrderDetail", description = "Sales Order Detail Sample Entity")
@Data
@NoArgsConstructor
@EntityListeners(AuditListener.class)
@Entity
@Table(name = "sales_order_detail")
@NamedQueries({
  @NamedQuery(name = SalesOrderDetail.FIND_ALL, query = "SELECT od FROM  SalesOrderDetail od"),
  @NamedQuery(name = SalesOrderDetail.FIND_BY_ORDER, query = "SELECT od FROM SalesOrderDetail od WHERE od.order.id  = :orderId")})
public class SalesOrderDetail extends BusinessEntity {

  public static final String FIND_ALL = "SalesOrderDetail.findAll";
  public static final String FIND_BY_ORDER = "SalesOrderDetail.findByOrder";

  @Schema(required = true)
  @Column(name = "detail_number")
  private int detailNumber;

  @Schema(required = true)
  @Column(name = "item")
  private String item;

  @Schema
  @Column(name = "description")
  private String description;

  @Schema(required = true)
  //@JsonIgnore
  @ManyToOne
  @JoinColumn(name = "ORDER_ID")
  private SalesOrder order;

}
