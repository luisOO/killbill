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

package com.ning.billing.osgi.bundles.analytics.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.ning.billing.account.api.Account;
import com.ning.billing.invoice.api.Invoice;
import com.ning.billing.util.audit.AuditLog;

public class BusinessInvoiceModelDao extends BusinessModelDaoBase {

    public static final String INVOICES_TABLE_NAME = "bin";

    private final Long invoiceRecordId;
    private final UUID invoiceId;
    private final Integer invoiceNumber;
    private final LocalDate invoiceDate;
    private final LocalDate targetDate;
    private final String currency;
    private final BigDecimal balance;
    private final BigDecimal amountPaid;
    private final BigDecimal amountCharged;
    private final BigDecimal originalAmountCharged;
    private final BigDecimal amountCredited;

    public BusinessInvoiceModelDao(final Long invoiceRecordId,
                                   final UUID invoiceId,
                                   final Integer invoiceNumber,
                                   final LocalDate invoiceDate,
                                   final LocalDate targetDate,
                                   final String currency,
                                   final BigDecimal balance,
                                   final BigDecimal amountPaid,
                                   final BigDecimal amountCharged,
                                   final BigDecimal originalAmountCharged,
                                   final BigDecimal amountCredited,
                                   final DateTime createdDate,
                                   final String createdBy,
                                   final String createdReasonCode,
                                   final String createdComments,
                                   final UUID accountId,
                                   final String accountName,
                                   final String accountExternalKey,
                                   final Long accountRecordId,
                                   final Long tenantRecordId) {
        super(createdDate,
              createdBy,
              createdReasonCode,
              createdComments,
              accountId,
              accountName,
              accountExternalKey,
              accountRecordId,
              tenantRecordId);
        this.invoiceRecordId = invoiceRecordId;
        this.invoiceId = invoiceId;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.targetDate = targetDate;
        this.currency = currency;
        this.balance = balance;
        this.amountPaid = amountPaid;
        this.amountCharged = amountCharged;
        this.originalAmountCharged = originalAmountCharged;
        this.amountCredited = amountCredited;
    }

    public BusinessInvoiceModelDao(final Account account,
                                   final Invoice invoice,
                                   final AuditLog creationAuditLog) {
        this(null /* TODO */,
             invoice.getId(),
             invoice.getInvoiceNumber(),
             invoice.getInvoiceDate(),
             invoice.getTargetDate(),
             invoice.getCurrency() == null ? null : invoice.getCurrency().toString(),
             invoice.getBalance(),
             invoice.getPaidAmount(),
             invoice.getChargedAmount(),
             null /* TODO */,
             invoice.getCreditAdjAmount(),
             invoice.getCreatedDate(),
             creationAuditLog.getUserName(),
             creationAuditLog.getReasonCode(),
             creationAuditLog.getComment(),
             account.getId(),
             account.getName(),
             account.getExternalKey(),
             // TODO
             null,
             null);
    }

    @Override
    public String getTableName() {
        return INVOICES_TABLE_NAME;
    }

    public Long getInvoiceRecordId() {
        return invoiceRecordId;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public BigDecimal getAmountCharged() {
        return amountCharged;
    }

    public BigDecimal getOriginalAmountCharged() {
        return originalAmountCharged;
    }

    public BigDecimal getAmountCredited() {
        return amountCredited;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BusinessInvoiceModelDao");
        sb.append("{invoiceRecordId=").append(invoiceRecordId);
        sb.append(", invoiceId=").append(invoiceId);
        sb.append(", invoiceNumber=").append(invoiceNumber);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append(", targetDate=").append(targetDate);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", amountPaid=").append(amountPaid);
        sb.append(", amountCharged=").append(amountCharged);
        sb.append(", originalAmountCharged=").append(originalAmountCharged);
        sb.append(", amountCredited=").append(amountCredited);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final BusinessInvoiceModelDao that = (BusinessInvoiceModelDao) o;

        if (amountCharged != null ? !amountCharged.equals(that.amountCharged) : that.amountCharged != null) {
            return false;
        }
        if (amountCredited != null ? !amountCredited.equals(that.amountCredited) : that.amountCredited != null) {
            return false;
        }
        if (amountPaid != null ? !amountPaid.equals(that.amountPaid) : that.amountPaid != null) {
            return false;
        }
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) {
            return false;
        }
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) {
            return false;
        }
        if (invoiceDate != null ? !invoiceDate.equals(that.invoiceDate) : that.invoiceDate != null) {
            return false;
        }
        if (invoiceId != null ? !invoiceId.equals(that.invoiceId) : that.invoiceId != null) {
            return false;
        }
        if (invoiceNumber != null ? !invoiceNumber.equals(that.invoiceNumber) : that.invoiceNumber != null) {
            return false;
        }
        if (invoiceRecordId != null ? !invoiceRecordId.equals(that.invoiceRecordId) : that.invoiceRecordId != null) {
            return false;
        }
        if (originalAmountCharged != null ? !originalAmountCharged.equals(that.originalAmountCharged) : that.originalAmountCharged != null) {
            return false;
        }
        if (targetDate != null ? !targetDate.equals(that.targetDate) : that.targetDate != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (invoiceRecordId != null ? invoiceRecordId.hashCode() : 0);
        result = 31 * result + (invoiceId != null ? invoiceId.hashCode() : 0);
        result = 31 * result + (invoiceNumber != null ? invoiceNumber.hashCode() : 0);
        result = 31 * result + (invoiceDate != null ? invoiceDate.hashCode() : 0);
        result = 31 * result + (targetDate != null ? targetDate.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (amountPaid != null ? amountPaid.hashCode() : 0);
        result = 31 * result + (amountCharged != null ? amountCharged.hashCode() : 0);
        result = 31 * result + (originalAmountCharged != null ? originalAmountCharged.hashCode() : 0);
        result = 31 * result + (amountCredited != null ? amountCredited.hashCode() : 0);
        return result;
    }
}
