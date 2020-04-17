
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
    private GPS gps;
    private double raio;
    private boolean livre;
    
    public Voluntario()
    {
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
        this.raio = 0;
        this.livre = true;
    }
    
    public Voluntario (String s, String n, double x, double y, double r, boolean b)
    {
        this.cod = s;
        this.nome = n;
        this.gps = new GPS (x,y);
        this.raio =r;
        this.livre = b;
    }
    
    public Voluntario (Voluntario u)
    {
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
        this.raio = u.getRaio();
        this.livre = u.getLivre();
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
    
    public double getRaio()
    {
        return this.raio;
    }
    
    public boolean getLivre()
    {
        return this.livre;
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
    
    public void setRaio (double r)
    {
        this.raio = r;
    }
    
    public void setLivre(boolean b)
    {
        this.livre = b;
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
               this.gps.equals(u.getGPS()) &&
               this.raio == u.getRaio() &&
               this.livre == u.getLivre();
    }
}
