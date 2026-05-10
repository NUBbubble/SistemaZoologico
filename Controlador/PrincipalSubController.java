package Controlador;
import java.util.*;
import javax.swing.*;

import Modelo.*;
public class PrincipalSubController {
    //Datos del Animal
    private List<JTextField> datosAnimal;
    //Requerimientos Nutricionales
    private List<JTextField> datosReq;
    //Los cuidadores que Existen
    private List<Cuidador> cuidadores;
    //Cuidador Que se asignara
    private JList<Animal> animalesColeccion;
    private Cuidador cuidadorAsignado;
    private JComboBox<String> selectorTipo;
    DefaultListModel<Animal> sensorAnimal = new DefaultListModel<>();
    public PrincipalSubController(){
        datosAnimal = new ArrayList<>();
        datosReq = new ArrayList<>();
        cuidadores = new ArrayList<>();
        animalesColeccion = new JList<>(sensorAnimal);

        //Animales por Defecto
        Carnivoro leo = new Carnivoro("Leo", "León", 300, 50, 100);
        Omnivoro mel = new Omnivoro("Mel", "Osa", 200, 200, 100);
        Herviboro bambi = new Herviboro("Bambi", "Ciervo", 100, 400, 50);
        sensorAnimal.addElement(mel);
        sensorAnimal.addElement(bambi);
        sensorAnimal.addElement(leo);
    }
    public void listenerAgregacion(JButton boton){
        boton.addActionListener(e->{
            String nombreAnimal = datosAnimal.get(0).getText().trim();
            String especieAnimal = datosAnimal.get(1).getText().trim();
            String tipoAnimal = (String) selectorTipo.getSelectedItem();
            String proteinasReqStr = datosReq.get(0).getText().trim();
            String carbohidratosReqStr = datosReq.get(1).getText().trim();
            String grasasReqStr = datosReq.get(2).getText().trim();
            if (nombreAnimal.isEmpty() || especieAnimal.isEmpty() || tipoAnimal == null || tipoAnimal.isEmpty() ||
                proteinasReqStr.isEmpty() || carbohidratosReqStr.isEmpty() || grasasReqStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int proteinas, carbohidratos, grasas;
            try {
                proteinas = Integer.parseInt(proteinasReqStr);
                carbohidratos = Integer.parseInt(carbohidratosReqStr);
                grasas = Integer.parseInt(grasasReqStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos para los requerimientos nutricionales.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //crearAnimal
            Animal nuevoAnimal ;
            switch (tipoAnimal) {
                case "Carnivoro":
                    nuevoAnimal = new Carnivoro(nombreAnimal, especieAnimal, proteinas, carbohidratos, grasas);
                    break;
                case "Herviboro":
                    nuevoAnimal = new Herviboro(nombreAnimal, especieAnimal, proteinas, carbohidratos, grasas);
                    break;
                case "Omnivoro":
                    nuevoAnimal = new Omnivoro(nombreAnimal, especieAnimal, proteinas, carbohidratos, grasas);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo de animal no reconocido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
            //Añadir animal a Coleccion
            if (nuevoAnimal != null) {
                sensorAnimal.addElement(nuevoAnimal);
                JOptionPane.showMessageDialog(null, "Animal " + nombreAnimal + " agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // 5. Eliminar el texto ingresado
                for (JTextField textField : datosAnimal) {
                    textField.setText("");
                }
                for (JTextField textField : datosReq) {
                    textField.setText("");
                }
                selectorTipo.setSelectedIndex(0); 
            }
        });
    }
    public void listenOptionComida(JComboBox<String> combo){
        combo.addActionListener(e->{
            String cuidadorNombre=(String) combo.getSelectedItem();
            Cuidador cuidadorElegido=buscarCuidador(cuidadorNombre);
            if (cuidadorElegido!=null){
                this.cuidadorAsignado=cuidadorElegido;
            }
        });
    }
    private Cuidador buscarCuidador(String nombre){
        if (nombre==null){
            return null;
        }
        for (Cuidador cuidador:this.cuidadores){
            if (nombre.equals(cuidador.getNombre())){
                return cuidador;
            }
        }
        return null;
    }
    public void addTextFieldA(JTextField texto){
        datosAnimal.add(texto);
    }
    public void addTextFieldR(JTextField texto){
        datosReq.add(texto);
    }

    public void setSelectorTipo(JComboBox<String> selectorTipo) {
        this.selectorTipo = selectorTipo;
    }
    public JList<Animal> getAnimalesColeccion() {
        return animalesColeccion;
    }

    public DefaultListModel<Animal> getModeloAnimales() {
        return sensorAnimal;
    }
}
