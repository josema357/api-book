## Descripcion
API rest que permite reservar una casa, para lo cual se debe recibir un request,
validar dicho request, si se indica algún código de descuento validarlo a través de una api rest.
## Requisitos
Requisitos previos necesarios para ejecutar la API:
- `JDK 17`
- `Gradle`
- `Docker`
- `Postman`
- `VsCode`
## Instalacion
### Clonar el Repositorio
- `git clone https://github.com/josema357/api-book.git`
- `cd api-book/`
- `code .`
### Configuracion del Entorno
#### Usando Docker
- Crea el archivo `.env`
- Este es un ejemplo para llenar este archivo: 
```
DB_URL=jdbc:postgresql://java_db:5432/book
DB_USERNAME=postgres
DB_PASSWORD=postgres
DISCOUNT_URL=api-rest-de-descuento

PGADMIN_EMAIL=admin@mail.com
PGADMIN_PASSWORD=admin
```
- Ejecuta el build  ->  `./gradlew build -x test`
- Inicia la aplicacion con Docker  ->  `docker-compose up`
#### Sin Docker
- Crea el archivo launch.json, en la pestaña `Run > Add Configuration > Java`
- Configura las variables de entorno, a continuacion tienes un ejemplo:
```
    {
      "type": "java",
      "name": "BookApplication",
      "request": "launch",
      "mainClass": "com.josema.book.BookApplication",
      "projectName": "book_",
      "env": {
        "DB_URL": "jdbc:postgresql://localhost:5432/book",
        "DB_USERNAME": "postgres",
        "DB_PASSWORD": "tu_password",
        "DISCOUNT_URL": "https://api-rest-de-descuento/"
      }
    }
```
- Ejecuta el `BooApplication.java`. Debes crear la base de datos `book`, la aplicacion creara automaticamente la tabla. 
### EndPoint
#### Reservar un casa
Book
- Ruta: `http://localhost:4000/bideafactory/book`
- Metodo: `POST`
- Content-Type: `application/json`
- Body: 
```
      {
        "id": "14564088-4",
        "name": "Gonzalo",
        "lastname": "Pérez",
        "age": 33,
        "phoneNumber": "56988123222",
        "startDate": "2022-03-04",
        "endDate": "2022-03-04",
        "houseId": "213132",
        "discountCode": "D0542A23"
      }
```
