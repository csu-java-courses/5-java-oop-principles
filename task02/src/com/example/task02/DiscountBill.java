package com.example.task02;

public class DiscountBill extends Bill{
    private double discount;
    public DiscountBill(int discount){
        super();
        this.discount = discount/100.0;
    }
    @Override
    public long getPrice(){
        long price = super.getPrice();
        return (long)(price-price*discount);
    }

    public int getDiscount(){
        return (int)(discount*100);
    }

    public long diff(){
        return super.getPrice() - this.getPrice();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nСкидка: "+getDiscount()+"%");
        return sb.toString();
    }
}
