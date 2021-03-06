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

package org.energyos.espi.common.domain;

import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.energyos.espi.common.support.TestUtils.assertAnnotationPresent;
import static org.energyos.espi.common.support.TestUtils.assertColumnAnnotation;
import static org.energyos.espi.common.test.EspiFactory.newAuthorization;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertTrue;

public class AuthorizationTests {

    @Test
    public void isValid() throws Exception {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Authorization authorization = newAuthorization();

        Set<ConstraintViolation<Authorization>> violations = validator.validate(authorization);

        assertThat(violations, is(empty()));
    }

    @Test
    public void isInvalid() throws Exception {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Authorization authorization = new Authorization();

        Set<ConstraintViolation<Authorization>> violations = validator.validate(authorization);

        assertThat(violations, is(not(empty())));
    }

    @Test
    public void extendsIdentifiableObject() {
        assertTrue(Authorization.class.getSuperclass() == IdentifiedObject.class);
    }

    @Test
    public void persistence() {
        assertAnnotationPresent(Authorization.class, Entity.class);
        assertAnnotationPresent(Authorization.class, Table.class);
    }

    @Test
    public void accessToken() {
        assertColumnAnnotation(Authorization.class, "accessToken", "access_token");
    }

    @Test
    public void authorizationServer() {
        assertColumnAnnotation(Authorization.class, "authorizationServer", "authorization_server");
    }

    @Test
    public void thirdParty() {
        assertColumnAnnotation(Authorization.class, "thirdParty", "third_party");
    }

    @Test
    public void retailCustomer() {
        assertAnnotationPresent(Authorization.class, "retailCustomer", ManyToOne.class);
        assertAnnotationPresent(Authorization.class, "retailCustomer", JoinColumn.class);
    }

    @Test
    public void state() {
        assertColumnAnnotation(Authorization.class, "state", "state");
    }

    @Test
    public void dataCustodian() {
        assertAnnotationPresent(Authorization.class, "dataCustodian", ManyToOne.class);
        assertAnnotationPresent(Authorization.class, "dataCustodian", JoinColumn.class);
    }

    @Test
    public void subscriptionId() {
        Authorization authorization = new Authorization();

        authorization.setSubscriptionURI("http://localhost:8080/DataCustodian/espi/1_1/resource/Subscription/16228736-8e29-4807-a2a7-283be5cc253e");

        assertThat(authorization.getSubscriptionId(), is("16228736-8e29-4807-a2a7-283be5cc253e"));
    }
}