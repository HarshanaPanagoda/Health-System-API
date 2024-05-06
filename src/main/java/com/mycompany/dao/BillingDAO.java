package com.mycompany.dao;

import com.mycompany.models.Billing;

import java.util.HashMap;
import java.util.Map;

public class BillingDAO {
    private final Map<Long, Billing> billingMap = new HashMap<>();

    public BillingDAO() {
        // Initialize with sample billing
        Billing billing1 = new Billing(1, null, 100.0, false);
        Billing billing2 = new Billing(2, null, 200.0, true);

        billingMap.put(billing1.getId(), billing1);
        billingMap.put(billing2.getId(), billing2);
    }

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
