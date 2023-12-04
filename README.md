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

## Despliegue en AKS (Azure Kubernetes Service)

### Environment variables

```bash
export RESOURCE_GROUP=aks-demo-alb-rg
export CLUSTER_NAME=demo
export NAMESPACE=demo0412
```

### Obtener credenciales

```bash
az aks get-credentials --resource-group $RESOURCE_GROUP --name $CLUSTER_NAME
```

### Crear namespace

```bash
kubectl create namespace $NAMESPACE
```

### Desplegar aplicación

```bash
kubectl apply -f k8s/application.yaml -n $NAMESPACE
```

### Obtener IP pública

```bash
export SVC_IP=$(kubectl get svc demo-copilot-0412 -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
```

### Test

```bash
curl http://$SVC_IP/hello
```