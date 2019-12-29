# spring-boot-vault-config
Spring boot with Restful Example and Dynamic config (centralize configuration) Enabled using Vault.

### Install and launch HashiCorp Vault
* With your project set up, you can install and launch HashiCorp Vault.
* If you are using a Mac with homebrew, this is as simple as:

	> brew install vault

Alternatively, download Vault for your operating system from [Vault_download]:

	[Vault_zip]

	unzip vault_1.2.1_darwin_amd64.zip

For other systems with package management, such as Redhat, Ubuntu, Debian, CentOS, and Windows, see instructions at [Vault_docs].

After you install Vault, launch it in a console window. This command also starts up a server process.

	vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"

### Store configuration in Vault:
Vault is a secrets management system allowing you to store sensitive data which is encrypted at rest. It’s ideal to store sensitive configuration details such as passwords, encryption keys, API keys.

Launch another console window to store application configuration in Vault using the Vault command line.

First, you need to set two environment variables to point the Vault CLI to the Vault endpoint and provide an authentication token.

	export export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"
	export VAULT_ADDR="http://127.0.0.1:8200"
	or
	set VAULT_ADDR=http://127.0.0.1:8200

* Now you can store a configuration key-value pairs inside Vault:

	> vault kv put secret/spring-vault-config example.username=demouser example.password=demopassword
	
	> vault kv put secret/spring-vault-config/cloud example.username=clouduser example.password=cloudpassword

* Vault commands:

	> vault kv get secret/spring-vault-config
	
	> vault kv delete secret/spring-vault-config
	
	> vault secrets list
	
* Vault UI:
	
	> http://127.0.0.1:8200
	
* Refresh the Configuration after changing the vault configuration key
	Hit the below post url in the postman. 
	http://localhost:8080/actuator/refresh
	
**Thanks**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


[Vault_zip]: <https://releases.hashicorp.com/vault/1.2.1/vault_1.2.1_darwin_amd64.zip>
[Vault_docs]: <https://www.vaultproject.io/docs/install/index.html>
[Vault_download]: <https://www.vaultproject.io/downloads.html>
