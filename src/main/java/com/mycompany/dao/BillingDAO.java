package com.mycompany.dao;

import com.mycompany.models.Billing;
import com.mycompany.models.Patient;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BillingDAO {
    private static final Logger logger = LoggerFactory.getLogger(BillingDAO.class);
    private static BillingDAO instance;  // Singleton instance
    private final Map<Long, Billing> billingMap = new HashMap<>();

    public BillingDAO() {
        // Initialize with sample bills
        Patient patient1 = new Patient(1, "John Doe", "1234567890", "123 Main St", "Heart disease", "Stable");
        Patient patient2 = new Patient(2, "Jane Smith", "0987654321", "456 Elm St", "Diabetes", "Improving");

        Billing billing1 = new Billing(1, patient1, 100.0, true);
        Billing billing2 = new Billing(2, patient2, 150.0, false);

        billingMap.put(billing1.getId(), billing1);
        billingMap.put(billing2.getId(), billing2);
    }

    public static synchronized BillingDAO getInstance() {
        if (instance == null) {
            instance = new BillingDAO();
        }
        return instance;
    }

    public Collection<Billing> getAllBillings() {
        return billingMap.values();
    }

    public void addBilling(Billing billing) {
        if (!billingMap.containsKey(billing.getId())) {
            billingMap.put(billing.getId(), billing);
            logger.info("Successfully added billing with ID: {}", billing.getId());
        } else {
            logger.error("A billing with ID {} already exists and was not added.", billing.getId());
        }
    }

    public Billing getBillingById(long id) {
        return billingMap.get(id);
    }

    public boolean updateBilling(Billing billing) {
        if (billingMap.containsKey(billing.getId())) {
            billingMap.put(billing.getId(), billing);
            return true;
        }
        return false;
    }

    public boolean deleteBilling(long id) {
        if (billingMap.containsKey(id)) {
            billingMap.remove(id);
            return true;
        }
        return false;
    }
}
