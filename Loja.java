import org.ietf.jgss.GSSContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Loja here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Loja
{
    private String cod;
    private String nome;
    private GPS gps;
    private List<Encomenda> listaEnc;

    public Loja()
    {
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
        this.listaEnc = new ArrayList<>();

    }

    public Loja (String s, String n, double x, double y, ArrayList<Encomenda> li)
    {
        this.cod = s;
        this.nome = n;
        this.gps = new GPS(x,y);
        this.setListaEnc(li);
    }

    public Loja (Loja u)
    {
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
        this.setListaEnc(u.getListaEnc());
    }


    public ArrayList<Encomenda> getListaEnc() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for (Encomenda l : this.listaEnc)
            aux.add(l);
        return aux;
    }

    public void setListaEnc (ArrayList<Encomenda> l)
    {
        this.listaEnc = new ArrayList<>();
        for(Encomenda li : l)
            this.listaEnc.add(li);
    }

    public String getCod()
    {
        return this.cod;
    }

    public String getNome()
    {
        return this.nome;
    }

    public GPS getGPS()
    {
        return this.gps;
    }

    public void setCod(String s)
    {
        this.cod = s;
    }

    public void setNome(String n)
    {
        this.nome = n;
    }

    public void setGPS(double l, double lo)
    {
        this.gps.setGPS(l,lo);
    }

    public Loja clone()
    {
        return new Loja(this);
    }

    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Loja u = (Loja) o;
        return this.cod.equals(u.getCod()) &&
               this.nome.equals(u.getNome()) &&
               this.gps.equals(u.getGPS());
    }
}
