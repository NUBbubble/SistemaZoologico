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
    public void mostrarDietas(){
        for (JButton boton:botones){
            if ("Dietas".equals(boton.getText())){
                boton.addActionListener(e-> vistaPrincipal.mostrarDietas());
            }
        }
    }
        public void mostrarComida(){
        for (JButton boton:botones){
            if ("Comida".equals(boton.getText())){
                boton.addActionListener(e->vistaPrincipal.mostrarComida());
            }
        }
    }
        public void mostrarCuidadores(){
        for (JButton boton:botones){
            if ("Cuidador".equals(boton.getText())){
                boton.addActionListener(e->vistaPrincipal.mostrarCuidador());
            }
        }
    }
        public void mostrarReportes(){
        for (JButton boton:botones){
            if ("Reportes".equals(boton.getText())){
                boton.addActionListener(e->vistaPrincipal.mostrarReportes());
            }
        }
    }

}
