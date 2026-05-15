package Controlador;

import Modelo.Animal;
import Vista.BarraLateralView;
import Vista.MenuEncabezadoView;
import Vista.PrincipalView;

public class PrincipalController {
    private PrincipalView vistaPrincipal;
    private AnimalSeleccion controladorBarraLateral;
    private MenuController controladorMenu;
    private DietasController controladorDietas;
    private PrincipalSubController controladorPrincipal;

    public PrincipalController(){
        controladorPrincipal = new PrincipalSubController();
        vistaPrincipal = new PrincipalView(controladorPrincipal);
        controladorBarraLateral = new AnimalSeleccion();
        controladorBarraLateral.setModelo(controladorPrincipal.getModeloAnimales());
        controladorBarraLateral.setVistaPrincipal(vistaPrincipal);
        controladorMenu = new MenuController(vistaPrincipal);
        controladorDietas = new DietasController();
        vistaPrincipal.setDietasController(controladorDietas);
        
    }

    public void iniciar(){
        vistaPrincipal.agregarBarraLateral(new BarraLateralView(controladorBarraLateral));
        vistaPrincipal.agregarMenu(new MenuEncabezadoView(controladorMenu));
        vistaPrincipal.mostrarVentana();
        vistaPrincipal.mostrarPrincipal();
    }
}
