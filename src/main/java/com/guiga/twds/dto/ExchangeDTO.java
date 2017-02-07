package com.guiga.twds.dto;

import java.util.List;

/**
 * Created by guilherme on 21/01/17.
 */
public class ExchangeDTO {

    private Long userId;

    private String recipientName;

    private List<ItemDTO> itemsWanted;

    private List<ItemDTO> itemsForPayment;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public List<ItemDTO> getItemsWanted() {
        return itemsWanted;
    }

    public void setItemsWanted(List<ItemDTO> itemsWanted) {
        this.itemsWanted = itemsWanted;
    }

    public List<ItemDTO> getItemsForPayment() {
        return itemsForPayment;
    }

    public void setItemsForPayment(List<ItemDTO> itemsForPayment) {
        this.itemsForPayment = itemsForPayment;
    }
}
