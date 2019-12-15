package com.example.axondemo.entity;

import lombok.Builder;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Javad Alimohammadi<bs.alimohammadi@gmail.com>
 */

@Builder
@Table(name = "ORDER_QUERY_ENTITY")
@Entity
public class OrderQueryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;

    @Column(name = "OMS_ID", nullable = false)
    private String omsId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "ORDER_STATUS", nullable = false)
    private String orderStatus;

    @Column(name = "CREATED_TIMESTAMP", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimeStamp;


}
