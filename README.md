# Spring Boot Rest API

## Compilación

Para compilar el proyecto se debe ejecutar el siguiente comando:

```bash
mvn clean install
```

## Ejecución

```bash	
mvn spring-boot:run
```

## Test con curl

```bash
curl -X GET http://localhost:8080/hello
```

## Test operación reverse

```bash
curl http://localhost:8080/reverse?input=hello
```

## Test remove-vowels

```bash
curl http://localhost:8080/remove-vowels?input=hello
```

## Ejecuta test unitarios

```bash
mvn test
```

## Containarización

### Contruir imagen

```bash
docker build -t demo0412 .
```

### Ejecutar contenedor

```bash
docker run -p 8080:8080 demo0412
```


