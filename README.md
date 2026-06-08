![Placeholder](https://imgs.search.brave.com/UpyRdpMp-Rj9Dtg_HplcpXmvTIUIsB3eZ4hIejl8kqI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9yZXMu/Y2xvdWRpbmFyeS5j/b20vc3B5ZGVhbHMv/aW1hZ2UvdXBsb2Fk/L2NfbHBhZCxmX2F1/dG8saF8xMjUscV9h/dXRvLHdfMTI1L3Yx/L2Nkbi80M3VtaHFj/alJmUFEwMGR4UGVE/WVNtZTRiazg3aE5C/QVlNTkNCZFVSLndl/YnA)
#  Implementación catalogo de proveedores

Proyecto donde se hace uso frontend y backend para aplicativo de gestión de proveedores chapur

## Contenido
- giovannilopez-chapur-backend - Contiene el proyecto springboot para los proveedores chapur
- giovannilopez-chapur-frontend - Proyecto Angular para las pantallas del aplicativo

## Consideraciones
- backend:
	- Java 17
	- springboot 3.5
	- H2
- frontend:
	- Angular 17
	- Node.js 22

## Instrucciones
1- Para probar el backend, se puede realizar con el comando mvn spring-boot:run, dejando la siguiente ruta disponible: http://localhost:8080/api/v1/supplier-service
2- Levantar el frontend, se puede realizar con ng serve, y podra validarse en : http://localhost:4200/

## giovannilopez-chapur-backend
El proyecto de springboot, permite alta,consulta,listado y actualización de proveedores.
Se hace uso de H2 para la base de datos.
Cuenta con pruebas unitarias para la parte del dominio y aplicacion
swagger : http://localhost:8080/swagger-ui/index.html


## giovannilopez-chapur-frontend
Proyecto frontal para la visualización de los servicios proporcionados por el backend, usando la ruta expuesta como consumo dentro de los archivos.
El flujo corresponde a insertar datos de proveedor(nombre y pais), mismos que se desplegarán en la tabla al momento de enviar la petición.
Un id se genera por medio del back, y podrá visualizarse en el front.
La bandera de activo, permite la eliminación por medio de un cambio de estado, es decir; todos los proveedores listados deben tener esta bandera "activa", de lo contrario se marcarán como eliminados, pero no removidos de base de datos
Se incluye una paginación de 10 elementos por default.