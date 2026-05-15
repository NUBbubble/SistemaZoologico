package Vista;
import javax.swing.*;
import java.awt.*;
public class ComidaView extends JPanel{
        public ComidaView(){
        setLayout(new BorderLayout());
        setBackground(new Color(206, 225, 234));
        JLabel titulo=new JLabel("¡¡¡Comida esta en reparación :C !!!!", SwingConstants.CENTER);
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
            titulo.setForeground(new Color(31,127,149));
        add(titulo, BorderLayout.CENTER);
    }
}
