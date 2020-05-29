# calculadora
Microservicio "calculadora"

Pasos necesarios para generar el jar:

1. Asegurarse de que tracer.jar está instalado en el repositorio de local de maven.

Ejecutar el siguiente comando en caso contrario
```
mvn install:install-file -Dfile=<carpeta_donde_esta_el_jar>/tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar
```

2. Situarse en la carpeta raíz del respositorio git y ejecutar el comando 
```
mvn spring-boot:run
```

3. En un navegador acceder a la url de abajo para probar los endpoints
```
http://localhost:8080/calculadora-service/swagger-ui.html
```