package org.energyos.espi.datacustodian.web.api;


import com.google.common.collect.Lists;
import org.energyos.espi.common.BaseTest;
import org.energyos.espi.common.domain.UsagePoint;
import org.energyos.espi.common.models.atom.EntryType;
import org.energyos.espi.common.service.UsagePointService;
import org.energyos.espi.common.utils.EntryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.energyos.espi.common.test.EspiFactory.newUsagePoint;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class EntryTypeIteratorTest extends BaseTest {

    @Mock
    private UsagePointService usagePointService;

    @Mock
    private EntryBuilder entryBuilder;

    private EntryTypeIterator iterator;

    @Before
    public void before() throws Exception {
        iterator = new EntryTypeIterator(Lists.newArrayList(1L));
        iterator.setUsagePointService(usagePointService);
        iterator.setEntryBuilder(entryBuilder);
    }

    @Test
    public void hasNext_givenElements() {
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void hasNext_givenNoElements() {
        iterator = new EntryTypeIterator(new ArrayList<Long>());
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void next_movesTheIterator() {
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void next() {
        UsagePoint usagePoint = newUsagePoint();
        EntryType entry = new EntryType();
        when(usagePointService.findById(1L)).thenReturn(usagePoint);
        when(entryBuilder.build(usagePoint)).thenReturn(entry);

        assertThat(iterator.next(), is(equalTo(entry)));
    }
}
