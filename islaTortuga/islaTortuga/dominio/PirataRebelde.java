package dominio;
import java.awt.Color;
public class PirataRebelde extends Pirata{
    private int ultimaAccion;
    private int cont;
    /**
     * @param isla 
     * @param name 
     * @param posicionx 
     * @param posiciony
     */
    public  PirataRebelde(Isla isla,String name,int posicionx, int posiciony){
        super(isla,name,posicionx,posiciony);
        color=Color.RED;
        palabras="Soy rebelde ";
        cont=0;
    }
    
    @Override
    /**
     *  cada 3 ordenes segidas para
     */
    public void pare(){
        ultimaAccion=1;
        if (cont%3==0){
            super.actue();
            cont=0;
        }
        cont+=1;
    }
    /**
     *  cada 3 ordenes segidas actue
     */
    @Override
    public void actue(){
        ultimaAccion=2;
        if(cont%3==0){
            super.pare();
            cont=0;
        }
        cont+=1;
    }
    /**
     *  hace la ultima opcion
     */
    public void decidan(){
        if (ultimaAccion==1){
            pare();
        } else if(ultimaAccion>=2){
            actue();                     
        }
        cont+=1;
     }
}
