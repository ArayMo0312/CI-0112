
public class Robot {

    private String nombre;
    private int ptsVida;                //Entre 50 y 100 pts de vida
    private int ptsAtk;                 //Entre 10 y 20 pts de daño
    private boolean estado;


    public Robot(String nombre, int ptsVida, int ptsAtk, boolean estado){

        this.nombre = nombre;
        this.ptsVida = ptsVida;
        this.ptsAtk = ptsAtk;
        this.estado = estado;

    }                    //Constructor 

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

//Metodos requeridos
    public void atacar(Robot Atacante, Robot Atacado){

        int vidaB = Atacado.getPtsVida(); //Tomo la vida del Robot Atacado

        int atkA = Atacante.ptsAtk;     //Tomo el ataque del Robot Atacante

        int vidaPostAtaque = vidaB - atkA; 

        Atacado.setPtsVida(vidaPostAtaque); // se le da la vida actualizada despues de ser atacado

        Atacado.estado();
    }

    public void estado(){
        if(ptsVida>0){
            estado = true;
            System.out.println("EL ROBOT: " +   nombre + " SE ECUENTRA AÚN EN PIE!"); //Si la vida es mayor que cero sigue con vida
        }
        else{
            estado = false;
            System.out.println("EL ROBOT: " +   nombre + " CAYO EN BATALLA"); //si non se anuncia si caida

        }
    }
}
