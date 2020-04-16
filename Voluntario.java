
/**
 * Write a description of class Voluntario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Voluntario
{
    private String cod;
    private String nome;
    private double lat;
    private double lon;
    private double raio;
    
    public Voluntario()
    {
        this.cod = new String();
        this.nome = new String();
        this.lat = 0;
        this.lon = 0;
        this.raio = 0;
    }
    
    public Voluntario (String s, String n, double x, double y, double r)
    {
        this.cod = s;
        this.nome = n;
        this.lat = x;
        this.lon = y;
        this.raio =r;
    }
    
    public Voluntario (Voluntario u)
    {
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.lat = u.getLat();
        this.lon = u.getLon();
        this.raio = u.getRaio();
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
    
    public double getRaio()
    {
        return this.raio;
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
    
    public void setRaio (double r)
    {
        this.raio = r;
    }
    
    public Voluntario clone()
    {
        return new Voluntario(this);
    }
    
    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Voluntario u = (Voluntario) o;
        return this.cod.equals(u.getCod()) &&
               this.nome.equals(u.getNome()) &&
               this.lat == u.getLat() && this.lon == u.getLon() &&
               this.raio == u.getRaio();
    }
}
