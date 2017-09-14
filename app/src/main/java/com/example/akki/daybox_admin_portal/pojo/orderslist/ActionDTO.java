package com.example.akki.daybox_admin_portal.pojo.orderslist;

/**
 * Created by Akki on 07-06-2017.
 */

public class ActionDTO {
    private ActionValueDTO purchase;
    private ActionValueDTO sales;

    public ActionValueDTO getPurchase() {
        return purchase;
    }

    public void setPurchase(ActionValueDTO purchase) {
        this.purchase = purchase;
    }

    public ActionValueDTO getSales() {
        return sales;
    }

    public void setSales(ActionValueDTO sales) {
        this.sales = sales;
    }
}
