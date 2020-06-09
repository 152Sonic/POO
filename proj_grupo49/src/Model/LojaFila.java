package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class LojaFila extends Loja implements Serializable {
    private int fila;

    public LojaFila(){
        super();
        this.fila =0;
    }

    public LojaFila(String s, String n, GPS gps, ArrayList<Encomenda> l, ArrayList <Encomenda> p, int f ){
        super(s,n,gps,l,p);
        this.fila = f;
    }

    public LojaFila(LojaFila lf){
        super(lf);
        this.fila = lf.getFila();
    }

    public int getFila(){
        return this.fila;
    }

    public void setFila(int x){
        this.fila = x;
    }

    public void decFila(){
        this.fila--;
    }

    public void incFila(){
        this.fila++;
    }


}
