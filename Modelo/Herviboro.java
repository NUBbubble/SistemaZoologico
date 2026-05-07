package Modelo;
public class Herviboro extends Animal{

    public Herviboro(String nombre, String especie,int p,int c,int g){
        super(nombre,especie,p,c,g);
    }
    @Override
    public String Alimentar(Comida comida){
        if (!aprobarAlimento(comida)){
            return "El animal " + getEspecie() + " no ha aceptado el alimento";
        }
        // Aplicar nutrientes
        super.proteinasCons += comida.getProteinas();
        super.carbohidratosCons += comida.getCarbohidratos();
        super.grasasCons += comida.getGrasas();
        super.caloriasCons += calcularCalorias(
            comida.getProteinas(),
            comida.getCarbohidratos(),
            comida.getGrasas()
        );
        // Evaluar saciedad
        if (super.caloriasCons >= super.getCaloriasReq()){
            super.setSaciado(true);
            return "Se ha saciado";
        } else {
            return "Aun sigue hambriento";
        }
    }
    @Override
    public String Alimentar(Dieta dieta){
        if (!aprobarAlimento(dieta)){
            return "El animal " + getEspecie() + " no ha aceptado el alimento";
        }
        for (Comida laComida : dieta.getComidas()){
            super.proteinasCons += laComida.getProteinas();
            super.carbohidratosCons += laComida.getCarbohidratos();
            super.grasasCons += laComida.getGrasas();
        }
        super.caloriasCons += dieta.CalcularCaloriasTotales();
            if ((super.caloriasCons>=super.getCaloriasReq())){
                super.setSaciado(true);
                return "Se ha saciado";
            }else{
                return "Aun sigue hambriento";
            }
        }
        @Override
    public boolean aprobarAlimento(Comida consumible){
        if ("herviboro".equals(consumible.getTipo()) && getSaciado()==false){
            return true;
        }else{
            return false;
        }
    }
        @Override
    public boolean aprobarAlimento(Dieta consumible){
        if ("omnivoro".equals(consumible.getTipo()) && getSaciado()==false){
            return true;
        }else{
            return false;
        }
    }


}
