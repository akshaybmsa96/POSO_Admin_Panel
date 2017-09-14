package com.example.akki.daybox_admin_portal.pojo.orderslist;

/**
 * Created by Akki on 07-06-2017.
 */

public class ContractDTO {
    private Boolean is_risk_purchase;
    private ContractValueDTO buyer;
    private ContractValueDTO seller;
    private int id;
    private Boolean is_contract_created;

    public Boolean getIs_risk_purchase() {
        return is_risk_purchase;
    }

    public void setIs_risk_purchase(Boolean is_risk_purchase) {
        this.is_risk_purchase = is_risk_purchase;
    }

    public ContractValueDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(ContractValueDTO buyer) {
        this.buyer = buyer;
    }

    public ContractValueDTO getSeller() {
        return seller;
    }

    public void setSeller(ContractValueDTO seller) {
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIs_contract_created() {
        return is_contract_created;
    }

    public void setIs_contract_created(Boolean is_contract_created) {
        this.is_contract_created = is_contract_created;
    }
}
