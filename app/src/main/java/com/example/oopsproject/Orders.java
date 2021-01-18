package com.example.oopsproject;

class Orders {
    private String orderId;
    private String restaurantId;
    private String address;
    private String emailId;
    private String amount;

    public Orders(String orderId, String restaurantId, String address, String emailId, String amount) {
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.address = address;
        this.emailId = emailId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getAmount() {
        return amount;
    }
}
