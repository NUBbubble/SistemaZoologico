package Vista;

import javax.swing.*;

import Modelo.Cuidador;
import Controlador.DietasController;
import Controlador.PrincipalSubController;

import java.awt.*;

public class PrincipalView extends JFrame{
    private JPanel panelContenido;
    private JComboBox<String> selectorCuidadores;
    private JComboBox<String> selectorTipo;
    private DietasController dietasController;
    private PrincipalSubController controlador;

        public PrincipalView(PrincipalSubController controlador){
            this.controlador=controlador;
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Gestion De Alimentacion - Zoologico ");
            setName("panelPrincipal"); 
            setPreferredSize(new java.awt.Dimension(1400, 800));
            setSize(getPreferredSize());
            getContentPane().setBackground(new Color(206, 225, 234));
            panelContenido=new JPanel(new BorderLayout());
            panelContenido.setBackground(new Color(206, 225, 234));
            add(panelContenido, BorderLayout.CENTER);
            
        }
        public void agregarBarraLateral(BarraLateralView barraLateral){
            add(barraLateral,BorderLayout.WEST);
        }
        public void agregarMenu(MenuEncabezadoView menuEncabezado){
            add(menuEncabezado,BorderLayout.NORTH);
        }
        public void mostrarVentana(){
            setVisible(true);
        }
        public void setDietasController(DietasController dietasController){
            this.dietasController=dietasController;
        }
        public void mostrarPrincipal(){
            panelContenido.removeAll();
            JPanel areaFormulario=new JPanel(new BorderLayout());
                areaFormulario.setBackground(new Color(206, 225, 234));
                areaFormulario.setBorder(BorderFactory.createEmptyBorder(35,150,40,150));
                areaFormulario.add(solicitarDatosAnimal(), BorderLayout.NORTH);
            panelContenido.add(areaFormulario, BorderLayout.CENTER);
            panelContenido.revalidate();
            panelContenido.repaint();
        }

        public JPanel solicitarDatosAnimal(){
            JPanel panel=new JPanel(new GridLayout(11,1,0,10));
            panel.setOpaque(false);
            panel.setPreferredSize(new Dimension(900,620));
            String[] Apartados={"Nombre","Especie"};
            String[] reqNutricionales={"Proteínas Req.  (g)","Carbohidratos Req. (g)","Grasas Req. (g)"};
                
            panel.add(tittle("Datos Del Animal"));
            for(String datosAnimal: Apartados){
                panel.add(crearApartadoAnimals(datosAnimal));
            }
            panel.add(crearSelectorTipo());
            panel.add(tittle("Requerimientos Nutricionales"));
            for (String datosNutri:reqNutricionales)
                // 
                panel.add(crearApartadoReq(datosNutri));
            panel.add(tittle("Cuidador Asignado"));
            panel.add(crearSelectorCuidadores());
            panel.add(agregarButton());

            return panel;
        }
        //Solo guarda los JTextFields en DatosAnimal
        public JPanel crearApartadoAnimals(String nombre){
            JPanel apartado=crearPanelFormato();
                //Creacion del titulo(Apartado)
                JLabel titulo=new JLabel(nombre);
                    //formato
                    titulo.setPreferredSize(new Dimension(250,20));
                    titulo.setFont(new Font("Arial", Font.BOLD, 14));
                    titulo.setForeground(new Color(45,55,52));
                    titulo.setHorizontalAlignment(SwingConstants.LEFT);
                //creacion de Input al usuario(Texto en blanco)
                JTextField TextoBlanco=new JTextField(20);
                    TextoBlanco.setHorizontalAlignment(SwingConstants.LEFT);

                    //Añadirlo al controlador
                    controlador.addTextFieldA(TextoBlanco);
                //añadir al panel a retornar
                apartado.add(titulo, BorderLayout.WEST);
                apartado.add(TextoBlanco, BorderLayout.CENTER);
            return apartado;
        }
        //Solo guarda los JTextFields en DatosReq. SIendo los requerimientos nutricionales
        public JPanel crearApartadoReq(String nombre){
            JPanel apartado=crearPanelFormato();
                //Creacion del titulo(Apartado)
                JLabel titulo=new JLabel(nombre);
                    //formato
                    titulo.setPreferredSize(new Dimension(250,20));
                    titulo.setFont(new Font("Arial", Font.BOLD, 14));
                    titulo.setForeground(new Color(45,55,52));
                    titulo.setHorizontalAlignment(SwingConstants.LEFT);
                //creacion de Input al usuario(Texto en blanco)
                JTextField TextoBlanco=new JTextField(20);
                    TextoBlanco.setHorizontalAlignment(SwingConstants.LEFT);

                    //Añadirlo al controlador
                    controlador.addTextFieldR(TextoBlanco);
                //añadir al panel a retornar
                apartado.add(titulo, BorderLayout.WEST);
                apartado.add(TextoBlanco, BorderLayout.CENTER);
            return apartado;
        }
        public JPanel agregarButton(){
            JPanel panel=crearPanelFormato();
            JButton boton=new JButton("Crear");
                boton.setPreferredSize(new Dimension(1,20));
                boton.setBackground(new Color(31,127,149));
                boton.setBorderPainted(false);
                boton.setFocusPainted(false);
                boton.setContentAreaFilled(false);
                boton.setHorizontalAlignment(SwingConstants.LEFT);
                boton.setFont(new Font("Arial", Font.BOLD, 12));
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                controlador.listenerAgregacion(boton);
            panel.add(boton);
            return panel;
        }
        public JPanel crearSelectorCuidadores(){
            JPanel apartado=crearPanelFormato();
            JLabel titulo=new JLabel("Cuidador");
                titulo.setPreferredSize(new Dimension(250,20));
                titulo.setFont(new Font("Arial", Font.BOLD, 14));
                titulo.setForeground(new Color(45,55,52));
                titulo.setHorizontalAlignment(SwingConstants.LEFT);
            selectorCuidadores=new JComboBox<>();
                selectorCuidadores.addItem("Seleccione un cuidador");

            apartado.add(titulo, BorderLayout.WEST);
            apartado.add(selectorCuidadores, BorderLayout.CENTER);
            return apartado;
        }

