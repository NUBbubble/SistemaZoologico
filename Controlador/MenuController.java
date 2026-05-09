package Controlador;

import java.util.List;
import java.util.ArrayList;

import javax.swing.*;

import Vista.PrincipalView;

public class MenuController{
    private List<JButton> botones;
    private PrincipalView vistaPrincipal;
    public MenuController(PrincipalView vistaPrincipal){
        this.botones = new ArrayList<>();
        this.vistaPrincipal = vistaPrincipal;
    }
    public void addButton(JButton boton){
        this.botones.add(boton);
    }
    public void mostrarPrincipal(){
        for(JButton boton:botones){
            if ("Principal".equals(boton.getText())){
                boton.addActionListener(e -> vistaPrincipal.mostrarPrincipal());
            }
        }
    }
    public void mostrarAnimales(){
        for (JButton boton:botones){
            if ("Animales".equals(boton.getText())){
                boton.addActionListener(e-> vistaPrincipal.mostrarAnimal());
            }
        }   
    }
    public void mostrarDietas(){
        for (JButton boton:botones){
            if ("Dietas".equals(boton.getText())){
                boton.addActionListener(e-> vistaPrincipal.mostrarDietas());
            }
        }
    }
        public void mostrarComida(){
        for (JButton boton:botones){
            if ("Animal".equals(boton.getText())){
                
            }
        }
    }
        public void mostrarCuidadores(){
        for (JButton boton:botones){
            if ("Animal".equals(boton.getText())){
                
            }
        }
    }
        public void mostrarReportes(){
        for (JButton boton:botones){
            if ("Animal".equals(boton.getText())){
                
            }
        }
    }

}
