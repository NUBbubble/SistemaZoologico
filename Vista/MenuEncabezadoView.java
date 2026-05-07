package Vista;
import java.awt.*;
import javax.swing.JPanel;

public class MenuEncabezadoView extends JPanel {
    public MenuEncabezadoView(){
        setPreferredSize(new Dimension(1400,81));
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;
        dibujarFondo(g2d);
    }
    public void dibujarFondo(Graphics2D g){
        g.setColor(new Color(31,127,149));
        g.fillRect(0,0,getWidth(),getHeight());
    }
    public void dibujarCuadricula(Graphics2D g){

        int ancho = getWidth();
        int alto = getHeight();

        // SUBDIVISIONES DE 10px

        g.setColor(new Color(70,70,70));

        for(int x = 0; x <= ancho; x += 10){
            g.drawLine(x, 0, x, alto);
        }

        for(int y = 0; y <= alto; y += 10){
            g.drawLine(0, y, ancho, y);
        }

        // LINEAS PRINCIPALES DE 50px

        g.setColor(new Color(160,160,160));

        for(int x = 0; x <= ancho; x += 50){
            g.drawLine(x, 0, x, alto);
        }

        for(int y = 0; y <= alto; y += 50){
            g.drawLine(0, y, ancho, y);
        }
    }
}