package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListDataEvent;
import java.util.List;
import Modelo.Animal;

import Controlador.AnimalSeleccion;

public class BarraLateralView extends JPanel{
    private final int WIDTH=300;
    private final int ALTURA_DE_SELECCION=30,ALTURA_DE_BOTON=20;
    private final Color BACKGROUND=new Color(220,230,228);
    private AnimalSeleccion controlador;
    private JList<Animal> listaAnimales;

    public BarraLateralView(AnimalSeleccion controlador){
        setPreferredSize(new Dimension(WIDTH,800));
        this.controlador=controlador;
        this.listaAnimales = controlador.getAnimales();
        crearSelecciones(listaAnimales);
        listaAnimales.getModel().addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                actualizarBarra();
            }
            @Override
            public void intervalRemoved(ListDataEvent e) {
                actualizarBarra();
            }
            @Override
            public void contentsChanged(ListDataEvent e) {
                actualizarBarra();
            }
        });
    }

    public void actualizarBarra() {
        removeAll();
        crearSelecciones(listaAnimales);
        revalidate();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;
        crearFondo(g2d);
    }
    public void crearFondo(Graphics2D g){
        g.setColor(BACKGROUND);
        g.fillRect(0,0,getWidth(),getHeight());
    }
    public void crearSelecciones(JList<Animal> misAnimales) {
        ListModel<Animal> modelo = misAnimales.getModel();
        int cantidad = modelo.getSize();

        JPanel panel = new JPanel(new GridLayout(cantidad, 1, 0, 5)); 
            panel.setPreferredSize(new Dimension(WIDTH, (cantidad * 50))); 
            for (int i = 0; i < cantidad; i++) {
                Animal animal = modelo.getElementAt(i);
                panel.add(crearSeleccion(animal));
            }
        controlador.listenerButton();
        add(panel); 
        revalidate();
        repaint();
    }
    public JPanel crearSeleccion(Animal animal) {
        JPanel seleccion = new JPanel(new GridLayout(1, 2));
            seleccion.setPreferredSize(new Dimension(WIDTH, ALTURA_DE_SELECCION)); 
            seleccion.setBackground(Color.WHITE);
            seleccion.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(185, 200, 197)),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
            ));

        JButton boton = new JButton(animal.getNombre());
            boton.setPreferredSize(new Dimension(1,ALTURA_DE_BOTON));
            boton.setBackground(Color.WHITE);
            boton.setBorderPainted(false);
            boton.setFocusPainted(false);
            boton.setContentAreaFilled(false);
            boton.setHorizontalAlignment(SwingConstants.LEFT);
            boton.setFont(new Font("Arial", Font.BOLD, 12));
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        controlador.addButton(boton);

        JLabel especie = new JLabel(animal.getEspecie());
            especie.setPreferredSize(new Dimension((WIDTH/3)*2,ALTURA_DE_BOTON)); 
            especie.setOpaque(true);
            especie.setBackground(Color.WHITE);
            especie.setForeground(new Color(85, 95, 92));
            especie.setFont(new Font("Arial", Font.PLAIN, 12));
            especie.setHorizontalAlignment(SwingConstants.RIGHT);
            seleccion.add(boton);
            seleccion.add(especie);

        return seleccion;
    }
}

