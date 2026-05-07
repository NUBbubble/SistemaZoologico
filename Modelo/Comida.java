package Modelo;
public class Comida {
    private String nombre,tipo;
    private int carbohidratos,proteinas,grasas;

    public Comida(String nombre, String tipo, int c, int p, int g){
        this.nombre=nombre;
        this.tipo=tipo;
        this.carbohidratos=c;
        this.proteinas=p;
        this.grasas=g;
    }
    
    public int getCarbohidratos() {
        return this.carbohidratos;
    }
    public int getGrasas() {
        return this.grasas;
    }
    public String getNombre() {
        return this.nombre;
    }
    public int getProteinas() {
        return this.proteinas;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setCarbohidratos(int carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
