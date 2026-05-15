package Controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Modelo.Animal;
import Vista.PrincipalView;

public class AnimalSeleccion {
    private List<JButton> botones;
    private JList<Animal> animales;
    private DefaultListModel<Animal> modelo;
    private ReportesController controladorReport;
    private PrincipalView vistaPrincipal;

    public AnimalSeleccion() {
        this.botones = new ArrayList<>();
        this.modelo = new DefaultListModel<>();
        this.animales = new JList<>(modelo);
        this.controladorReport = new ReportesController();
    }
    public void setVistaPrincipal(PrincipalView vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }

    public void listenerButton() {
        for (int i = 0; i < botones.size(); i++) {
            int index = i;
            botones.get(index).addActionListener(e -> {
                String text = botones.get(index).getText();
                for (int j = 0; j < modelo.getSize(); j++) {
                    if (modelo.get(j).getNombre().equals(text)) {
                        controladorReport.setAnimal(modelo.get(j));
                        JPanel reportePanel = controladorReport.mostrarReporteAnimal();
                        vistaPrincipal.mostrarReporte(reportePanel);
                    }
                }
            });
        }
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