        public JPanel crearSelectorTipo(){
            JPanel apartado=crearPanelFormato();
            JLabel titulo=new JLabel("Tipo");
                titulo.setPreferredSize(new Dimension(250,20));
                titulo.setFont(new Font("Arial", Font.BOLD, 14));
                titulo.setForeground(new Color(45,55,52));
                titulo.setHorizontalAlignment(SwingConstants.LEFT);
            selectorTipo=new JComboBox<>();
                selectorTipo.addItem("Carnivoro");
                selectorTipo.addItem("Herviboro");
                selectorTipo.addItem("Omnivoro");
                controlador.setSelectorTipo(selectorTipo);

            apartado.add(titulo, BorderLayout.WEST);
            apartado.add(selectorTipo, BorderLayout.CENTER);
            return apartado;
        }

        public void cargarCuidadores(Cuidador[] cuidadores){
            selectorCuidadores.removeAllItems();
            selectorCuidadores.addItem("Seleccione un cuidador");
            for(Cuidador cuidador:cuidadores){
                selectorCuidadores.addItem(cuidador.getNombre());
            }
        }
        public JPanel crearPanelFormato(){
            return crearPanelFormato(6,18,6,18);
        }
        public JPanel crearPanelFormato(int top, int left,int bottom, int right){
            JPanel panel= new JPanel(new BorderLayout());
                panel.setBackground(Color.WHITE);
                panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(45,55,52)),
                    BorderFactory.createEmptyBorder(top,left,bottom,right)
                ));
            return panel;
        }
        public JPanel tittle(String texto){
            JPanel panel= new JPanel();
                panel.setBackground(new Color(31,127,149));
                panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,  10));
            JLabel titulo=new JLabel(texto);
                titulo.setFont(new Font("Segoe UI", 1, 28)); 
                titulo.setForeground(new Color(255, 255, 255));

            panel.add(titulo,BorderLayout.WEST);
            return panel;
        }
        //Vinculacion

        public void mostrarDietas(){
            panelContenido.removeAll();
            panelContenido.add(new DietasView(dietasController), BorderLayout.CENTER);
            panelContenido.revalidate();
            panelContenido.repaint();
        }

        public void mostrarComida(){
            panelContenido.removeAll();
            panelContenido.add(new ComidaView(), BorderLayout.CENTER);
            panelContenido.revalidate();
            panelContenido.repaint();
        }

        public void mostrarCuidador(){
            panelContenido.removeAll();
            panelContenido.add(new CuidadoresView(), BorderLayout.CENTER);
            panelContenido.revalidate();
            panelContenido.repaint();
        }

        public void mostrarReportes(){
            panelContenido.removeAll();
            panelContenido.add(new ReportesView(), BorderLayout.CENTER);
            panelContenido.revalidate();
            panelContenido.repaint();
        }
        public void mostrarReporte(JPanel reporte){
            panelContenido.removeAll();
            panelContenido.add(reporte, BorderLayout.CENTER);
            panelContenido.revalidate();
            panelContenido.repaint();
        }
        public void añadirPanel(JPanel panel){
            add(panel);
        }
}
