// Importar las librias necesarias 
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Iniciar Scanner
        Random random = new Random(); // Iniciar Random
        int max = 21;
        int empates = 0;

        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine(); //Almacenar nombre

        Jugador player = new Jugador(nombre); //Crear objeto Jugador para el usuario
        Jugador dealer = new Jugador("Dealer"); // Crar objeto Jugador para el dealer
        int seguir = 1; //Control primer while

        while (seguir == 1){ //Menú para continuar jugando
            System.out.println("Bienvenido " + nombre + " ¿Qué deseas hacer?");
            System.out.println("Iniciar juego: 1 | Salir 2");
            int opcion = scanner.nextInt(); //Decisión del jugador
            switch (opcion)  {
                case 1: //Jugador decide jugar
                    player.setMano((random.nextInt(9) + 1) + (random.nextInt(9) + 1)); //Mano inicial del jugador
                    dealer.setMano((random.nextInt(9) + 1) + (random.nextInt(9) + 1)); //Mano inical del Dealer
                    int paso = 0; //Verificar si alguno se pasa del maximo
                    if (player.getMano() <= max && dealer.getMano() <+ max){ //Comparar que no se pasen del máximo
                        int seguir2 = 1; //Control segundo while
                        while (seguir2 == 1){ //Ciclo meintra el jugador decida tomar cartas y ninguno se pase del maximo
                            System.out.println(nombre + " tu mano es: " + player.getMano());
                            System.out.println("¿Quieres pedir carta? Si : 1 | No:  2");
                            int decision = scanner.nextInt();
                            switch (decision)  {
                            case 1: //Jugador decide tomar carta
                                player.drawCard();
                                dealer.drawCard(); 
                                if (player.getMano() > max && dealer.getMano() > max){ //Ambos se pasan del máximo
                                    paso = 1;
                                    System.out.println("Ambos se pasaron de 21, empate!");
                                    empates++;
                                    seguir2 = 0; //Romper ciclo while
                                } else {
                                    if ((player.getMano() > max) ){ //Jugador se pasa del máximo
                                    System.out.println("Te has pasado de 21, has perdido.");
                                    seguir2 = 0; //Romper ciclo while
                                    paso = 1;
                                    dealer.setVictorias(dealer.getVictorias() + 1);
                                }   else if (dealer.getMano() > max) { //dealer se pasa del máximo
                                    System.out.println("El dealer se pasó de 21, has ganado!.");
                                    player.setVictorias(player.getVictorias() + 1);
                                    seguir2 = 0; //Romper ciclo while

                                    paso = 1;
                                }
                                }
                                
                                break;
                            case 2:
                                seguir2 = 0; //Jugador decide no tomar carta
                                break;
                            default:
                                System.out.println("Error, ingrese una opción válida"); //Salida si se ingresa una opción inválida
                            }
                        
                        }
                    }
                    //Mostrar manos
                    System.out.println("Tu mano: " + player.getMano());
                    System.out.println("Mano del dealer: " + dealer.getMano());

                    if (paso == 0){ //Comparar que ningún jugador se pasó del maximo
                        if (player.getMano() == dealer.getMano()){ //Ambos tienen la misma mano
                            System.out.println("Empate!");
                            empates++;
                        } else if (player.getMano() == max) { //El jugador tiene 21
                            System.out.println("Has ganado!");
                            player.setVictorias(player.getVictorias() + 1);
                        } else if (dealer.getMano() == max){ //El dealer tiene 21
                            System.out.println("El dealer ha ganado!");
                            dealer.setVictorias(dealer.getVictorias() + 1);
                        } else if (player.getMano() > dealer.getMano()){ // El jugador está más cerca que el dealer
                            System.out.println("Has ganado!");
                            player.setVictorias(player.getVictorias() + 1);
                        } else { //El dealer está más cerca que el jugador
                            System.out.println("El dealer ha ganado!");
                            dealer.setVictorias(dealer.getVictorias() + 1);
                        }
                    }
                    break;

                case 2: //Jugador ya no quiere seguir jugando
                    System.out.println("Terminando juego...");
                    seguir = 0;
                    //Mostrar estadísticas
                    System.out.println("Victorias: " + player.getVictorias());
                    System.out.println("Empates: " + empates);
                    System.out.println("Derrotas: " + dealer.getVictorias());
                    break;
                default:
                    System.out.println("Error, por favor ingrese una opción válida."); //Salida si se ingresa una opción inválida
            }
        }
        
    }
}