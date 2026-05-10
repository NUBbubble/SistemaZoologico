package Controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import Modelo.Animal;

public class AnimalSeleccion {
    private List<JButton> botones;
    private List<Animal> animales;
    public AnimalSeleccion(){
        this.botones = new ArrayList<>();
        this.animales = new ArrayList<>();
    }
    public void addAnimales(Animal animalEnviado){
        animales.add(animalEnviado);
    }
    public void addAnimales(List<Animal> animales){
        this.animales=animales;
    }
    public void addAnimales(Animal[] animalesEnviados){
        for (Animal animal:animalesEnviados)
            animales.add(animal);
    }
    public void addButton(JButton boton){
        botones.add(boton);
    }
    public List<Animal> getAnimales() {
        return animales;
    }
    public List<JButton> getBotones() {
        return botones;
    }

}
