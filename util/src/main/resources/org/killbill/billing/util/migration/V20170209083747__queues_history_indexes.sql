alter table notifications_history add index notifications_history_tenant_account_record_id(search_key2, search_key1);
alter table bus_events_history add index bus_events_history_tenant_account_record_id(search_key2, search_key1);
alter table bus_ext_events_history add index bus_ext_events_history_tenant_account_record_id(search_key2, search_key1);