package Vista;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Modelo.Animal;
import Modelo.Herviboro;

public class BarraLateralView extends JPanel{
    private final int WIDTH=300;
    private final int ALTURA_DE_SELECCION=30,ALTURA_DE_BOTON=20; 
    public BarraLateralView(){
        setPreferredSize(new Dimension(WIDTH,800));
        Herviboro perolio  =new Herviboro("Perolio","Herviboro",32,210,110);
        Animal[] elanimal={perolio};
        crearSelecciones(elanimal);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;
        crearFondo(g2d);
    }
    public void crearFondo(Graphics2D g){
        g.setColor(new Color(220,230,228));
        g.fillRect(0,0,getWidth(),getHeight());
    }
    public void crearSelecciones(Animal[] misAnimales){
        JPanel panel= new JPanel(new GridLayout(misAnimales.length,1));
        panel.setPreferredSize(new Dimension(WIDTH,(misAnimales.length*50)));
        
        for (Animal animal:misAnimales){
            JPanel seleccion=new JPanel(new GridLayout(1, 2));
            seleccion.setPreferredSize(new Dimension(WIDTH, ALTURA_DE_SELECCION));
                seleccion.setBackground(new Color(220,230,228));
                seleccion.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
            //Creacion de botones
            JButton boton=new JButton(animal.getNombre());
                boton.setPreferredSize(new Dimension(1,ALTURA_DE_BOTON));
                boton.setBackground(new Color(220,230,228));
            //Creacion Del Texto Especie
            JLabel especie= new JLabel(animal.getEspecie());
                especie.setPreferredSize(new Dimension((WIDTH/3)*2,ALTURA_DE_BOTON));
                especie.setBackground(new Color(220,230,228));
                especie.setHorizontalAlignment(SwingConstants.RIGHT);
            seleccion.add(boton);
            seleccion.add(especie);
            panel.add(seleccion);
        }
    }

}

