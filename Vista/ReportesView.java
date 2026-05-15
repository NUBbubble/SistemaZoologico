package Vista;
import java.awt.*;
import javax.swing.*;
import Modelo.Animal;
import Modelo.Dieta;

public class ReportesView extends JPanel {
    private Animal animalDrawing;
    private final Color BACKGROUND = new Color(206, 225, 234);
    private final Color TITLE_BG = new Color(31, 127, 149);

    public ReportesView(Animal animal) {
        this.animalDrawing = animal;
            setLayout(new BorderLayout());
            setBackground(BACKGROUND);
            setBorder(BorderFactory.createEmptyBorder(35, 150, 40, 150));
        crearReporte();
    }

    public ReportesView() {
        setLayout(new BorderLayout());
        JPanel panel=new JPanel(new GridLayout(20,1));
            panel.setBackground(BACKGROUND);
        JLabel titulo=new JLabel("¡¡¡Elige tu Animal a la izquierda !!!", SwingConstants.CENTER);
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
            titulo.setForeground(new Color(31,127,149));
        JLabel comentario=new JLabel("Sigo En Reparación :C", SwingConstants.CENTER);
            comentario.setFont(new Font("Segoe UI", Font.BOLD, 28));
            comentario.setForeground(new Color(31,127,149));
        panel.add(titulo);
        panel.add(comentario);
        add(panel, BorderLayout.CENTER);
        
    }

    private void crearReporte() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 0, 10));
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(900, 620));

        panel.add(tittle("Reporte del Animal"));
        panel.add(tituloSeccion("Datos del Animal"));
        panel.add(crearCampo("Nombre", animalDrawing.getNombre()));
        panel.add(crearCampo("Especie", animalDrawing.getEspecie()));
        panel.add(crearCampo("Tipo", animalDrawing.getTipo()));

        panel.add(tituloSeccion("Requerimientos Nutricionales"));
        panel.add(crearCampo("Proteínas Req.  (g)", String.valueOf(animalDrawing.getProteinasReq())));
        panel.add(crearCampo("Carbohidratos Req. (g)", String.valueOf(animalDrawing.getCarbohidratosReq())));
        panel.add(crearCampo("Grasas Req. (g)", String.valueOf(animalDrawing.getGrasasReq())));
        panel.add(crearCampo("Calorías Req.", String.valueOf(animalDrawing.getCaloriasReq())));

        panel.add(tituloSeccion("Estado"));
        panel.add(crearCampo("¿Saciado?", animalDrawing.getSaciado() ? "Sí" : "No"));
        Dieta dieta = animalDrawing.getDieta();
        String dietaTexto = (dieta != null) ? dieta.getNombre() : "Sin dieta asignada";
        panel.add(crearCampo("Dieta", dietaTexto));

        add(panel, BorderLayout.CENTER);
    }

    private JPanel tittle(String texto) {
        JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(TITLE_BG);
            panel.setPreferredSize(new Dimension(900, 50));
        JLabel titulo = new JLabel(texto);
            titulo.setFont(new Font("Segoe UI", 1, 28));
            titulo.setForeground(Color.WHITE);
            titulo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(titulo, BorderLayout.WEST);
        return panel;
    }

    private JPanel tituloSeccion(String texto) {
        JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(TITLE_BG);
            panel.setPreferredSize(new Dimension(900, 40));
        JLabel titulo = new JLabel(texto);
            titulo.setFont(new Font("Segoe UI", 1, 20));
            titulo.setForeground(Color.WHITE);
            titulo.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        panel.add(titulo, BorderLayout.WEST);
        return panel;
    }

    private JPanel crearCampo(String nombre, String valor) {
        JPanel apartado = crearPanelFormato();
        
        JLabel titulo = new JLabel(nombre);
            titulo.setPreferredSize(new Dimension(250, 20));
            titulo.setFont(new Font("Arial", Font.BOLD, 14));
            titulo.setForeground(new Color(45, 55, 52));
            titulo.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel valorLabel = new JLabel(valor);
            valorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            valorLabel.setForeground(new Color(85, 95, 92));
            valorLabel.setHorizontalAlignment(SwingConstants.LEFT);

            apartado.add(titulo, BorderLayout.WEST);
            apartado.add(valorLabel, BorderLayout.CENTER);
        
        return apartado;
    }

    private JPanel crearPanelFormato() {
        return crearPanelFormato(6, 18, 6, 18);
    }

    private JPanel crearPanelFormato(int top, int left, int bottom, int right) {
        JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(45, 55, 52)),
                BorderFactory.createEmptyBorder(top, left, bottom, right)
            ));
        return panel;
    }

    public void setAnimal(Animal animal) {
        this.animalDrawing = animal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(BACKGROUND);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public JPanel getPanel() {
        return this;
    }
}