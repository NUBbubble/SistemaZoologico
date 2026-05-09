package Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;

public class PrincipalView extends JFrame{
        private JPanel panelContenido;

        public PrincipalView(){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Gestion De Alimentacion - Zoologico ");
            setName("panelPrincipal"); 
            setPreferredSize(new java.awt.Dimension(1400, 800));
            setSize(getPreferredSize());
            getContentPane().setBackground(new Color(206, 225, 234));
            panelContenido=new JPanel(new BorderLayout());
            panelContenido.setBackground(new Color(206, 225, 234));
            add(panelContenido, BorderLayout.CENTER);
            Panel elpanel= new Panel();
            add(elpanel);
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

        public void mostrarPrincipal(){
            panelContenido.removeAll();
            JLabel texto=new JLabel("Vista Principal de prueba", SwingConstants.CENTER);
                texto.setFont(new Font("Segoe UI", Font.BOLD, 28));
                texto.setForeground(new Color(31,127,149));
            panelContenido.add(texto, BorderLayout.CENTER);
            panelContenido.revalidate();
            panelContenido.repaint();
        }

        public void mostrarAnimal(){
            panelContenido.removeAll();
            panelContenido.add(new AnimalView(), BorderLayout.CENTER);
            panelContenido.revalidate();
            panelContenido.repaint();
        }

        public void mostrarDietas(){
            panelContenido.removeAll();
            panelContenido.add(new DietasView(), BorderLayout.CENTER);
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
        public class Panel extends JPanel{
            public Panel(){

            }
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d= (Graphics2D)g;
                mostrarFondo(g2d);

            }
            public void mostrarFondo(Graphics2D g ){
                g.setColor(Color.WHITE);
                g.fillRect(40, 40, getWidth()-80, getHeight()-60);
            }
        }

}
