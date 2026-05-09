package Vista;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.MenuController;

public class MenuEncabezadoView extends JPanel {
    private final Color BACKGROUND=new Color(31,127,149);
    private final JPanel BarraSuperior=new JPanel();
    private final JPanel BarraOpciones=new JPanel();
    private MenuController controlador;
    public MenuEncabezadoView(MenuController controlador){
        this.controlador=controlador;
        setPreferredSize(new Dimension(1400,81));
        setLayout(new BorderLayout());
        titulo();
        crearBarraOpciones();
        add(BarraSuperior, BorderLayout.WEST);
        add(BarraOpciones, BorderLayout.CENTER);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;
        dibujarFondo(g2d);
    }
    public void dibujarFondo(Graphics2D g){
        g.setColor(BACKGROUND);
        g.fillRect(0,0,getWidth(),getHeight());
    }
    public void titulo(){
            BarraSuperior.setBackground(BACKGROUND);
            BarraSuperior.setLayout(new FlowLayout(FlowLayout.LEFT,10,  10));
        JLabel titulo=new JLabel("Zoologico") ;
            titulo.setFont(new Font("Segoe UI", 1, 36)); 
            titulo.setForeground(new Color(255, 255, 255));
        BarraSuperior.add(titulo);
    }
    public void crearBarraOpciones(){
        String[] opciones={"Principal","Dietas","Comida","Cuidador","Reportes"};
        BarraOpciones.setBackground(BACKGROUND);
        BarraOpciones.setLayout(new FlowLayout(FlowLayout.RIGHT,15,25));

        for(String opcion:opciones){
            JButton boton=new JButton(opcion);
                boton.setForeground(Color.WHITE);
                boton.setBackground(BACKGROUND);
                boton.setBorderPainted(false);
                boton.setFocusPainted(false);
                boton.setContentAreaFilled(false);
                boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                this.controlador.addButton(boton);
            BarraOpciones.add(boton);
        }
        controlador.mostrarPrincipal();
        controlador.mostrarDietas();
        controlador.mostrarComida();
        controlador.mostrarCuidadores();
        controlador.mostrarReportes();
    }
}
