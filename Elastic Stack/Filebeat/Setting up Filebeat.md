_/etc/filebeat/filebeat.reference.yml_ hosts reference to all Filebeat settings.

_/etc/filebeat/modules.d/_ hosts different modules for Kibana, Nginx etc. 
Originally, modules are listed as _nginx.yml.disabled_. To enable a module, rename it like this: 

**mv module.yml.disabled module.yml**

ElasticSearch output is configured via _/etc/filebeat/filebeat.yml_ (Elasticsearch Output)
