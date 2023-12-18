package com.csse.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase_order_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_order_id")
    private long purchaseOrderId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "qty")
    private String totalQty;

    @Column(name = "price")
    private float price;

    @Column(name = "status")
    private String status;

    public PurchaseOrder(String supplierName, String companyName, String contactNo, String totalQty, float price, String status) {
        this.supplierName = supplierName;
        this.companyName = companyName;
        this.contactNo = contactNo;
        this.totalQty = totalQty;
        this.price = price;
        this.status = status;
    }
}
