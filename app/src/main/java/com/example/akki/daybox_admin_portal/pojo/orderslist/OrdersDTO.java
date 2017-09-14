package com.example.akki.daybox_admin_portal.pojo.orderslist;

/**
 * Created by Akki on 07-06-2017.
 */

public class OrdersDTO {
    private String sales_status_name;
    private String purchase_status_name;
    private int invoiced_tax_amount;
    private Boolean is_completed;
    private Double sub_total;
    private int deliveries;
    private Boolean is_confirmed_by_super_admin;
    private int extra_charge_amount;
    private ContractDTO contract;
    private String delivery_report;
    private int id;
    private int purchase_status;
    private int priority;
    private int received_sub_total;
    private int final_tax_amount;
    private String order_id;
    private Double invoiced_amount;
    private String extra_charge_name;
    private int tax_amount;
    private int sales_status;
    private Long created_at;
    private int dispatched_sub_total;
    private Boolean is_challan_uploaded;
    private Double final_amount;
    private Double invoiced_sub_total;
    private Double amount;
    private ActionValueDTO action;
    private Long delivery_date;
    private Double final_sub_total;

    public String getSales_status_name() {
        return sales_status_name;
    }

    public void setSales_status_name(String sales_status_name) {
        this.sales_status_name = sales_status_name;
    }

    public String getPurchase_status_name() {
        return purchase_status_name;
    }

    public void setPurchase_status_name(String purchase_status_name) {
        this.purchase_status_name = purchase_status_name;
    }

    public int getInvoiced_tax_amount() {
        return invoiced_tax_amount;
    }

    public void setInvoiced_tax_amount(int invoiced_tax_amount) {
        this.invoiced_tax_amount = invoiced_tax_amount;
    }

    public Boolean getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(Boolean is_completed) {
        this.is_completed = is_completed;
    }

    public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(Double sub_total) {
        this.sub_total = sub_total;
    }

    public int getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(int deliveries) {
        this.deliveries = deliveries;
    }

    public Boolean getIs_confirmed_by_super_admin() {
        return is_confirmed_by_super_admin;
    }

    public void setIs_confirmed_by_super_admin(Boolean is_confirmed_by_super_admin) {
        this.is_confirmed_by_super_admin = is_confirmed_by_super_admin;
    }

    public int getExtra_charge_amount() {
        return extra_charge_amount;
    }

    public void setExtra_charge_amount(int extra_charge_amount) {
        this.extra_charge_amount = extra_charge_amount;
    }

    public ContractDTO getContract() {
        return contract;
    }

    public void setContract(ContractDTO contract) {
        this.contract = contract;
    }

    public String getDelivery_report() {
        return delivery_report;
    }

    public void setDelivery_report(String delivery_report) {
        this.delivery_report = delivery_report;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchase_status() {
        return purchase_status;
    }

    public void setPurchase_status(int purchase_status) {
        this.purchase_status = purchase_status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getReceived_sub_total() {
        return received_sub_total;
    }

    public void setReceived_sub_total(int received_sub_total) {
        this.received_sub_total = received_sub_total;
    }

    public int getFinal_tax_amount() {
        return final_tax_amount;
    }

    public void setFinal_tax_amount(int final_tax_amount) {
        this.final_tax_amount = final_tax_amount;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Double getInvoiced_amount() {
        return invoiced_amount;
    }

    public void setInvoiced_amount(Double invoiced_amount) {
        this.invoiced_amount = invoiced_amount;
    }

    public String getExtra_charge_name() {
        return extra_charge_name;
    }

    public void setExtra_charge_name(String extra_charge_name) {
        this.extra_charge_name = extra_charge_name;
    }

    public int getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(int tax_amount) {
        this.tax_amount = tax_amount;
    }

    public int getSales_status() {
        return sales_status;
    }

    public void setSales_status(int sales_status) {
        this.sales_status = sales_status;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public int getDispatched_sub_total() {
        return dispatched_sub_total;
    }

    public void setDispatched_sub_total(int dispatched_sub_total) {
        this.dispatched_sub_total = dispatched_sub_total;
    }

    public Boolean getIs_challan_uploaded() {
        return is_challan_uploaded;
    }

    public void setIs_challan_uploaded(Boolean is_challan_uploaded) {
        this.is_challan_uploaded = is_challan_uploaded;
    }

    public Double getFinal_amount() {
        return final_amount;
    }

    public void setFinal_amount(Double final_amount) {
        this.final_amount = final_amount;
    }

    public Double getInvoiced_sub_total() {
        return invoiced_sub_total;
    }

    public void setInvoiced_sub_total(Double invoiced_sub_total) {
        this.invoiced_sub_total = invoiced_sub_total;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ActionValueDTO getAction() {
        return action;
    }

    public void setAction(ActionValueDTO action) {
        this.action = action;
    }

    public Long getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Long delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Double getFinal_sub_total() {
        return final_sub_total;
    }

    public void setFinal_sub_total(Double final_sub_total) {
        this.final_sub_total = final_sub_total;
    }
}
