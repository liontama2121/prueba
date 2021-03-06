package dominio;


import java.util.*;

public class Isla{
    public static final int MAXIMO = 500;
    private static Isla isla = null;
    /**
     * si no tiene una isla, le da una isla 
     */
    public static Isla demeIsla() {
        if (isla==null){
            isla=new Isla();
        }
        return isla;
    }
    /**
     * crea un nueva isla
     */
    private static void nuevaIsla() {
        isla=new Isla();
    }   
    /**
     * cambia la isla 
     */
    public static void cambieIsla(Isla d) {
        isla=d;
    }       

    private ArrayList<EnIsla> elementos;
    private int tesoroPosX;
    private int tesoroPosY;
    private boolean encontraronTesoro;

    
    /**
     * contructor de la Isla 
     */
    private Isla() {
        elementos= new ArrayList<EnIsla>();
        tesoroPosX = (int)(Math.random() * MAXIMO);
        tesoroPosY = (int)(Math.random() * MAXIMO);
        encontraronTesoro=false;
    }
    /**
     * crea objetos nuevos en Isla
     */
    public void algunosEnIsla(){
       Pirata jack = new Pirata (this,"jack",100,100);
       Pirata elizabeth = new Pirata(this,"elizabeth",200,100);
       PirataRebelde henry = new  PirataRebelde (this,"henry",500,100);
       PirataRebelde corina = new  PirataRebelde (this,"corina",400,100); 
       Palmera superiorDerecha  = new Palmera(this,"p1",500,500);
       Palmera superiorIzquierda = new Palmera(this,"p2",0,500);
       Palmera inferiorDerecha = new Palmera(this,"p3",500,0);
       Palmera inferiorIzquierda = new Palmera(this,"p4",0,0);
       Tesoro tesoro = new Tesoro (this,"tesoro", tesoroPosX, tesoroPosY);
       Minucioso ada = new Minucioso(this,"ada ",0,500);
       Minucioso turing= new Minucioso(this,"turing ",0,300);
       PirataBorracho  Juan = new PirataBorracho(this,"juan",0,400);
       PirataBorracho  Pablo = new PirataBorracho(this,"pablo",0,200);
       Barco bar=new Barco(this,"navio",400,300);
    }  
    /**
     * @param n 
     * @return EnIsla h 
     */
    public EnIsla demeEnIsla(int n){
        EnIsla h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    /**
     * @param e 
     * adiciona cada elento a al ArrayList
     */
    
    public void adicione(EnIsla e){
        elementos.add(e);
    }
    /**
     * @return la longitud de elementos
     */
    public int numeroEnIsla(){
        return elementos.size();
    }
    /**
     * @return e
     * @return un boolean si cumple si esra en el tesoro 
     */
    public boolean enTesoro(EnIsla e){
        boolean tesoro=(tesoroPosX==e.getPosicionX() && tesoroPosY==e.getPosicionY());
        encontraronTesoro = encontraronTesoro || tesoro;
        return tesoro;
    }     
    /**
     * recorre cada elento y hace que actue
     */
    public void actuen(){
         for(int i=0;i<elementos.size();i++){
            elementos.get(i).actue();
        }
    }
    /**
     * recorre cada elento y hace que paren
     */
    public void paren(){
         for(int i=0;i<elementos.size();i++){
            elementos.get(i).pare();
        }
    }    
    /**
     * recorre cada elento y hace que decida
     */
    public void decidan(){
       for(int i=0;i<elementos.size();i++){
            elementos.get(i).decida();
        } 
    }  
}
