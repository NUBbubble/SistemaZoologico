package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import Modelo.Animal;

public class PrincipalView extends JFrame{
        public PrincipalView(){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Gestion De Alimentacion - Zoologico ");
            setName("panelPrincipal"); // NOI18N
            setPreferredSize(new java.awt.Dimension(1400, 800));
            setSize(getPreferredSize());
            getContentPane().setBackground(new Color(206, 225, 234));
            setVisible(true);
            add(new BarraLateralView(),BorderLayout.WEST);
            add(new MenuEncabezadoView(),BorderLayout.NORTH);
        }


}
