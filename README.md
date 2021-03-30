# Learning spring cloud.

# Requirements:

- [Vault](https://www.vaultproject.io/)
- [RabbitMQ](https://www.rabbitmq.com/)
- [Keycloak](https://www.keycloak.org/)

# Vault

### To run vault dev server: 
```bash
vault server -dev
vault kv put secret/order-service @order-service.json
vault kv put secret/product-service @product-service.json
vault kv put secret/product-service @inventory-service.json
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
