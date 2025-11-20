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

## 💫 Instrucciones de Instalación y Ejecución

1. Requisitos Previos

  - Asegúrate de tener instalado:

    - Java JDK 17 o superior
    - Apache NetBeans 12+
    - MySQL Server / XAMPP (phpMyAdmin)
    - MySQL Connector/J (ya incluido en el proyecto)
    - Git (opcional si clonas el repositorio)

2. Clonar o Descargar el Proyecto

   - Opción A: Clonar con Git
        ```bash
        git clone https://github.com/soofigonb/Luna-Reservas.git
        ```
   - Opción B: Descargar ZIP
     Repositorio → Code → Download ZIP
     Luego descomprímelo.

3. Importar el Proyecto en NetBeans

    1. Abrir NetBeans
    2. Ir a File → Open Project
    3. Seleccionar la carpeta Luna-Reservas
    4. Presionar Open

4. Importar la Base de Datos MySQL

    1. Abrir phpMyAdmin
    2. Crear la base de datos:
    3. Ir a la pestaña Importar
    4. Seleccionar el archivo SQL:
        ➡️ [reserva_horas.sql](reserva_horas.sql)
    5. Presionar Importar
  Esto creará automáticamente las tablas:

        - cliente
        - servicio
        - reserva

5. Verificar la Conexión JDBC

   - Ir al archivo:
      📄 src/bd/ConexionDB.java
     Asegúrate de que los datos coincidan con tu entorno local:

         private static final String URL = "jdbc:mysql://localhost:3306/reserva_horas";
         private static final String USER = "root";
         private static final String PASS = "";

6. Añadir el Conector MySQL

   - Botón derecho sobre el proyecto → Properties
   - Ir a Libraries → Add JAR/Folder
   - Seleccionar: 📁 mysql-connector-j-9.5.0.jar

7. Ejecutar la Aplicación

   - En NetBeans:

        1. Run → Run Project o presiona F6
        2. La aplicación abrirá la ventana principal, mostrando:

              - Gestión de Clientes
              - Gestión de Servicios
              - Gestión de Reservas

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

## 📦 Archivo de Base de Datos

Puedes importar la base de datos utilizando el archivo:  ➡️ [reserva_horas.sql](reserva_horas.sql)

## 👩‍💻 Autor

- Sofía González Barra
  





