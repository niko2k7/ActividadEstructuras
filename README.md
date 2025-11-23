# 🏥 UrgencyHeap — Sistema de Gestión de Pacientes por Prioridad  
### Proyecto de Estructuras de Datos — Universidad Nacional de Colombia

<p align="center">
  <img src="https://www.pngkey.com/png/detail/268-2688228_universidad-nacional-colombia-logo.png" width="230">
</p>

---

## 📌 Descripción del Proyecto

**UrgencyHeap** es una aplicación simple desarrollada en **Java + JavaFX** que permite gestionar pacientes en un servicio de urgencias utilizando una **cola de prioridad implementada con un MaxHeap**.

Cada paciente es registrado con su nombre, edad y síntomas.  
El sistema calcula una **prioridad** basada en los síntomas seleccionados y organiza la atención de forma óptima.

---

## 🗂️ Estructura del Proyecto
```text
C:.
│   .gitignore
│   pom.xml
│   README.md
│
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───Controllers
│   │   │   │       UrgenciaController.java
│   │   │   │
│   │   │   ├───Main
│   │   │   │       App.java
│   │   │   │
│   │   │   └───Models
│   │   │           MaxHeap.java
│   │   │           Nodo.java
│   │   │           Paciente.java
│   │   │
│   │   └───resources
│   │           estilos.css
│   │           urgencias.fxml
```

---

# 🛠️ Instalación de Dependencias

## ☕ JDK 24.0.1

🔗 Descargar:  
https://www.oracle.com/co/java/technologies/downloads/#jdk24-windows

1. Abrir **CMD**
2. Ejecutar:
```text
java --version
javac --version
```
3. Ambas deben mostrar la versión correcta del JDK.

---

## 🧱 Maven 3.9.11

🔗 Descargar:  
https://maven.apache.org/download.cgi  

Seleccionar **binary zip archive**.

### Instalación

1. Crear esta ruta si no existe:
```text
C:\Program Files\Apache\Maven
```
2. Descomprimir el zip aquí:
```text
C:\Program Files\Apache\Maven\apache-maven-3.9.11
```
3. Abrir:
**WIN + S → “Editar las variables de entorno del sistema”**
4. Clic en **Variables de entorno**
5. Editar **Path**
6. Agregar:
```text
C:\Program Files\Apache\Maven\apache-maven-3.9.11\bin
```
7. Aceptar todo
8. En CMD:


---

## 🖥️ Visual Studio Code

Instalar estas extensiones:

- **Java Extension Pack**
- **JavaFX Support**
- **Java**

---

# ▶️ Ejecución Local en VSCode

1. Abrir el proyecto en VSCode  
2. Verificar que existe el archivo `pom.xml`  
3. Abrir terminal (`Ctrl + Ñ`)  
4. Compilar:
```text
mvn clean compile
```
5. Ejecutar:
```text
mvn clean javafx:run
```

---

# 📦 Funcionalidades Principales

✔ Registro de pacientes  
✔ Selección de síntomas mediante CheckBoxes  
✔ Cálculo automático de prioridad  
✔ Gestión con **MaxHeap**  
✔ Tabla con lista de pacientes en espera  
✔ Interfaz gráfica con **JavaFX + FXML + CSS**

---

# 👨‍💻 Tecnologías Utilizadas

- Java 24  
- JavaFX  
- Maven  
- VSCode  
- Programación orientada a objetos  
- Estructura de datos **Heap (MaxHeap)**

---

# © Proyecto académico — Universidad Nacional de Colombia
