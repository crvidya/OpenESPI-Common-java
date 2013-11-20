package org.energyos.espi.datacustodian.web.api;

import org.energyos.espi.common.domain.UsagePoint;
import org.energyos.espi.common.models.atom.EntryType;
import org.energyos.espi.common.service.UsagePointService;
import org.energyos.espi.common.utils.EntryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;


public class EntryTypeIterator {

    @Autowired
    private UsagePointService usagePointService;

    private EntryBuilder entryBuilder;

    private Iterator<Long> usagePointIds;

    public EntryTypeIterator(List<Long> ids) {
        usagePointIds = ids.iterator();
        entryBuilder = new EntryBuilder();
    }

    public boolean hasNext() {
        return usagePointIds.hasNext();
    }

    public EntryType next() {
        UsagePoint usagePoint = usagePointService.findById(usagePointIds.next());
        return entryBuilder.build(usagePoint);
    }

    public void setUsagePointService(UsagePointService usagePointService) {
        this.usagePointService = usagePointService;
    }

    public void setEntryBuilder(EntryBuilder entryBuilder) {
        this.entryBuilder = entryBuilder;
    }


}
