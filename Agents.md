# Documentación del Proyecto - Animales Zoo

## Situación Inicial

El sistema tenía un problema de sincronización entre la creación de animales y la barra lateral:

- **PrincipalSubController**:管理 la creación de animales y guarda los animales en `DefaultListModel<Animal> sensorAnimal`
- **AnimalSeleccion**: Creaba su propio `DefaultListModel<Animal>` separado e independiente
- **BarraLateralView**: Mostraba los animales pero no se actualizaba automáticamente al crear nuevos

Cuando se creaba un animal en `PrincipalView`, la barra lateral no reflejaba el nuevo animal porque cada componente tenía su propio modelo de datos independiente.

## Cambios Realizados

### 1. AnimalSeleccion.java (`Controlador/AnimalSeleccion.java`)

**Problema**: Cada instancia tenía su propio modelo independiente que no se sincronizaba con `PrincipalSubController`.

**Solución**: Se agregó un método `setModelo()` para recibir el modelo compartido desde `PrincipalSubController`:

```java
public void setModelo(DefaultListModel<Animal> modeloExterno) {
    this.modelo = modeloExterno;
    this.animales = new JList<>(modelo);
}
```

### 2. PrincipalController.java (`Controlador/PrincipalController.java`)

**Problema**: Se pasaban los animales por copia en lugar de compartir el modelo.

**Solución**: Se reordenó la creación para que `controladorPrincipal` se cree primero, luego se pasa su modelo a `controladorBarraLateral`:

```java
public PrincipalController(){
    controladorPrincipal = new PrincipalSubController();
    vistaPrincipal = new PrincipalView(controladorPrincipal);
    controladorBarraLateral = new AnimalSeleccion();
    controladorBarraLateral.setModelo(controladorPrincipal.getModeloAnimales());
    // ...
}

public void iniciar(){
    vistaPrincipal.agregarBarraLateral(new BarraLateralView(controladorBarraLateral));
    vistaPrincipal.agregarMenu(new MenuEncabezadoView(controladorMenu));
    vistaPrincipal.mostrarVentana();
}
```

### 3. PrincipalSubController.java (`Controlador/PrincipalSubController.java`)

**Cambio**: Se agregó un método getter para exponer el modelo de animales:

```java
public DefaultListModel<Animal> getModeloAnimales() {
    return sensorAnimal;
}
```

### 4. BarraLateralView.java (`Vista/BarraLateralView.java`)

**Problema**: No detectaba cambios en el modelo cuando se agregaban nuevos animales.

**Solución**: Se agregó un `ListDataListener` que detecta cambios en el modelo y actualiza automáticamente la barra lateral:

```java
public BarraLateralView(AnimalSeleccion controlador){
    setPreferredSize(new Dimension(WIDTH,800));
    this.controlador=controlador;
    this.listaAnimales = controlador.getAnimales();
    crearSelecciones(listaAnimales);
    listaAnimales.getModel().addListDataListener(new javax.swing.event.ListDataListener() {
        @Override
        public void intervalAdded(javax.swing.event.ListDataEvent e) {
            actualizarBarra();
        }
        @Override
        public void intervalRemoved(javax.swing.event.ListDataEvent e) {
            actualizarBarra();
        }
        @Override
        public void contentsChanged(javax.swing.event.ListDataEvent e) {
            actualizarBarra();
        }
    });
}

public void actualizarBarra() {
    removeAll();
    crearSelecciones(listaAnimales);
    revalidate();
    repaint();
}
```

## Flujo de Datos Actual

```
PrincipalSubController (sensorAnimal - modelo original)
        │
        ├──► getModeloAnimales()
        │            │
        ▼            ▼
AnimalSeleccion.setModelo() ─► comparten el mismo DefaultListModel
        │
        ▼
BarraLateralView (ListDataListener)
        │
        ▼
Cuando se agrega un animal en PrincipalSubController:
    sensorAnimal.addElement(nuevoAnimal)
        │
        ▼
    El ListDataListener detecta el cambio
        │
        ▼
    actualizarBarra() se ejecuta automáticamente
        │
        ▼
    La barra lateral muestra el nuevo animal
```

## Archivos Modificados

| Archivo | Cambios |
|---------|---------|
| `Controlador/AnimalSeleccion.java` | Agregado método `setModelo()` |
| `Controlador/PrincipalController.java` | Reordenado inicialización, ahora pasa el modelo compartido |
| `Controlador/PrincipalSubController.java` | Agregado método `getModeloAnimales()` |
| `Vista/BarraLateralView.java` | Agregado ListDataListener y método `actualizarBarra()` |

## Cómo Verificar

1. Ejecutar `Prueba.java`
2. En la vista principal, completar los campos del formulario (Nombre, Especie, Tipo, Requerimientos nutricionales)
3. Click en botón "Crear"
4. Verificar que el nuevo animal aparezca automáticamente en la barra lateral izquierda