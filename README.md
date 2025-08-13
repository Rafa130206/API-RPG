# 📌 API RPG - Campanhas, Personagens e Itens Amaldiçoados

Esta API foi desenvolvida para gerenciar campanhas, personagens, usuários e itens amaldiçoados de um RPG.  
Ela conta com autenticação JWT e segue o padrão RESTful.

## 🚀 Tecnologias
- Java 17+
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- Flyway (migração de banco de dados)
- MySQL
- Maven

---

## ⚙️ Variáveis de Ambiente

A API utiliza variáveis de ambiente para configurar o banco e a segurança:

| Variável            | Descrição |
|---------------------|-----------|
| `MYSQLHOST`         | Host do banco MySQL |
| `MYSQLPORT`         | Porta do banco MySQL |
| `MYSQLDATABASE`     | Nome do banco |
| `MYSQLUSER`         | Usuário do banco |
| `MYSQLPASSWORD`     | Senha do banco |
| `JWT_SECRET`        | Chave secreta para geração de tokens JWT |

---

## ▶️ Como Rodar Localmente

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/APICampanha.git
cd APICampanha

# Configurar variáveis de ambiente (criar .env ou exportar no terminal)
export MYSQLHOST=localhost
export MYSQLPORT=3306
export MYSQLDATABASE=api_rpg
export MYSQLUSER=root
export MYSQLPASSWORD=senha
export JWT_SECRET=chave-super-secreta

# Rodar a aplicação
./mvnw spring-boot:run
```

## 📡 Endpoints
### Autenticação

| Método              | Endpoint  | Descrição           |
|---------------------|-----------|--------------------|
| `POST`         | /login | Realiza login e retorna token JWT |

### Usuários

| Método              | Endpoint  | Descrição           |
|---------------------|-----------|--------------------|
| `POST`         | /usuarios | Cria um novo usuário |

### Campanhas

| Método              | Endpoint  | Descrição           |
|---------------------|-----------|--------------------|
| `POST`        | /campanhas | Cria campanha |
| `GET`         | /campanhas | Lista campanhas |
| `GET`         | /campanhas/{id} | Detalhes de uma campanha |
| `PUT`         | /campanhas | Cria Atualiza Campanha |
| `DELETE`      | /campanhas/{id} | Remove Campanha |

### Itens Amaldiçoados

| Método              | Endpoint  | Descrição           |
|---------------------|-----------|--------------------|
| `POST`        | /itens | Cria item amaldiçoado |
| `GET`         | /itens | Lista items amaldiçoados |
| `GET`         | /itens/{id} | Detalhes de um item amaldiçoado |
| `PUT`         | /itens | Cria Atualiza item amaldiçoado |
| `DELETE`      | /itens/{id} | Remove item amaldiçoado |

### Personagens

| Método              | Endpoint  | Descrição           |
|---------------------|-----------|--------------------|
| `POST`        | /personagens | Cria personagm |
| `GET`         | /personagens | Lista personagens |
| `GET`         | /personagens/{id} | Detalhes de um personagem |
| `PUT`         | /personagens | Cria Atualiza personagem |
| `DELETE`      | /personagens/{id} | Remove personagem |

---

## 🔐 Endpoints
A API utiliza JWT
- Endpoints protegidos exigem o header:
```bash
Authorization: Bearer {token}
```
- O token é obtido ao fazer login em `/login` com:
```bash
{
  "login": "usuario",
  "senha": "senha"
}
```
