# API de Canchas de Fútbol - Provincia de Buenos Aires

Esta API REST permite gestionar la información de canchas de fútbol en la provincia de Buenos Aires. Los usuarios pueden acceder a la información de las canchas, filtrarlas por diversas categorías (como ciudad, tipo o tamaño) y obtener detalles específicos como la ubicación y contacto.

## Cómo utilizar la API

Esta API está hospedada en **Render** y no es necesario configurar nada localmente para acceder a ella. Solo necesitas realizar peticiones a los endpoints que se describen a continuación.

### Documentación interactiva de la API

Para una visualización interactiva de los endpoints disponibles, puedes acceder a la documentación de la API a través de **Swagger** en la siguiente URL:

[https://canchasba-api.onrender.com/swagger-ui/index.html#/](https://canchasba-api.onrender.com/swagger-ui/index.html#/)

Swagger proporciona una interfaz gráfica donde podrás ver todos los endpoints disponibles, sus parámetros, y hacer peticiones directamente desde la web para probar la API en tiempo real.


### URL Base

La URL base para acceder a la API es:  
`https://canchasba-api.onrender.com/api/v1/`

### Endpoints

## 1: Obtener información de una cancha por ID

### URL:
`GET https://canchasba-api.onrender.com/api/v1/cancha/{id}`

### Descripción:
Este endpoint devuelve la información detallada de una cancha en base al `ID` proporcionado. La respuesta incluye datos como el nombre, la dirección, la ciudad, la zona, el teléfono, la cantidad de canchas, el tipo de superficie, el tamaño, la calificación y si la cancha es un colaborador.

### Respuesta exitosa:
```json
{
  "message": "",
  "object": {
    "id": 4,
    "name": "AIRE LIBRE",
    "address": "CALLE 137 E/ 74 Y 75",
    "city": "LA PLATA",
    "zone": "SUR",
    "phone": "(0221) 450-2125 / CEL",
    "quantity": "8",
    "type": "SINTETICO",
    "size": "5 Y 7",
    "rating": null,
    "collaborator": false
  }
}
```
### Parametros:
* id (Path variable): El identificador único de la cancha.
### Respuestas:
* 200 OK: Devuelve los detalles de la cancha solicitada.
* 404 Not Found: Si no se encuentra la cancha con el ID especificado.


## 2: Actualizar cancha

### URL:
`PUT https://canchasba-api.onrender.com/api/v1/cancha/{id}`

### Descripción:
Este endpoint actualiza la informacion de una cancha en base al `ID` proporcionado.
### Request Body ejemplo
``` json

{
  "name": "string",
  "address": "string",
  "city": "string",
  "zone": "string",
  "phone": "string",
  "quantity": "string",
  "type": "string",
  "size": "string",
  "rating": "string",
  "collaborator": true
  }
```


### Respuesta exitosa:
``` La respuesta incluye un mensaje con la confirmacion de `UPDATED` y los datos de la cancha actualizada como el nombre, la dirección, la ciudad, la zona, el teléfono, la cantidad de canchas, el tipo de superficie, el tamaño, la calificación y si la cancha es un colaborador. ```

### Parametros:
* id (Path variable): El identificador único de la cancha.
* "name": `NOMBRE DE LA CANCHA`
* "address": `DIRECCION DE LA CANCHA`
* "city": `CIUDAD`
* "zone": `LA ZONA DE LA PROVINCIA DONDE SE ENCUENTRA (NORTE, SUR, OESTE, PROVINCIA)`
* "phone": `NUMERO TELEFONICO`
* "quantity": `CANTIDAD DE CANCHAS`
* "type": `TIPO DE SUELO DE LAS CANCHAS`
* "size": `EL NUMERO DE JUGADORES QUE PUEDEN JUGAR EN LAS CANCHAS (5, 7, Y/O 11)`
* "rating": `LA VALORACION DE LA CANCHA`
* "collaborator": `SI ES COLABORADOR DE LA WEB (SISTEMA DE RECOMENDACION Y PUBLICIDAD POR PAGO)`
  
### Respuestas:
* 201 OK: Devuelve los detalles de la cancha actualizada.
* 404 Not Found: "Record not found in DB " -> Si no se encuentra la cancha con el ID especificado.


## 3: Agregar una cancha

### URL:
`POST https://canchasba-api.onrender.com/api/v1/cancha`

### Descripción:
Este endpoint agrega una cancha a la base de datos. 

### Request Body ejemplo
``` json

{
  "name": "string",
  "address": "string",
  "city": "string",
  "zone": "string",
  "phone": "string",
  "quantity": "string",
  "type": "string",
  "size": "string",
  "rating": "string",
  "collaborator": false
  }
```
### Respuesta exitosa:
``` La respuesta incluye un mensaje con la confirmacion de `SAVE` y los datos de la cancha actualizada como el ID asignado, nombre, la dirección, la ciudad, la zona, el teléfono, la cantidad de canchas, el tipo de superficie, el tamaño, la calificación y si la cancha es un colaborador. ```


## 4: Filtrar canchas

### URL:
`GET https://canchasba-api.onrender.com/api/v1/filter`

### Descripción:
Este endpoint filtra las canchas que cumplan con los parametros solicitados

### Parametros:

* "city": `CIUDAD`
* "type": `TIPO DE SUELO DE LAS CANCHAS`
* "size": `EL NUMERO DE JUGADORES QUE PUEDEN JUGAR EN LAS CANCHAS (5, 7, Y/O 11)`

### ejemplo:
* city = pacheco
* type = sintetico
* size = 5

### Respuesta:
``` json
{
  "message": "",
  "object": [
    {
      "id": 98,
      "name": "CLUB PACHECO",
      "address": "SANTIAGO DEL ESTERO 185",
      "city": "PACHECO",
      "zone": "NORTE",
      "phone": "0221 470-5436",
      "quantity": "2",
      "type": "SINTETICO",
      "size": "5",
      "rating": null,
      "collaborator": false
    },
    {
      "id": 279,
      "name": "LA BARRACA",
      "address": "AV. DE LOS CONSTITUYENTES 851",
      "city": "PACHECO",
      "zone": "NORTE",
      "phone": "02254 - 404001",
      "quantity": "4",
      "type": "SINTETICO",
      "size": "5",
      "rating": null,
      "collaborator": false
    }
  ]
}
```
### Respuesta exitosa:
``` La respuesta incluye los datos de la cancha que cumplen con el filtro ```


## 5: Busqueda por nombre

### URL:
`GET https://canchasba-api.onrender.com/api/v1/filterByName`

### Descripción:
Este endpoint devuelve todas las canchas que contengan en su nombre las palabras que se indican.

### ejemplo:
* name = "central"
  
### Respuesta:
``` json
{
  "message": "",
  "object": [
    {
      "id": 64,
      "name": "CENTRAL FUTBOL - SEDE BARRA NORTE",
      "address": "BOULOGNE SUR MER 2308",
      "city": "DON TORCUATO",
      "zone": "NORTE",
      "phone": "3973-3875",
      "quantity": "2",
      "type": "SINTETICO",
      "size": "5",
      "rating": null,
      "collaborator": false
    },
    {
      "id": 83,
      "name": "CLUB CENTRAL BUENOS AIRES",
      "address": "AV. EVA PERON 13280 (RUTA 53)",
      "city": "FLORENCIO VARELA",
      "zone": "SUR",
      "phone": "15-5182-6071",
      "quantity": "7",
      "type": "CESPED",
      "size": "7 Y 11",
      "rating": null,
      "collaborator": false
    },
    {
      "id": 334,
      "name": "MARANGONI FUTBOL Y DEPORTE - SEDE CENTRAL (PALERMO)",
      "address": "JUNCAL 3131",
      "city": "PALERMO",
      "zone": "CABA",
      "phone": "4804-0524 / 1962",
      "quantity": "1",
      "type": "SINTETICO",
      "size": "5",
      "rating": null,
      "collaborator": false
    }
  ]
}
```
### Respuesta exitosa:
``` La respuesta incluye los datos de las canchaa que cumplen con la busqueda.```


## 6: Obtener todas las ciudades

### URL:
`GET https://canchasba-api.onrender.com/api/v1/cities`

### Descripción:
Este endpoint devuelve todos los nombres de la ciudades que estan alojadas en la base de datos

### Respuesta exitosa:
```json
{
  "message": "",
  "object": [
    "ABASTO",
    "ACASSUSO",
    "ADROGUE",
    "AGRONOMIA",
    "ALMAGRO",
.................
  ]
}
```
`NOTA: se utiliza desde un front para poder usar un filtro de ciudades que se mantenga actualizado automaticamente con la base de datos.`

## 7: Obtener TODAS las canchas

### URL:
`GET https://canchasba-api.onrender.com/api/v1/canchas`

### Descripción:
Este endpoint devuelve todos los datos de todas las canchas que estan alojadas en la base de datos

### Respuesta exitosa:
```json
{
  "message": "",
  "object":  {
  {
      "id": 98,
      "name": "CLUB PACHECO",
      "address": "SANTIAGO DEL ESTERO 185",
      "city": "PACHECO",
      "zone": "NORTE",
      "phone": "0221 470-5436",
      "quantity": "2",
      "type": "SINTETICO",
      "size": "5",
      "rating": null,
      "collaborator": false
    },
    ........ resto de canchas......
}
```

## 8: Eliminar una cancha por ID

### URL:
`DELETE https://canchasba-api.onrender.com/api/v1/canchadelete/{id}`

### Descripción:
Este endpoint ELIMINA la cancha en base al `ID` proporcionado. 


### Parametros:
* id (Path variable): El identificador único de la cancha.
### Respuestas:
* 200 OK.
* 405 Entidad nula.


## Configuración de la Base de Datos
La API está conectada a una base de datos PostgreSQL alojada en un entorno seguro en Render. No es necesario que los usuarios configuren una base de datos local para utilizar la API.

## Variables de Entorno
Las siguientes variables de entorno son configuradas en Render para acceder a la base de datos:

+ DB_URL: URL de la base de datos PostgreSQL.
+ DB_USERNAME: Usuario de la base de datos.
+ DB_PASSWORD: Contraseña de la base de datos.
No es necesario que el usuario modifique estas variables para consumir la API, ya que el entorno de Render se encarga de la configuración automática.

## Despliegue
El código fuente está hospedado en Render, por lo que no es necesario hacer una instalación local. Puedes realizar peticiones directamente a los endpoints disponibles.

## Licencia
Este proyecto está bajo la Licencia MIT. 



