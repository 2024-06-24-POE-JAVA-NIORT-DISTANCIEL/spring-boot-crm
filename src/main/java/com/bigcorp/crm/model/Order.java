package com.bigcorp.crm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDER_TABLE")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String serviceType;
    private Integer tva;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    private Integer nbDays;
    private Integer totalExcludeTax;

    @Enumerated(EnumType.STRING)
    private OrderState state;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getTva() {
        return tva;
    }

    public void setTva(Integer tva) {
        this.tva = tva;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Integer getTotalExcludeTax() {
        return totalExcludeTax;
    }

    public void setTotalExcludeTax(Integer totalExcludeTax) {
        this.totalExcludeTax = totalExcludeTax;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

