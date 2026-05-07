package Modelo;
public class Cuidador{
    private String nombre;
    private String turno;
    public Cuidador(String nombre, String turno ){
        this.nombre=nombre;
        this.turno=turno;
    }
    public String alimentarAnimal(Dieta dietaEnviada, Animal animalEnviado){
        if (this.nombre!=null){
            return animalEnviado.Alimentar(dietaEnviada);
        }
        else{
            return "El Cuidador Ha sido Eliminado";
        }
    }
    public String getNombre() {
        return nombre;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public void clear(){
        this.nombre=null;
        this.turno=null;
    }
}