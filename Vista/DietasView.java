package Vista;

import java.awt.*;

import javax.swing.*;

import Modelo.Comida;
import Controlador.DietasController;

public class DietasView extends JPanel {
    private JComboBox<String> selectorTipo;
    private JComboBox<String> selectorComida;
    private DefaultListModel<String> modeloComidasAgregadas;
    private DietasController controlador;
    private final Color TITTLE_COLOR=new Color(31,127,149);
    private final Color BORDER_COLOR=new Color(185,200,197);
    private final Color TEXT_COLOR=new Color(45,55,52);

    public DietasView(DietasController controlador){
        this.controlador=controlador;
        setLayout(new BorderLayout());
        setBackground(new Color(206, 225, 234));
        setBorder(BorderFactory.createEmptyBorder(35,150,40,150));
        add(solicitarDatosAnimal(),BorderLayout.CENTER);
    }

    public JPanel solicitarDatosAnimal(){
        JPanel panel=new JPanel(new GridLayout(10,1,0,10));
            panel.setOpaque(false);
            panel.setPreferredSize(new Dimension(900,620));
        panel.add(tittle("Creacion De Dietas"));
        panel.add(crearFormulario("Nombre De Dieta", 20));
        panel.add(crearSelectorTipo());

        JLabel nutricionInf=crearLabelInformacionNutricional();
        panel.add(crearSelectorComida(nutricionInf));
        panel.add(crearInformacionNut(nutricionInf));
        panel.add(tittle("Comidas Agregadas"));
        panel.add(crearListaComidasAgregadas());
        panel.add(agregarComidaButton());
        return panel;
    }

    public JPanel crearFormulario(String nombre, int col){
        JPanel panel=crearPanelFormato();
        JLabel titulo=crearLabelCampo(nombre);
        JTextField textoBlanco=new JTextField(col);
            textoBlanco.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(titulo, BorderLayout.WEST);
        panel.add(textoBlanco, BorderLayout.CENTER);
        return panel;
    }

    public JPanel tittle(String texto){
        JPanel panel= new JPanel();
            panel.setBackground(TITTLE_COLOR);
            panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JLabel titulo=new JLabel(texto);
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
            titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        return panel;
    }

    public JPanel crearSelectorTipo(){
        JPanel apartado=crearPanelFormato();
        JLabel titulo=crearLabelCampo("Tipo");
        selectorTipo=new JComboBox<>();
            selectorTipo.addItem("Carnivoro");
            selectorTipo.addItem("Herviboro");
            selectorTipo.addItem("Omnivoro");

        apartado.add(titulo, BorderLayout.WEST);
        apartado.add(selectorTipo, BorderLayout.CENTER);
        return apartado;
    }

    public JPanel crearSelectorComida(JLabel informacionNutricional){
        JPanel apartado=crearPanelFormato();
        JLabel titulo=crearLabelCampo("Comida");
        selectorComida=new JComboBox<>();
        for (Comida comida:controlador.getComidas()){
            selectorComida.addItem(comida.getNombre());
        }
        controlador.listenOptionComida(selectorComida,informacionNutricional);
        apartado.add(titulo, BorderLayout.WEST);
        apartado.add(selectorComida, BorderLayout.CENTER);
        return apartado;
    }

    public JLabel crearLabelInformacionNutricional(){
        JLabel informacion=new JLabel("Seleccione una comida para ver sus nutrientes");
            informacion.setFont(new Font("Arial", Font.BOLD, 14));
            informacion.setForeground(TEXT_COLOR);
            informacion.setHorizontalAlignment(SwingConstants.LEFT);
        return informacion;
    }

    public JLabel labelInfNut(){
        return crearLabelInformacionNutricional();
    }

    public JLabel crearLabelCampo(String texto){
        JLabel titulo=new JLabel(texto);
            titulo.setPreferredSize(new Dimension(250,20));
            titulo.setFont(new Font("Arial", Font.BOLD, 14));
            titulo.setForeground(TEXT_COLOR);
            titulo.setHorizontalAlignment(SwingConstants.LEFT);
        return titulo;
    }

    public JPanel crearPanelFormato(){
        return crearPanelFormato(6,18,6,18);
    }

    public JPanel crearPanelFormato(int top, int left,int bottom, int right){
        JPanel panel= new JPanel(new BorderLayout());
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR),
                BorderFactory.createEmptyBorder(top,left,bottom,right)
            ));
        return panel;
    }

    public JPanel crearInformacionNut(JLabel label){
        JPanel panel=crearPanelFormato();
            panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public JPanel crearListaComidasAgregadas(){
        JPanel panel=crearPanelFormato();
        modeloComidasAgregadas=new DefaultListModel<>();
        JList<String> lista=new JList<>(modeloComidasAgregadas);
            lista.setFont(new Font("Arial", Font.PLAIN, 13));
            lista.setVisibleRowCount(3);
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);
        return panel;
    }

    public JPanel agregarComidaButton(){
        JPanel panel=crearPanelFormato(0,18,0,18);
        JButton boton=new JButton("Anadir Comida");
            boton.setPreferredSize(new Dimension(160,28));
            boton.setBackground(TITTLE_COLOR);
            boton.setForeground(Color.WHITE);
            boton.setFocusPainted(false);
            boton.setFont(new Font("Arial", Font.BOLD, 12));
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        controlador.listenAgregarComida(boton,selectorComida,modeloComidasAgregadas);
        panel.add(boton, BorderLayout.LINE_END);
        return panel;
    }
}
