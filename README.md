# Hospital - Sistema de Gestión de Médicos

Este proyecto es una pequeña aplicación de escritorio en Java usando Swing para administrar médicos en un hospital.

## Requisitos previos

Para ejecutar este proyecto necesitas tener instalado:

- **Java JDK 8 o superior**
  - Verifica tu versión: `java -version`
  - Descarga desde: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html

- **Apache Maven 3.6 o superior**
  - Verifica tu versión: `mvn -version`
  - Descarga desde: https://maven.apache.org/download.cgi

- **Git (opcional, si quieres clonar desde Git)**
  - Descarga desde: https://git-scm.com/

## Clonar el repositorio

### Usando Git

```bash
git clone https://github.com/ElMatatanCarlos09844/Hospital.git
cd Hospital
```

### Descargando como ZIP

1. Ve a https://github.com/ElMatatanCarlos09844/Hospital
2. Haz clic en el botón verde **"Code"**
3. Selecciona **"Download ZIP"**
4. Descomprime el archivo en tu computadora

## Contenido del proyecto

- `src/main/java/com/mycompany/hospital/Main.java`
  - Punto de entrada de la aplicación.
  - Inicia la interfaz gráfica y muestra la ventana principal.

- `src/main/java/com/mycompany/hospital/VentanaPrincipal.java`
  - Ventana principal con dos botones:
    - `Alta de Médicos`
    - `Consultar Médicos`
  - Contiene una lista compartida de médicos que se pasa a las demás ventanas.

- `src/main/java/com/mycompany/hospital/VentanaAltas.java`
  - Ventana para agregar un nuevo médico.
  - Valida que todos los campos estén completos.
  - Crea un objeto `Medico` y lo añade a la lista compartida.

- `src/main/java/com/mycompany/hospital/VentanaConsultas.java`
  - Ventana que muestra la lista de médicos en una tabla.
  - Lee los datos de la lista compartida y los muestra en `JTable`.

- `src/main/java/com/mycompany/hospital/Medico.java`
  - Clase simple que almacena los datos de un médico:
    - `cedula`
    - `nombre`
    - `sexo`
    - `especialidad`
    - `subEspecialidad`
    - `sueldo`

## Flujo general

1. El programa inicia en `Main.main()`.
2. Se abre `VentanaPrincipal`.
3. El usuario puede:
   - Registrar médicos en `VentanaAltas`.
   - Consultar médicos en `VentanaConsultas`.
4. Todos los datos se mantienen en memoria dentro de un `ArrayList<Medico>` mientras la aplicación está abierta.

## Ejecución

### Desde la línea de comandos con Maven

1. Abre una terminal en el directorio del proyecto:
   ```bash
   cd Hospital
   ```

2. Compila el proyecto:
   ```bash
   mvn clean compile
   ```

3. Ejecuta la aplicación:
   ```bash
   mvn exec:java -Dexec.mainClass="com.mycompany.hospital.Main"
   ```

### Desde tu IDE (NetBeans, Eclipse, IntelliJ IDEA)

1. **Abre el proyecto:**
   - Archivo → Abrir proyecto → Selecciona la carpeta `Hospital`

2. **Ejecuta la aplicación:**
   - Click derecho en el proyecto → Run
   - O presiona `Shift + F6` (NetBeans)

3. **Construye el proyecto:**
   - Click derecho en el proyecto → Build
   - O presiona `F11` (NetBeans)

## Diagrama del proyecto

![Diagrama del proyecto](docs/diagrama-proyecto.jpg)

## Diagrama de conexiones y flujo

![Diagrama de conexiones y flujo](docs/diagrama-conexiones.jpg)
