package com.mlodovico.course.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    DELIVERED(3),
    CANCELED(4);

    private int codeOrderStatus;

    OrderStatus(int codeOrderStatus){
        this.codeOrderStatus = codeOrderStatus;
    }

    public int getCodeOrderStatus(){
        return codeOrderStatus;
    }

    public static OrderStatus valueOf(int codeOrderStatus){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCodeOrderStatus() == codeOrderStatus){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
