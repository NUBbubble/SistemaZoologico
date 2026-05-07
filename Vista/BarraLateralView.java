package Vista;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import Modelo.Animal;

public class BarraLateralView extends JPanel{
    public BarraLateralView(){
        setPreferredSize(new Dimension(300,800));
        crearSelecciones(null);
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
        JPanel 
        JButton Boton=new JButton("Leon");
        Boton.setPreferredSize(getPreferredSize());
        add(Boton);
    }
}
