import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Transportadora here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transportadora
{
    private String cod;
    private String nome;
    private GPS gps;
    private int nif;
    private double raio;
    private double taxa;
    private List<Encomenda> listenc;

    public Transportadora()
    {
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
        this.nif = 0;
        this.raio = 0;
        this.taxa = 0;
        this.listenc = new ArrayList<>();
    }

    public Transportadora (String s, String nome, double x, double y,int n, double r, double p, ArrayList<Encomenda> lista )
    {
        this.cod = s;
        this.nome = nome;
        this.gps = new GPS(x,y);
        this.nif = n;
        this.raio =r;
        this.taxa = p;
        this.setList(lista);

    }

    public Transportadora (Transportadora u)
    {
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
        this.nif = u.getNif();
        this.raio = u.getRaio();
        this.taxa = u.getTaxa();
        this.setList(u.getList());
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

    public int getNif()
    {
        return this.nif;
    }

    public double getRaio()
    {
        return this.raio;
    }

    public double getTaxa()
    {
        return this.taxa;
    }

    public ArrayList<Encomenda> getList() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for (Encomenda l : this.listenc)
            aux.add(l);
        return aux;
    }

    public void setList (ArrayList<Encomenda> l)
    {
        this.listenc = new ArrayList<>();
        for(Encomenda li : l)
            this.listenc.add(li);
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

    public void setNif (int n)
    {
        this.nif = n;
    }

    public void setRaio (double r)
    {
        this.raio = r;
    }

    public void setTaxa(double p)
    {
        this.taxa = p;
    }

    public Transportadora clone()
    {
        return new Transportadora(this);
    }

    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Transportadora t = (Transportadora) o;
        return this.cod.equals(t.getCod()) &&
               this.nome.equals(t.getNome()) &&
               this.gps.equals(t.getGPS()) &&
               this.raio == t.getRaio() && this.nif == t.getNif() &&
               this.taxa == t.getTaxa();
    }
}
