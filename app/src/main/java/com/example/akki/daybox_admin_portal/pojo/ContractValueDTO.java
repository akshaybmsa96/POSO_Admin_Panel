package com.example.akki.daybox_admin_portal.pojo;

/**
 * Created by Akki on 07-06-2017.
 */

public class ContractValueDTO {
    private int type_id;
    private Boolean is_account_active;
    private String template_name;
    private String address;
    private int last_order_time;
    private Boolean is_cash_unit;
    private int id;
    private String city;
    private Boolean is_pseudo;
    private String unit_id;
    private String template;
    private String email;
    private BusinessDTO business;
    private Boolean item_changes_allow;
    private int same_unit_group;
    private int purchase_allocation_time;
    private String name;
    private int last_inventory_update;
    private String show_name;
    private Boolean is_to_call_for_orders;
    private Boolean is_automatic_allocation;
    private SalesPersonDTO sales_person;
    private int pos_sales_id;

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public Boolean getIs_account_active() {
        return is_account_active;
    }

    public void setIs_account_active(Boolean is_account_active) {
        this.is_account_active = is_account_active;
    }

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLast_order_time() {
        return last_order_time;
    }

    public void setLast_order_time(int last_order_time) {
        this.last_order_time = last_order_time;
    }

    public Boolean getIs_cash_unit() {
        return is_cash_unit;
    }

    public void setIs_cash_unit(Boolean is_cash_unit) {
        this.is_cash_unit = is_cash_unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getIs_pseudo() {
        return is_pseudo;
    }

    public void setIs_pseudo(Boolean is_pseudo) {
        this.is_pseudo = is_pseudo;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BusinessDTO getBusiness() {
        return business;
    }

    public void setBusiness(BusinessDTO business) {
        this.business = business;
    }

    public Boolean getItem_changes_allow() {
        return item_changes_allow;
    }

    public void setItem_changes_allow(Boolean item_changes_allow) {
        this.item_changes_allow = item_changes_allow;
    }

    public int getSame_unit_group() {
        return same_unit_group;
    }

    public void setSame_unit_group(int same_unit_group) {
        this.same_unit_group = same_unit_group;
    }

    public int getPurchase_allocation_time() {
        return purchase_allocation_time;
    }

    public void setPurchase_allocation_time(int purchase_allocation_time) {
        this.purchase_allocation_time = purchase_allocation_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLast_inventory_update() {
        return last_inventory_update;
    }

    public void setLast_inventory_update(int last_inventory_update) {
        this.last_inventory_update = last_inventory_update;
    }

    public String getShow_name() {
        return show_name;
    }

    public void setShow_name(String show_name) {
        this.show_name = show_name;
    }

    public Boolean getIs_to_call_for_orders() {
        return is_to_call_for_orders;
    }

    public void setIs_to_call_for_orders(Boolean is_to_call_for_orders) {
        this.is_to_call_for_orders = is_to_call_for_orders;
    }

    public Boolean getIs_automatic_allocation() {
        return is_automatic_allocation;
    }

    public void setIs_automatic_allocation(Boolean is_automatic_allocation) {
        this.is_automatic_allocation = is_automatic_allocation;
    }

    public SalesPersonDTO getSales_person() {
        return sales_person;
    }

    public void setSales_person(SalesPersonDTO sales_person) {
        this.sales_person = sales_person;
    }

    public int getPos_sales_id() {
        return pos_sales_id;
    }

    public void setPos_sales_id(int pos_sales_id) {
        this.pos_sales_id = pos_sales_id;
    }
}
