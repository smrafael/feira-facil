# Feira Fácil :apple:
Projeto da disciplina Fundamentos de Programação Java para Web ministrada pela o professor Rodrigo da Cruz Fujioka

## Sobre :pencil:
O projeto trata-se de uma API para gerenciamento de pedidos. Um cliente deve fazer seu cadastro para ser fazer a adição de produtos à um pedido. Este pedido pode ter um desconto, o que afetará o seu preço final.

## Documentação :book:
A documentação da API encontra-se no endereço http://feira-facil.herokuapp.com/v2/api/swagger-ui.html

## Autenticação :closed_lock_with_key:
Para ser capaz de utilizar as APIS, é necessário um token de acesso que pode ser adquirido através do endpoint [POST]http://feira-facil.herokuapp.com/v2/api/login, utilizando o body abaixo:

``
{
	"username": "admin",
	"password": "password"
}
``

Ao efetuar o request com sucesso, o response possuirá um header chamado `Authorization` com valor `Bearer <token>`. Este valor deverá ser utilizado no header dos requests subsequentes para utilizar as outras APIs.
