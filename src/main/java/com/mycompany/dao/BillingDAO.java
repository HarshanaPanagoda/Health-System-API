package com.mycompany.dao;

import com.mycompany.models.Billing;
import java.util.HashMap;
import java.util.Map;

public class BillingDAO {
    private final Map<Long, Billing> billingMap = new HashMap<>();
    
    public void addBilling(Billing billing) {
        billingMap.put(billing.getId(), billing);
    }
    
    public Billing getBillingById(long id) {
        return billingMap.get(id);
    }
    
    public void updateBilling(Billing billing) {
        if (billingMap.containsKey(billing.getId())) {
            billingMap.put(billing.getId(), billing);
        }
    }
    
    public void deleteBilling(long id) {
        billingMap.remove(id);
    }
}
