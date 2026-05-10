package Controlador;

import Modelo.Animal;
import Modelo.Carnivoro;
import Modelo.Herviboro;
import Modelo.Omnivoro;
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
        vistaPrincipal=new PrincipalView(controladorPrincipal);
        controladorBarraLateral=new AnimalSeleccion();
        controladorMenu=new MenuController(vistaPrincipal);
        controladorDietas=new DietasController();
        controladorPrincipal=new PrincipalSubController();
        vistaPrincipal.setDietasController(controladorDietas);
    }

    public void iniciar(){
        controladorBarraLateral.addAnimales(controladorPrincipal.getAnimalesColeccion());
        vistaPrincipal.agregarBarraLateral(new BarraLateralView(controladorBarraLateral));
        vistaPrincipal.agregarMenu(new MenuEncabezadoView(controladorMenu));
        vistaPrincipal.mostrarVentana();
    }
}
