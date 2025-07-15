# Test Tech HLEON

##  Requisitos Previos

Antes de compilar o ejecutar el proyecto, asegúrate de tener instalado:

- **Maven**: versión **3.9.9**
- **Java**: versión **22 o inferior**
- Un sistema operativo compatible con scripts `.sh` (Linux, MACOS, o WSL en Windows)

> ⚠️ Java 23 o versiones superiores no están garantizadas para este proyecto.

---

## 🛠️ Compilación

1. Abre una terminal y **sitúate en la carpeta raíz del proyecto**:

   ```bash
   cd /ruta/a/tu/proyecto
   ```

2. Ejecuta el siguiente comando para compilar y construir el proyecto:

   ```bash
   ./mvnw clean install
   ```

   Este comando descargará las dependencias necesarias, compilará el código y ejecutará pruebas automáticas si están definidas.

---

## Ejecución

Una vez que el proyecto se haya compilado correctamente, ejecuta el script de inicio:

```bash
./start.sh
```

---

## Logs

Todos los logs generados por el servicio se almacenarán automáticamente en la carpeta:

```
logs/
```

Asegúrate de que esta carpeta exista y tenga permisos de escritura. Si no existe, el script o el mismo servicio debería crearla al iniciar.

---

##  Permisos (si es necesario)

Si tienes problemas al ejecutar los scripts, verifica los permisos:

```bash
chmod +x mvnw start.sh
```

---

##  Notas

- El proyecto se compila con perfil prod, pero al momento de correr puedes cambiar el perfil.
- Swagger: http://localhost:15050/swagger-ui
---
