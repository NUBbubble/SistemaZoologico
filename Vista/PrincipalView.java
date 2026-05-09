package Vista;

import javax.swing.JFrame;
import java.awt.*;
import Modelo.Animal;
import Modelo.Carnivoro;
import Modelo.Herviboro;
import Modelo.Omnivoro;
import Controlador.AnimalSeleccion;

public class PrincipalView extends JFrame{
        public PrincipalView(){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Gestion De Alimentacion - Zoologico ");
            setName("panelPrincipal"); // NOI18N
            setPreferredSize(new java.awt.Dimension(1400, 800));
            setSize(getPreferredSize());
            getContentPane().setBackground(new Color(206, 225, 234));
            AnimalSeleccion ControladorBarraLateral=new AnimalSeleccion();
            
            Animal[] animales={
                new Herviboro("Perolio","Herviboro",32,210,110),
                new Carnivoro("Simba","Carnivoro",80,60,45),
                new Omnivoro("Kiko","Omnivoro",45,120,30),
                new Herviboro("Lola","Herviboro",25,180,20),
                new Carnivoro("Max","Carnivoro",70,50,40)
            };
            ControladorBarraLateral.addAnimales(animales);
            add(new BarraLateralView(ControladorBarraLateral),BorderLayout.WEST);
            add(new MenuEncabezadoView(),BorderLayout.NORTH);
            setVisible(true);
        }


}
