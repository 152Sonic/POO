import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Utilizador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Utilizador
{
    private String cod;
    private String nome;
    private GPS gps;
    private List<Encomenda> entregues;

    public Utilizador()
    {
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
        this.entregues = new ArrayList<>();
    }

    public Utilizador (String s, String n, double x, double y, ArrayList<Encomenda> lista)
    {
        this.cod = s;
        this.nome = n;
        this.gps = new GPS(x,y);
        this.setEntregues(lista);
    }

    public Utilizador (Utilizador u)
    {
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
        this.setEntregues(u.getEntregues());
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

     public ArrayList<Encomenda> getEntregues() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for (Encomenda l : this.entregues)
            aux.add(l);
        return aux;
    }

    public void setEntregues (ArrayList<Encomenda> l)
    {
        this.entregues = new ArrayList<>();
        for(Encomenda li : l)
            this.entregues.add(li);
    }

    public void setCod(String s)
    {
        this.cod = s;
    }

    public void setNome(String n)
    {
        this.nome = n;
    }

    public void setGPS (double l, double lo)
    {
        this.gps.setGPS(l,lo);
    }

    public Utilizador clone()
    {
        return new Utilizador(this);
    }

    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Utilizador u = (Utilizador) o;
        return this.cod.equals(u.getCod()) &&
               this.nome.equals(u.getNome()) &&
               this.gps.equals(u.getGPS());
    }
}
