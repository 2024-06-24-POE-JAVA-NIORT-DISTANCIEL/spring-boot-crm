package com.bigcorp.crm.controller.dto;

import com.bigcorp.crm.model.OrderState;

public class OrderDto {

    private Long id;

    private String serviceType;
    private Integer tva;

    private Long clientId;
    private String companyName;

    private Integer nbDays;
    private Integer totalExcludeTax;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", serviceType='" + serviceType + '\'' +
                ", tva=" + tva +
                ", clientId=" + clientId +
                ", companyName='" + companyName + '\'' +
                ", nbDays=" + nbDays +
                ", totalExcludeTax=" + totalExcludeTax +
                ", state=" + state +
                ", comment='" + comment + '\'' +
                '}';
    }
}
