package com.example.oopsproject;

public class Information {
    private String orderId, rid, address;

    public Information(String orderId, String rid, String address) {
        this.orderId = orderId;
        this.rid = rid;
        this.address = address;
    }

    public Information() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
