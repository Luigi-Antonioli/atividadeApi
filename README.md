# JAVA + SPRING BOOT - API - TEMA: JOGOS

API REST desenvolvida em Java com Spring Boot para gerenciamento de jogos.

A API possui:

* Login
* Cadastro de jogos
* Listagem de jogos
* Busca por ID
* Atualização
* Remoção

---

## LINK DO POSTMAN
```text
https://.postman.co/workspace/POSTMAN~2bf7c1d9-49b6-4a91-b37b-53c53e93c654/collection/39211426-77243550-4930-4379-8e00-eb36980dbb14?action=share&creator=39211426
```

# Testes da API no Postman

## 1. Login

### POST

```text
http://localhost:8080/login
```

### Body

```json
{
  "email": "usuario@esoft.com",
  "password": "Abc123"
}
```

### Esperado

```text
200 OK
```

---

## 2. Cadastrar jogo

### POST

```text
http://localhost:8080/jogos
```

### Body

```json
{
  "nome": "Sons Of The Forest",
  "tipo": "Aventura",
  "nota": 9,
  "review": "Muito bom, um jogo com um mapa muito amplo e com vários desafios."
}
```

### Esperado

```text
201 Created
```

---

## 3. Listar jogos

### GET

```text
http://localhost:8080/jogos
```

### Esperado

```text
200 OK
```

---

## 4. Buscar jogo por ID

### GET

```text
http://localhost:8080/jogos/1
```

### Esperado

```text
200 OK
```

---

## 5. Atualizar jogo

### PUT

```text
http://localhost:8080/jogos/1
```

### Body

```json
{
  "nome": "PEAK",
  "tipo": "Exploração",
  "nota": 10,
  "review": "Obra prima, um jogo com um desafio que faz desafiar a mente."
}
```

### Esperado

```text
200 OK
```

---

## 6. Deletar jogo

### DELETE

```text
http://localhost:8080/jogos/1
```

### Esperado

```text
204 No Content
```

---

## 7. Teste final

### GET

```text
http://localhost:8080/jogos/1
```

### Esperado

```text
404 Not Found
```

---

# Status HTTP Esperados

| Método | Endpoint    | Status |
| ------ | ----------- | ------ |
| POST   | /login      | 200    |
| GET    | /jogos      | 200    |
| GET    | /jogos/{id} | 200    |
| POST   | /jogos      | 201    |
| PUT    | /jogos/{id} | 200    |
| DELETE | /jogos/{id} | 204    |
