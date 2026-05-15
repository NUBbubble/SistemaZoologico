package Vista;
import java.awt.*;
import javax.swing.*;
public class CuidadoresView extends JPanel{
        public CuidadoresView(){
        setLayout(new BorderLayout());
        setBackground(new Color(206, 225, 234));
        JLabel titulo=new JLabel("Cuidadores esta en reparación :C !!!!", SwingConstants.CENTER);
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
            titulo.setForeground(new Color(31,127,149));
        add(titulo, BorderLayout.CENTER);
    }
}
