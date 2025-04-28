import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla {
 
    Robot[] robots = new Robot[10];                  //Arreglo de tipo robots, almacena robots
    private int cantidadRobots = 0;
    Scanner input = new Scanner(System.in);


    //Metodos de esta clase
    
    private int robotsEnPie(){                      //Metodo para devolver la cantidad de robots aun con vida
            int vivos = 0;

            for(int i = 0; i < cantidadRobots; i++){

                if(robots[i].getEstado()){
                    vivos++;
                }
            }
            return vivos;
    }

    private int robotRandom(){

        Random randomR = new Random();
        int indice;
        do {
            indice = randomR.nextInt(cantidadRobots); //elige un numero al azar entre 0 y la catidad de robots que hayan
        }
        while(!robots[indice].getEstado());          //si el estado del robot es false repite

        return indice;
    }

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

            while(ptsVida < 50 || ptsVida > 100){           //Se asegura de que se encuentre en el rango especificado
                System.out.println("El valor seleccionado se encuentra fuera de los parametros, intente nuevamnte: ");
                ptsVida = input.nextInt();
            }
            input.nextLine();

            System.out.println("Puntos de ataque del robot (Min:10 | Max:20):");
            System.out.println();

            int ptsAtk = input.nextInt();

            while(ptsAtk < 10 || ptsAtk > 20){              //Se asegura de que se encuentre en el rango especificado
                System.out.println("El valor seleccionado se encuentra fuera de los parametros, intente nuevamente: ");
                ptsAtk = input.nextInt();
            }
            input.nextLine();

            System.out.println("Puntos de defensa del robot (Min:0 | Max:10):");
            System.out.println();

            int defensa = input.nextInt();

            while(defensa < 0 || defensa > 10){              //Se asegura de que se encuentre en el rango especificado
                System.out.println("El valor seleccionado se encuentra fuera de los parametros, intente nuevamente: ");
                defensa = input.nextInt();
            }
            input.nextLine();

            System.out.println("Nuevo Robot creado con exito");
            System.out.println();
            System.out.println("Nombre: " + nombre + " | HP: " + ptsVida + " | ATK: " + ptsAtk + " | DEF: " + defensa);
            System.out.println();

            Robot robot = new Robot(nombre, ptsVida, ptsAtk, true, defensa); //Crear el Robot con los atributos dados por el usuario
            
            robots[cantidadRobots] = robot;                                //Agragarlo al arreglo
            
            cantidadRobots ++;                                             //Aumentar cantidad de robots en 1
        }
    }

    public void mostrarRobots(){
        System.out.println("----------Lista de Robots----------");       //Metodo sencillo que recorre el arreglo de robots y muestra sus parametros
        System.out.println();                                               

        for(int i = 0; i < cantidadRobots; i++){
            System.out.println("Robot " + i+1 + "| Nombre: " + robots[i].getNombre() + "| HP: " + robots[i].getPtsVida() + "| ATK: " + robots[i].getPtsAtk() + "| DEF: " + robots[i].getDefensa());
            System.out.println();
        }
    }

    public void iniciarBatalla(){
        
        if(cantidadRobots < 2){                                             //Se asegura de que hayan suficientes jugadores para empezar
            System.out.println("Se necesitan mas de dos robots en la arenapara iniciar una batalla");
            return;
        }
        System.out.println("La batalla ha comenzado!!!");
        while(robotsEnPie() > 1){

            int numAtacante = robotRandom();                                //consigue un robot al azar para atacar
            int  numAtacado = robotRandom();                                //consigue un robot al azar para ser atacado

            while(numAtacado == numAtacante){
                numAtacado = robotRandom();
            }

            Robot atacante = robots[numAtacante];
            Robot atacado = robots[numAtacado];

            atacante.atacar(atacado);

            System.out.println(atacante.getNombre() + " ataco a " + atacado.getNombre() + "!!!");

            atacado.estado();

            System.out.println("--------------Enter para continuar-------------"); //una pausa antes del siguiente ataque
            System.out.println("----------(1.Ver estado de los robots)---------"); //o da la opcion de ver el estado de los robots

            String respuesta = input.nextLine();

            if(respuesta.equals("1")){                                      //Pausa para mostrar el estado de los robots
                mostrarRobots();

            System.out.println("--------------Enter para continuar-------------");

            input.nextLine();
            }
            
            
        }

        ganador();

        System.out.println();
        System.out.println();
        reiniciarJuego();


    }

    public void ganador(){                                                             //Recorre el arreglo robots buscando al que aun Tenga estado True
        
        for(int i = 0; i < cantidadRobots; i ++){

            if(robots[i].getEstado()){
                System.out.println();
                System.out.println("===================================================================");
                System.out.println("El Ganador de la batalla es " + robots[i].getNombre() + "!!!!!!");
                System.out.println("===================================================================");
                System.out.println();
            }
        }

    }

    public void reiniciarJuego(){                                                    //Despues decada juego se reincia elarreglo para poder volver a jugar
        for(int i = 0; i < robots.length; i++){                                      //recorre el arreglo y lo reinicia
            robots[i] = null;
        }
        cantidadRobots = 0;
        System.out.println("El juego ha sido reiniciado, puedes crear nuevos robots ahora");
        System.out.println();
    }
}