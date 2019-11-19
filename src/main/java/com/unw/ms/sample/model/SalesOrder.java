package com.unw.ms.sample.model;

import com.unw.ms.base.control.AuditListener;
import com.unw.ms.base.model.BusinessEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "SalesOrder", description = "Sales Order Sample Entity")
@Data
@NoArgsConstructor
@EntityListeners(AuditListener.class)
@Entity
@Table(name = "sales_order")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
  @NamedQuery(name = SalesOrder.FIND_ALL, query = "SELECT o FROM  SalesOrder o"),
  @NamedQuery(name = SalesOrder.FIND_BY_ORDER_NUMBBER, query = "SELECT o FROM SalesOrder o WHERE o.orderNumber  = :orderNumber")})
public class SalesOrder extends BusinessEntity {

  public static final String FIND_ALL = "SalesOrder.findAll";
  public static final String FIND_BY_ORDER_NUMBBER = "SalesOrder.findOrderNumber";

  @Schema(required = true)
  @Column(name = "order_number")
  private String orderNumber;

  @Schema
  @Column(name = "description")
  private String description;

  @Schema
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id")
  private List<SalesOrderDetail> details = new ArrayList<>();

}
