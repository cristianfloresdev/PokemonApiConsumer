# 🧢 Poké Team API

## 📌 Descripción

Poké Team API es una aplicación backend desarrollada con **Spring Boot** que permite gestionar entrenadores Pokémon, sus equipos y la integración con la API externa de Pokémon (PokeAPI).

El sistema permite crear entrenadores, asignar equipos y capturar Pokémon consumiendo datos en tiempo real desde una API externa, almacenándolos en una base de datos MySQL.

---

## ⚙️ Tecnologías utilizadas

* Java 21+
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Lombok
* REST API
* PokeAPI (API externa)

---

## 🧠 Arquitectura del proyecto

El proyecto sigue una arquitectura por capas:

* Controller → Manejo de endpoints REST
* Service → Lógica de negocio
* Repository → Acceso a datos (JPA)
* Entity → Modelado de base de datos
* DTO → Transferencia de datos desde APIs externas

<img width="1202" height="809" alt="image" src="https://github.com/user-attachments/assets/82fb4415-3064-4f45-b4a8-71bf33935292" />

<img width="827" height="784" alt="image" src="https://github.com/user-attachments/assets/93b53ebb-9692-40bd-83c9-c457d2687711" />

---

## 📊 Funcionalidades principales

### 👤 Trainers

* Crear entrenador
* Listar entrenadores
* Actualizar entrenador
* Eliminar entrenador

### 🏟️ Teams

* Cada trainer tiene un equipo
* Un equipo puede contener hasta 6 Pokémon

### ⚡ Pokémon

* Captura de Pokémon desde PokeAPI
* Almacenamiento en base de datos
* Relación con equipos
* Evita duplicados por equipo

---

## 🌐 Integración externa

El proyecto consume la API pública:

* https://pokeapi.co/

Para obtener información real de los Pokémon.

---

## 🗄️ Base de datos

* MySQL
* Generación automática de tablas con Hibernate (`ddl-auto=update`)

---

## 🚀 Endpoints principales

### Trainers

* GET `/poke-app/trainers`
* POST `/poke-app/trainers`
* PUT `/poke-app/trainers/{id}`
* DELETE `/poke-app/trainers/{id}`

### Teams / Pokémon

* POST `/poke/teams/{teamId}/pokemon/{name}`

---

## 📌 Objetivo del proyecto

Este proyecto fue desarrollado con fines de aprendizaje para practicar:

* Backend con Spring Boot
* Consumo de APIs externas
* Arquitectura en capas
* Relación entre entidades
* Persistencia en base de datos

---

## 👨‍💻 Autor

Qkarman Desarrollador Backend Interesado en arquitectura limpia, lógica formal aplicada y diseño estructurado de sistemas.
