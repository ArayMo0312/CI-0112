import java.util.Scanner;
public class GUI {

    private int respuesta;
    Scanner input = new Scanner(System.in); //Scanner para la entrada del usuario

    JuegoBatalla juego = new JuegoBatalla();  //Crear un objeto del tipo juegoBatalla


    public int getRespuesta(){
        return respuesta;
    }

    public void Inicio(){                   //Interfaz de usuario

        while(respuesta != 4){
            System.out.println("---------------BATALLA DE ROBOTS---------------");
            System.out.println();
            System.out.println("              1.Crear nuevo robot              ");
            System.out.println("                 2.Ver robots                  ");
            System.out.println("              3.Iniciar batalla                ");
            System.out.println("                   4.Salir                     ");
            System.out.println();
            System.out.println("-----------------------------------------------");
            System.out.println();


            respuesta = input.nextInt();
            System.out.println();

            if(respuesta == 1){
                juego.nuevoRobot();         //Llama al metodo para crear un robot
            }
            if(respuesta == 2){
                juego.mostrarRobots();      //Llama al metodo para mostrar la lista de robots
            }   
            if(respuesta == 3){
                juego.iniciarBatalla();     //LLama al metodo para inciar la batalla
            }
            if(respuesta == 4){

                System.out.println("Gracias por jugar!");
                break;
            }
        }
    }
}
