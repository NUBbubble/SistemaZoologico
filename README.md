# Proyecto de Gestión de Animales del Zoologico

## Descripcion del Proyecto

Este es un proyecto de Programación Orientada a Objetos I (POO I) donde cree un sistema de gestion de alimentación de animales en un zoológico. El sistema permite registrar animales, asignarles dietas, crear comidas, y visualizar reportes detallados de cada animal.

El objetivo principal del proyecto fue aplicar los conceptos de POO que aprendí durante el semestre: clases abstractas, herencia, polimorfismo, encapsulamiento, y el patrón Modelo-Vista-Controlador (MVC).

---

## Funcionalidades Principales

### 1. Registro de Animales

Puedo crear nuevos animales ingresando los siguientes datos:
- **Nombre**: Identificador único del animal
- **Especie**: Especie a la que pertenece
- **Tipo**: Carnívoro, Herbívoro u Omnívoro
- **Requerimientos Nutricionales**: Proteínas, Carbohidratos y Grasas (en gramos)

El sistema automáticamente calcula las calorías requeridas usando la fórmula: `Calorías = (Proteínas × 4) + (Grasas × 9) + (Carbohidratos × 4)`

### 2. Tipos de Animales

El sistema implementa tres tipos de animales con comportamiento diferente para la alimentación:

- **Carnívoro**: Solo acepta alimentos de origen animal
- **Herbívoro**: Solo acepta alimentos de origen vegetal
- **Omnívoro**: Acepta ambos tipos de alimentos

Cada tipo implementa su propia lógica de validación de alimentos a través de métodos abstractos.

### 3. Gestión de Dietas

Puedo crear dietas personalizadas que contienen una lista de comidas. Cada dieta tiene:
- Nombre identificador
- Tipo de dieta
- Lista de comidas asociadas

El sistema calcula automáticamente las calorías totales de una dieta sumando los valores nutricionales de cada comida.

### 4. Creación de Comidas

Puedo registrar comidas con sus valores nutricionales:
- Nombre de la comida
- Tipo (Dieta Carnivora, Omnivora, Herbivora)
- Cantidad de proteínas, carbohidratos y grasas

### 5. Barra Lateral de Animales

En la parte izquierda de la interfaz se muestra una lista de todos los animales registrados. Esta lista se actualiza automáticamente cuando creo un nuevo animal.

### 6. Sistema de Reportes

Al hacer clic en el botón de un animal en la barra lateral, se muestra un reporte completo con:
- Datos del animal: Nombre, Especie, Tipo
- Requerimientos Nutricionales: Proteínas, Carbohidratos, Grasas, Calorías
- Estado: Si está saciado y la dieta asignada

---

## Estructura del Proyecto

El proyecto sigue el patrón **Modelo-Vista-Controlador (MVC)**:

---

## Cómo Ejecutar el Proyecto

1. Compilar todos los archivos Java:

2. Ejecutar el programa:
   ```bash
   java Prueba
   ```

---

## Interfaz Gráfica

La interfaz cuenta con:
- **Barra lateral izquierda**: Muestra la lista de animales registrados
- **Menú superior**: Navegación entre las diferentes secciones (Principal, Dietas, Comida, Cuidador, Reportes)
- **Panel central**: Área de trabajo donde se muestran los formularios y reportes

Los colores utilizados son:
- Fondo principal: Azul grisáceo (206, 225, 234)
- Títulos y encabezados: Verde azulado (31, 127, 149)
- Paneles de contenido: Blanco

---

## Funciones sin implementación

Actualmente, el proyecto tiene algunas funcionalidades que aún no están completamente implementadas:
- El sistema de cuidadores está en desarrollo
- La funcionalidad de alimentar animales no está completa

Algunas mejoras que me gustaría agregar en el futuro:
- Persistencia de datos (guardar en archivo o base de datos)
- Validación de alimentos más compleja
- Gráficos de nutrición
- Historial de alimentación por animal

---


## Creado Por Brayan Rojas Muñoz