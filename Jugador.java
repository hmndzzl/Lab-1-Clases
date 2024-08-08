import java.util.Random; //Importar random

public class Jugador{
    //Atributos de Jugador
    private String nombre;
    private int mano;
    private int victorias;

    private Random random = new Random();

    //Constructor
    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano = 0;
        this.victorias = 0;

    }
    
    //Setters & Getters

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMano() {
        return this.mano;
    }

    public void setMano(int mano) {
        this.mano = mano;
    }

    public int getVictorias() {
        return this.victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    //Métodos
    public void drawCard(){
        this.mano += (random.nextInt(9) + 1);
    }

}