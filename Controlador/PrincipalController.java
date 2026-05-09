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

    public PrincipalController(){
        vistaPrincipal=new PrincipalView();
        controladorBarraLateral=new AnimalSeleccion();
        controladorMenu=new MenuController(vistaPrincipal);
    }

    public void iniciar(){
        Animal[] animales={
            new Herviboro("Perolio","Herviboro",32,210,110),
            new Carnivoro("Simba","Carnivoro",80,60,45),
            new Omnivoro("Kiko","Omnivoro",45,120,30),
            new Herviboro("Lola","Herviboro",25,180,20),
            new Carnivoro("Max","Carnivoro",70,50,40)
        };

        controladorBarraLateral.addAnimales(animales);
        vistaPrincipal.agregarBarraLateral(new BarraLateralView(controladorBarraLateral));
        vistaPrincipal.agregarMenu(new MenuEncabezadoView(controladorMenu));
        vistaPrincipal.mostrarVentana();
    }
}
