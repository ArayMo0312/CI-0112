import java.util.Scanner;
public class JuegoBatalla {

    Robot[] robots = new Robot[10];            //Arreglo de tipo robots, almacena robots
    private int cantidadRobots = 0;
    Scanner input = new Scanner(System.in);
    

    public void nuevoRobot(){
        if(cantidadRobots >= robots.length){
        System.out.println("La cantidad maxima de robots para la batalla se ha alcanzado");
        }
        else{
            System.out.println("Por favor a continuacion rellene los datos de su robot:");
            System.out.println();
            System.out.println("Nombre del robot:");
            System.out.println();

            String nombre = input.nextLine();

            System.out.println("Puntos de vida del robot (Min:50 | Max:100):");
            System.out.println();

            int ptsVida = input.nextInt();

            while(ptsVida < 50 || ptsVida > 100){
                System.out.println("El valor seleccionado se encuentra fuera de los parametros, intente nuevamnte: ");
                ptsVida = input.nextInt();
            }

            System.out.println("Puntos de ataque del robot (Min:10 | Max:20):");
            System.out.println();

            int ptsAtk = input.nextInt();

            while(ptsAtk < 10 || ptsAtk > 20){
                System.out.println("El valor seleccionado se encuentra fuera de los parametros, intente nuevamente: ");
                ptsAtk = input.nextInt();
            }

            System.out.println("Nuevo Robot creado con exito");
            System.out.println();
            System.out.println("Nombre: " + nombre + " | HP: " + ptsVida + " | ATK: " + ptsAtk);
            System.out.println();

            Robot newRobot = new Robot(nombre, ptsVida, ptsAtk, true); //Crear el Robot con los atributos dados por el usuario

        }
    }

    public void mostrarRobots(){

    }

    public void iniciarBatalla(){
        
    }
}