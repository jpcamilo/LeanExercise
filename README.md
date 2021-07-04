
[![Analytics](https://jpcamilo.github.io/)

## Ejercicio Practico 
Este es el desarrollo del ejercicio practico solicitado por XXXXX, se encuentra desarrollado en Spring Boot , con BD H2, se anexa la coleccion en Postman con las pruebas realizadas al servicio.

<h1 align="center"> Ejercicio Practico</h1>
<p align="center"><img src="https://cleventy.com/wp-content/uploads/2020/05/spring-boot.png"/></p> 

## Tabla de contenidos:
---

- [Descripcion y Contexto](#descripcion)
- [Consideracion de Negocio](#consideracion-de-negocio)
- [Guía de usuario](#guía-de-usuario)
- [Autor](#autor)
- [Información adicional](#información-adicional)
- [Licencia](#licencia)


## Descripcion
---
Se requiere realizar un proyecto en Spring Boot con una base de datos en H2(en memoria)
El proyecto debe tener las entidades Person, Employee y Position
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/Entidades.JPG"/></p> 
El servicio debe exponer una API Rest que permita hacer las siguientes operaciones:
-Crear Empleado
-Actualizar Empleado
- Listar todos los empleados (Este Endpoint debe permitir filtrar por cargo o nombre) estos parametros son opcionales, si no se envia alguno de estos, debe traer todos los empleados
-retornar una lista con todos los cargos y dentro de los cargos todos los empleados ordenados por salario de mayor a menor

## Consideracion de Negocio
---
Para el desarrollo de este servicio se asumieron las siguientes consideracion de negocio.
Se tomo como ejemplo que el servicio se fuera a utilizar en un bpm, para lo cual primero se definio que se se debe crear la persona en la entidad Candidato primero, al igual que se tienen que crear los cargos antes de crear el Empleado como tal, tambien se definio que el cargo tendria un nombre y codigo id unicos, Solo se permite en la actualizacion de empleado cambiar el id de la persona y el id del cargo.

## Guía de usuario
---
### Crear empleado
Se tiene que comenzar con la creacion de los cargos que se van a utilizar para los empleados, seguidamente se tiene que utilizar el servicio que crea a las personas (Candidatos), luego de esto se debe utilizar el servicio que crea los empleados y en el cual se asocia  el id de la persona y el id del cargo.
- Crear Cargo
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/CrearCargo.JPG"/></p> 
- Crear Candidato
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/CrearCandidato.JPG"/></p> 
- Crear Empleado
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/CrearEmpleado.JPG"/></p> 

### Eliminar empleado
Se tiene que consumir el servicio que elimina empleados y pasar el id del empleado a eliminar
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/EliminarEmpleado.JPG"/></p> 

### Actualizar empleado
Se tiene que pasar el id del empleado a actualizar y dentro del Body pasar los datos que se van a actualizar(id de la persona, id del cargo)
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/ActualizarEmpleado.JPG"/></p> 


### Listar empleado
Se tiene que consumir el servicio que lista los empleados, si no se pasa ningun parametro adicional este, listara todos los empleados, se pueden pasar los parametros "nombre" o "cargo" con lo cual filtrara y traera unicamente los empleados con el parametros definido
- Sin Filtro
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/ListarEmpleados.JPG"/></p> 
- Filtrado por Nombre
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/FiltrarNombre.JPG"/></p> 
- Filtrado po Cargo
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/FiltrarCargo.JPG"/></p> 

### Listar Cargos con los Empleados
Se tiene que consumir el servicio que lista los caros, el cual traera los empleados que tengan asociados a cada cargo en una lista
<p align="center"><img src="https://github.com/jpcamilo/LeanExercise/blob/main/img/ListarCargos.JPG"/></p> 

## Autor
---
Ejercicio realizado por:
Juan Camilo Pedraza Camelo
Ingeniero En Telecomunicaciones
Correo: jpcamilo407@gmail.com

## Información adicional
---
Ejercicio desarrollado con Spring Boot v2.5.2 y java 1.8

## Licencia 
---
Pendiente Definir