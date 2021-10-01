# Trabalho_Java_3-Bimestre
API REST com Spring Boot e JPA

### GRUPO:
* Cauê Pacheco Palma
* Carlos Eduardo do Amaral
* Cristal de Souza Silva
* Eduardo Ferreira Silva

### Tabela de Paths:

VERBO HTTP	| END-POINT	   		             | DESCRIÇÃO
:----------:| :---------------------------:|:----------------------------------------:
GET			    | /time					               | Retorna todos os times existentes
POST			  |/time/criar				           | Criar um novo time
DELETE		  |/time/excluir_time/{id}		   | Apaga um time pelo id
PUT			    |/time/update_time/{id}		     | Altera os valores de um time pelo id
GET			    |/time/listar_jogadores /{id}  | Lista os usuários pertencentes ao time 
POST			  |/time/{id}/add_jogador		     | Cadastra um novo usuário para um time
DELETE		  |/time/{id}/remove_jogador 	   | Apaga um usuário pertencente ao time
PUT			    |/time/{id}/alterar_Jogador 	 | Altera os dados cadastrais de um usuário

### JSONS
* Time
~~~json
{
    "nome": "String Black",
    "tag": "STRB",
    "jogadores":[
        {
            "nome":"Kaori",
            "email":"kaori.String@gmail.com",
            "senha": "1234"
        },
		{
            "nome":"Tsuki",
            "email":"tsuki.String@gmail.com",
            "senha": "7896"
}
    ]
}
~~~

* Jogador
~~~json
{
    "nome": "Tsukishima",
    "email": "tsuki111.string@gmail.com",
    "senha": "5689"
}
~~~
