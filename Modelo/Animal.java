package Modelo;
public abstract class Animal {
    private String nombre,especie;
    //Requeridos
    private int caloriasReq,proteinasReq,carbohidratosReq,grasasReq;

    private Dieta dieta;
    //Consumidso
    protected int caloriasCons,proteinasCons,carbohidratosCons,grasasCons;

    private boolean saciado=false;
    public Animal(String nombre, String especie,int p,int c, int g){
        this.nombre=nombre;
        this.especie=especie;
        this.proteinasReq=p;
        this.carbohidratosReq=c;
        this.grasasReq=g;
        this.caloriasReq=calcularCalorias(p, g, c);
    }
    public void DeterminarRequerimientosNutricionales(int prot, int gras,int carbs){
        int Calorias=calcularCalorias(prot, gras, carbs);
        this.caloriasReq=Calorias;
        this.proteinasReq=prot;
        this.carbohidratosReq=carbs;
        this.grasasReq=gras;
    }
    public int calcularCalorias(int prot,int gras,int carbs){
        return (prot*4)+(gras*9)+(carbs*4);
    }
    //Clases Abstractas 
    public abstract String Alimentar(Comida comida);
    public abstract String Alimentar(Dieta dieta);
    public abstract boolean aprobarAlimento(Comida consumible);
    public abstract boolean aprobarAlimento(Dieta dietaEnviada);
    //Getter And Setters
    //  Getters
    public int getCaloriasCons() {
        return caloriasCons;
    }
    public int getCaloriasReq() {
        return caloriasReq;
    }
    public int getCarbohidratosCons() {
        return carbohidratosCons;
    }
    public int getCarbohidratosReq() {
        return carbohidratosReq;
    }
    public Dieta getDieta() {
        return dieta;
    }
    public String getEspecie() {
        return especie;
    }
    public int getGrasasCons() {
        return grasasCons;
    }
    public int getGrasasReq() {
        return grasasReq;
    }
    public String getNombre() {
        return nombre;
    }
    public int getProteinasCons() {
        return proteinasCons;
    }
    public int getProteinasReq() {
        return proteinasReq;
    }
    public boolean getSaciado(){
        return this.saciado;
    }
    //  setters
    public void setCaloriasCons(int caloriasCons) {
        this.caloriasCons = caloriasCons;
    }
    public void setCaloriasReq(int caloriasReq) {
        this.caloriasReq = caloriasReq;
    }
    public void setCarbohidratosCons(int carbohidratosCons) {
        this.carbohidratosCons = carbohidratosCons;
    }
    public void setCarbohidratosReq(int carbohidratosReq) {
        this.carbohidratosReq = carbohidratosReq;
    }
    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public void setGrasasCons(int grasasCons) {
        this.grasasCons = grasasCons;
    }
    public void setGrasasReq(int grasasReq) {
        this.grasasReq = grasasReq;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setProteinasCons(int proteinasCons) {
        this.proteinasCons = proteinasCons;
    }
    public void setProteinasReq(int proteinasReq) {
        this.proteinasReq = proteinasReq;
    }
    public void setSaciado(boolean saciado) {
        this.saciado = saciado;
    }
}
