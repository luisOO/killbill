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

package com.ning.billing.overdue.glue;

import org.skife.config.ConfigSource;

import com.ning.billing.mock.glue.MockAccountModule;
import com.ning.billing.mock.glue.MockEntitlementModule;
import com.ning.billing.mock.glue.MockInvoiceModule;
import com.ning.billing.mock.glue.MockTagModule;
import com.ning.billing.overdue.TestOverdueHelper;
import com.ning.billing.overdue.applicator.OverdueBusListenerTester;
import com.ning.billing.util.email.EmailModule;
import com.ning.billing.util.email.templates.TemplateModule;
import com.ning.billing.util.glue.AuditModule;
import com.ning.billing.util.glue.CacheModule;
import com.ning.billing.util.glue.CallContextModule;
import com.ning.billing.util.glue.CustomFieldModule;

public class TestOverdueModule extends DefaultOverdueModule {

    public TestOverdueModule(final ConfigSource configSource) {
        super(configSource);
    }

    @Override
    protected void configure() {
        super.configure();

        install(new AuditModule());
        install(new CacheModule(configSource));
        install(new CallContextModule());
        install(new CustomFieldModule());
        install(new EmailModule(configSource));
        install(new MockAccountModule());
        install(new MockEntitlementModule());
        install(new MockInvoiceModule());
        install(new MockTagModule());
        install(new TemplateModule());

        // We can't use the dumb mocks in MockJunctionModule here
        install(new ApplicatorMockJunctionModule());

        bind(OverdueBusListenerTester.class).asEagerSingleton();
        bind(TestOverdueHelper.class).asEagerSingleton();
    }
}
