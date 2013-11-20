package org.energyos.espi.datacustodian.web.api;


import org.energyos.espi.common.domain.Subscription;
import org.energyos.espi.common.service.SubscriptionService;
import org.energyos.espi.common.service.UsagePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportService {

    @Autowired
    private UsagePointService usagePointService;

    @Autowired
    SubscriptionService subscriptionService;

    public EntryTypeIterator findAllForHashedId(String hashedId) {
        Subscription subscription = subscriptionService.findByHashedId(hashedId);
        List<Long> ids = usagePointService.findAllIdsForRetailCustomer(subscription.getRetailCustomer().getId());
        return new EntryTypeIterator(ids);
    }

    public UsagePointService getUsagePointService() {
        return usagePointService;
    }

    public void setUsagePointService(UsagePointService usagePointService) {
        this.usagePointService = usagePointService;
    }

    public void setSubscriptionService(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }
}
