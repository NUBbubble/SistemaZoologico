package Controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Modelo.Animal;

public class AnimalSeleccion {
    private List<JButton> botones;
    private JList<Animal> animales;
    private DefaultListModel<Animal> modelo;

    public AnimalSeleccion() {
        this.botones = new ArrayList<>();
        this.modelo = new DefaultListModel<>();
        this.animales = new JList<>(modelo);
    }

    public void setModelo(DefaultListModel<Animal> modeloExterno) {
        this.modelo = modeloExterno;
        this.animales = new JList<>(modelo);
    }

    public void addAnimales(Animal animalEnviado) {
        modelo.addElement(animalEnviado);
    }

    public void addAnimales(JList<Animal> lista) {
        ListModel<Animal> modeloRecibido = lista.getModel();
        for (int i = 0; i < modeloRecibido.getSize(); i++) {
            Animal animal = modeloRecibido.getElementAt(i);
            this.modelo.addElement(animal);
        }
    }

    public void setListaAnimales(JList<Animal> animalesEnviados) {
        this.animales = animalesEnviados;
        if (animalesEnviados.getModel() instanceof DefaultListModel) {
            this.modelo = (DefaultListModel<Animal>) animalesEnviados.getModel();
        }
    }

    public void addAnimales(Animal[] animalesEnviados) {
        for (Animal animal : animalesEnviados) {
            modelo.addElement(animal);
        }
    }

    public void addButton(JButton boton) {
        botones.add(boton);
    }

    public JList<Animal> getAnimales() {
        return animales;
    }

    public List<JButton> getBotones() {
        return botones;
    }
}
