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

package com.ning.billing.account.glue;

import org.skife.config.ConfigSource;

import com.ning.billing.account.api.AccountService;
import com.ning.billing.account.api.AccountUserApi;
import com.ning.billing.account.api.DefaultAccountService;
import com.ning.billing.account.api.svcs.DefaultAccountInternalApi;
import com.ning.billing.account.api.user.DefaultAccountUserApi;
import com.ning.billing.account.dao.AccountDao;
import com.ning.billing.account.dao.DefaultAccountDao;
import com.ning.billing.glue.AccountModule;
import com.ning.billing.util.glue.RealImplementation;
import com.ning.billing.util.svcapi.account.AccountInternalApi;

import com.google.inject.AbstractModule;

public class DefaultAccountModule extends AbstractModule implements AccountModule {

    protected final ConfigSource configSource;

    public DefaultAccountModule(final ConfigSource configSource) {
        this.configSource = configSource;
    }

    private void installConfig() {
    }

    protected void installAccountDao() {
        bind(AccountDao.class).to(DefaultAccountDao.class).asEagerSingleton();
    }

    @Override
    public void installAccountUserApi() {
        bind(AccountUserApi.class).annotatedWith(RealImplementation.class).to(DefaultAccountUserApi.class).asEagerSingleton();
    }

    @Override
    public void installInternalApi() {
        bind(AccountInternalApi.class).to(DefaultAccountInternalApi.class).asEagerSingleton();
    }

    private void installAccountService() {
        bind(AccountService.class).to(DefaultAccountService.class).asEagerSingleton();
    }

    @Override
    protected void configure() {
        installConfig();
        installAccountDao();
        installAccountService();
        installAccountUserApi();
        installInternalApi();
    }
}
