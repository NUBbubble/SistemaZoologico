package Controlador;

import java.util.List;

import javax.swing.*;

import java.util.ArrayList;
import Modelo.Comida;
import Modelo.Dieta;
public class DietasController{
    private List<Comida> comidas;
    private Dieta dietaActual;
    public DietasController(){
        this.comidas = new ArrayList<>();
        Comida pollo=new Comida("Pollo","Carnivoro",10,32,10);
        Comida lechuga=new Comida("Lechuga","Herviboro",12,2,1);
        Comida fruta=new Comida("Fruta","Omnivoro",25,1,1);
        comidas.add(pollo);
        comidas.add(lechuga);
        comidas.add(fruta);
        this.dietaActual=new Dieta("Dieta temporal","Carnivoro");
    }
    public List<Comida> getComidas(){
        return comidas;
    }
    public void listenOptionComida(JComboBox<String> combo,JLabel label){
        combo.addActionListener(e->{
            String seleccion=(String) combo.getSelectedItem();
            Comida comida=buscarComida(seleccion);
            if (comida!=null){
                label.setText(comida.getDatosNut());
            }
        });
    }

    public void listenAgregarComida(JButton boton,JComboBox<String> selectorComida,DefaultListModel<String> modeloLista){
        boton.addActionListener(e->{
            String seleccion=(String) selectorComida.getSelectedItem();
            Comida comida=buscarComida(seleccion);
            if (comida!=null){
                dietaActual.add(comida);
                modeloLista.addElement(comida.getNombre()+" - "+comida.getDatosNut());
            }
        });
    }

    private Comida buscarComida(String nombre){
        if (nombre==null){
            return null;
        }
        for (Comida comida:this.comidas){
            if (nombre.equals(comida.getNombre())){
                return comida;
            }
        }
        return null;
    }
}
