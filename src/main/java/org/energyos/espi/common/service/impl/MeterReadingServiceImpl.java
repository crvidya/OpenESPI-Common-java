package org.energyos.espi.common.service.impl;

import org.energyos.espi.common.domain.MeterReading;
import org.energyos.espi.common.repositories.MeterReadingRepository;
import org.energyos.espi.common.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MeterReadingServiceImpl implements MeterReadingService {

    @Autowired
    protected MeterReadingRepository repository;

    public void setRepository(MeterReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public MeterReading findByUUID(UUID uuid) {
        return repository.findByUUID(uuid);
    }

    public MeterReading findById(Long meterReadingId) {
        return repository.findById(meterReadingId);
    }

    @Override
    public void persist(MeterReading meterReading) {
        repository.persist(meterReading);
    }
}
