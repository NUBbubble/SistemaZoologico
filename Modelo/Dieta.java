package Modelo;

public class Dieta {
    private Comida[] comidas;
	private String tipo;
    public Dieta(Comida[] comidas,String tipo){
		this.comidas=comidas;
		this.tipo=tipo;
    }
    public Comida[] obtenerMenu(){
		return this.comidas;
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

	public Comida[] getComidas() {
		return comidas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setComidas(Comida[] comidas) {
		this.comidas = comidas;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
