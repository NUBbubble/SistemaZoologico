package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AnimalView extends JPanel {
    public AnimalView(){
        setLayout(new BorderLayout());
        setBackground(new Color(206, 225, 234));
        JLabel titulo=new JLabel("Vista Animales de prueba", SwingConstants.CENTER);
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
            titulo.setForeground(new Color(31,127,149));
        add(titulo, BorderLayout.CENTER);
    }
}
