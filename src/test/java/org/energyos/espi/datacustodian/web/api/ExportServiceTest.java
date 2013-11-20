package org.energyos.espi.datacustodian.web.api;

import com.google.common.collect.Lists;
import org.energyos.espi.common.BaseTest;
import org.energyos.espi.common.domain.Subscription;
import org.energyos.espi.common.service.SubscriptionService;
import org.energyos.espi.common.service.UsagePointService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.energyos.espi.common.test.EspiFactory.newSubscription;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


public class ExportServiceTest extends BaseTest {

    @Mock
    private UsagePointService usagePointService;
    @Mock
    private SubscriptionService subscriptionService;
    private ExportService exportService;
    private Subscription subscription;

    @Before
    public void before() {
        exportService = new ExportService();
        subscription = newSubscription();

        exportService.setSubscriptionService(subscriptionService);
        exportService.setUsagePointService(usagePointService);
    }

    @Test
    public void findAllForHashedId() throws Exception {
        when(subscriptionService.findByHashedId(subscription.getHashedId())).thenReturn(subscription);
        when(usagePointService.findAllIdsForRetailCustomer(subscription.getRetailCustomer().getId())).thenReturn(Lists.newArrayList(1L));

        assertThat(exportService.findAllForHashedId(subscription.getHashedId()).hasNext(), is(true));
    }
}
