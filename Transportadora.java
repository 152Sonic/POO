
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
    private double lat;
    private double lon;
    private int nif;
    private double raio;
    private double preço;
    
    public Transportadora()
    {
        this.cod = new String();
        this.nome = new String();
        this.lat = 0;
        this.lon = 0;
        this.nif = 0;
        this.raio = 0;
        this.preço = 0;
    }
    
    public Transportadora (String s, String nome, double x, double y,int n, double r, double p)
    {
        this.cod = s;
        this.nome = nome;
        this.lat = x;
        this.lon = y;
        this.nif = n;
        this.raio =r;
        this.preço = p;
    }
    
    public Transportadora (Transportadora u)
    {
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.lat = u.getLat();
        this.lon = u.getLon();
        this.nif = u.getNif();
        this.raio = u.getRaio();
        this.preço = u.getPreço();
    }
    
    public String getCod()
    {
        return this.cod;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public double getLat()
    {
        return this.lat;
    }
    
    public double getLon()
    {
        return this.lon;
    }
    
    public int getNif()
    {
        return this.nif;
    }
    
    public double getRaio()
    {
        return this.raio;
    }
    
    public double getPreço()
    {
        return this.preço;
    }
    
    public void setCod(String s)
    {
        this.cod = s;
    }
    
    public void setNome(String n)
    {
        this.nome = n;
    }
    
    public void setLat (double l)
    {
        this.lat =l;
    }
    
    public void setLon (double l)
    {
        this.lon = l;
    }
    
    public void setGPS (double l, double lo)
    {
        this.lat =l;
        this.lon = lo;
    }
    
    public void setNif (int n)
    {
        this.nif = n;
    }
    
    public void setRaio (double r)
    {
        this.raio = r;
    }
    
    public void setPreço(double p)
    {
        this.preço = p;
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
               this.lat == t.getLat() && this.lon == t.getLon() &&
               this.raio == t.getRaio() && this.nif == t.getNif() &&
               this.preço == t.getPreço();
    }
}
