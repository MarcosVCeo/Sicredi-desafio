Esse projeto é feito com spark/scala e foi usado docker para facilitar como rodar o mesmo.

1 - É possível adicionar valores caso necessário ao banco que vai ser usado no arquivo `init.sql` em
`src/main/docker/init.sql`

2 - Para escolher o local de saida do arquivo fat gerado é necessário alterar o valor de `DIR_SAIDA_LOCAL` em
`src/main/docker/.env`

3 - na pasta rais do projeto com o sbt instalado usar o comando.

```shell
    sbt  clean assembly
```

4 - Para iniciar rodar o projeto na pasta raiz rode o comando

```shell
    docker compose -f src/main/docker/docker-compose.yml up --build -d
```
