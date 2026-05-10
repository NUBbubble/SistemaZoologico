package Modelo;
import java.util.List;
import java.util.ArrayList;
public class Dieta {
	private String nombre;
    private List<Comida> comidas;
	private String tipo;
    public Dieta(String nombre,String tipo){
		this.nombre=nombre;
		this.tipo=tipo;
		this.comidas=new ArrayList<>();
    }
    public List<Comida> obtenerMenu(){
		return this.comidas;
    }
	public void add(Comida comida){
		this.comidas.add(comida);
	}
    public int CalcularCaloriasTotales(){
		int grasasTotales=0,proteinasTotales=0,carbohidratosTotales=0;
		for (Comida laComida:comidas){
			grasasTotales+=laComida.getGrasas();
			proteinasTotales+=laComida.getProteinas();
			carbohidratosTotales+=laComida.getCarbohidratos();
		}
		return (proteinasTotales*4)+(grasasTotales*9)+(carbohidratosTotales*4);
    }

	public List<Comida> getComidas() {
		return comidas;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setComidas(List<Comida> comidas) {
		this.comidas = comidas;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
