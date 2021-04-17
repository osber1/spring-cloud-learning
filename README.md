# Learning spring cloud.

# Requirements:

- [Vault](https://www.vaultproject.io/)
- [RabbitMQ](https://www.rabbitmq.com/)
- [Keycloak](https://www.keycloak.org/)
- [Zipkin](https://zipkin.io/)
- [Elasticsearch](https://www.elastic.co/downloads/elasticsearch)
- [Logstash](https://www.elastic.co/downloads/logstash)
- [Kibana](https://www.elastic.co/downloads/kibana)

# Vault

### To run vault dev server: 
```bash
vault server -dev
vault kv put secret/order-service @order-service.json
vault kv put secret/product-service @product-service.json
vault kv put secret/inventory-service @inventory-service.json
```

### Information

You need to use root token to connect microservice to Vault in bootstrap.properties file.

To refresh properties, use */actuator/busrefresh on any endpoint.

To run keycloack server, inside */bin folder run:

# Keycloak

### Run keycloak

```bash
standalone.bat -Djboss.http.port=8180
```

# Zipkin

## Run Zipkin

```bash
java -jar zipkin.jar
```

# Endpoints

http://localhost:5000 - Logstash server  
http://localhost:5601 - Kibana server  
http://localhost:8080 - main endpoint  
http://localhost:8180 - Keycloak server  
http://localhost:8200 - Vault server  
http://localhost:8761 - Eureka server  
http://localhost:8888 - Cloud server  
http://localhost:9200 - Elasticsearch server  
http://localhost:15672 - RabbitMQ server  
