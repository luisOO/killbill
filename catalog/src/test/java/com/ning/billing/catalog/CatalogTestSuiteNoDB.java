/*
 * Copyright 2010-2013 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.catalog;

import org.testng.annotations.BeforeClass;

import com.ning.billing.GuicyKillbillTestSuiteNoDB;
import com.ning.billing.catalog.glue.TestCatalogModuleNoDB;
import com.ning.billing.catalog.io.VersionedCatalogLoader;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public abstract class CatalogTestSuiteNoDB extends GuicyKillbillTestSuiteNoDB {

    @Inject
    protected VersionedCatalogLoader loader;

    @BeforeClass(groups = "fast")
    protected void beforeClass() throws Exception {
        final Injector injector = Guice.createInjector(new TestCatalogModuleNoDB(configSource));
        injector.injectMembers(this);
    }
}
