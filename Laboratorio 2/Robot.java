
public class Robot {

    private String nombre;
    private int ptsVida;                //Entre 50 y 100 pts de vida
    private int ptsAtk;                 //Entre 10 y 20 pts de daño
    private boolean estado;


    public Robot(){}                    //Constructor Vacio

//getters
    public String getNombre() {
            return nombre;
    }
    public int getPtsVida() {
        return ptsVida;
}
    public int getAtk() {
        return ptsAtk;
}
    public boolean getEstado(){
        return estado;
    }

//Setters 

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPtsVida(int ptsVida){
        this.ptsVida = ptsVida;
    }
    public void setPtsAtk(int ptsAtk){
        this.ptsAtk = ptsAtk;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }

//Metodos 
    public void atacar(){

    }

    public void estado(int ptsVida){
        if(ptsVida>0){
            estado = true;
            System.out.println("EL ROBOT: " +   nombre + " SE ECUENTRA AÚN EN PIE!");
        }
        else{
            estado = false;
            System.out.println("EL ROBOT: " +   nombre + " CAYO EN BATALLA");

        }
    }
}
