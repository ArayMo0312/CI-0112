
public class Robot {

    private String nombre;
    private int ptsVida;                //Entre 50 y 100 pts de vida
    private int ptsAtk;                 //Entre 10 y 20 pts de daño
    private boolean estado;
    private int defensa;


    public Robot(String nombre, int ptsVida, int ptsAtk, boolean estado, int defensa){ //Constructor

        this.nombre = nombre;
        this.ptsVida = ptsVida;
        this.ptsAtk = ptsAtk;
        this.estado = estado;
        this.defensa = defensa;

    }                   

                                        //getters
    public String getNombre() {
            return nombre;
    }
    public int getPtsVida() {
        return ptsVida;
}
    public int getPtsAtk() {
        return ptsAtk;
}
    public boolean getEstado(){
        return estado;
    }
    public int getDefensa(){
        return defensa;
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
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }

//Metodos requeridos
    public void atacar(Robot Atacado){

        int vida = Atacado.getPtsVida(); //Tomo la vida del Robot Atacado
        int defensa = Atacado.getDefensa();

        int atk = this.ptsAtk - defensa;     //Tomo el ataque del Robot Atacante

        
        int vidaPostAtaque = vida - atk; 

        Atacado.setPtsVida(vidaPostAtaque); // se le da la vida actualizada despues de ser atacado

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
