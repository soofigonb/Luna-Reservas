# 🌙✨ LunaReservas – Sistema de Gestión de Reservas
Java • MySQL • Swing • MVC • JDBC

## 💫 Descripción del Proyecto:

LunaReservas es una aplicación de escritorio diseñada para gestionar reservas de servicios de belleza.
Fue desarrollada con Java SE, utilizando Swing para la interfaz gráfica, JDBC para la conexión a MySQL y el patrón MVC para una arquitectura limpia y modular.

Este proyecto forma parte del Proyecto Final de Desarrollo Orientado a Objeto.

## 💫 Características Principales:

  - Gestión de Clientes
  - Agregar clientes
  - Actualizar información
  - Eliminar registros
  - Validación de correo
  - Control de duplicados

## 💫 Gestión de Servicios:

  - Registrar nuevos servicios
  - Editar precio, duración y tipo
  - Eliminar servicios
  - Validación de precio y duración
  - Evitar nombres duplicados

## 💫Gestión de Reservas:

  - Registrar reservas con fecha y hora
  - Modificar reservas existentes
  - Eliminar reservas
  - Validación de disponibilidad (no se permite doble reserva en la misma hora)
  - Estados: Pendiente, Confirmada, Cancelada
  - Combos cargados automáticamente desde BD

## 💫 Tecnologías Utilizadas:

  - ✨ Java SE 17
  - ✨ JDBC (MySQL)
  - ✨ Swing (UI)
  - ✨ Patrón MVC + DAO
  - ✨ MySQL 8

## 💫 Cómo Ejecutarlo:

1. Clonar el repositorio:
```bash
git clone https://github.com/soofigonb/Luna-Reservas.git
```

## 📁 Estructura del Proyecto

LunaReservas/
│── bd/
│   └── ConexionDB.java
│
│── controlador/
│   └── ControladorMenu.java
│
│── modelo/
│   ├── Cliente.java
│   ├── ClienteDAO.java
│   ├── Servicio.java
│   ├── ServicioDAO.java
│   ├── Reserva.java
│   └── ReservaDAO.java
│
│── vista/
│   ├── MenuPrincipal.java
│   ├── PanelCliente.java
│   ├── PanelServicio.java
│   └── PanelReserva.java
│
└── README.md

## Archivo de Base de Datos

Puedes importar la base de datos del proyecto utilizando el siguiente archivo:
Descargar aquí:


## 👩‍💻 Autor

- Sofía González Barra
  





