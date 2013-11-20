/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.energyos.espi.common.repositories.jpa;

import org.energyos.espi.common.domain.ApplicationInformation;
import org.energyos.espi.common.domain.ThirdParty;
import org.energyos.espi.common.repositories.ApplicationInformationRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ApplicationInformationRepositoryImpl implements ApplicationInformationRepository {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public ApplicationInformation findById(Long id) {
        return (ApplicationInformation)em.createNamedQuery(ApplicationInformation.QUERY_FIND_BY_ID)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ApplicationInformation> findAll() {
        return (List<ApplicationInformation>)this.em
                .createNamedQuery(ApplicationInformation.QUERY_FIND_ALL).getResultList();
    }

    @Override
    public void persist(ApplicationInformation thirdParty) {
        em.persist(thirdParty);
    }

    @Override
    public ApplicationInformation findByClientId(String clientId) {
        return (ApplicationInformation)em.createNamedQuery(ApplicationInformation.QUERY_FIND_BY_CLIENT_ID)
                .setParameter("clientId", clientId).getSingleResult();
    }
}
