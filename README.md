# Learning spring cloud.

# Requirements:

- [Vault](https://www.vaultproject.io/)
- [RabbitMQ](https://www.rabbitmq.com/)
- [Keycloak](https://www.keycloak.org/)

# Vault

## To add anythin to vault use:
"vault kv put secret/{FOLDER-NAME} @{JSON-FILE.json}"

## To run vault dev server: 
"vault server -dev"

### You need to use root token to connect microservice to vault in bootstrap.properties file.

### To refresh properties, use */actuator/busrefresh on any endpoint.

### To run keycloack server, inside */bin folder run:

"standalone.bat -Djboss.http.port=8180"

