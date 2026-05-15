package Controlador;
import Modelo.Animal;
import Vista.ReportesView;
import javax.swing.JPanel;
public class ReportesController {
    Animal animal;
    public ReportesController(){

    }
    public void setAnimal(Animal animal){
        this.animal=animal;
    }
    public JPanel mostrarReporteAnimal(){
        ReportesView reporte = new ReportesView(animal);
        return reporte;
    }
}
