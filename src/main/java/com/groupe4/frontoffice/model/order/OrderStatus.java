package com.groupe4.frontoffice.model.order;


public enum OrderStatus {
    DELIVERED("delivered"),
    DELIVERY_IN_PROGRESS("delivery in progress"),
    CANCEL("cancel"),
    VALIDATED("validated"),
    RECEIVED("received");

    public final String label;
    private OrderStatus(String label) {
        this.label = label;
    }

    public static OrderStatus getFromLabel(String text) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.label.equalsIgnoreCase(text)) {
                return orderStatus;
            }
        }
        return null;
    }


}
