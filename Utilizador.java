
/**
 * Write a description of class Utilizador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.util.Pair;

public class Utilizador
{
    private String cod;
    private String nome;
    private double lat;
    private double lon;
    
    public Utilizador()
    {
        this.cod = new String();
        this.nome = new String();
        this.lat = 0;
        this.lon = 0;
    }
    
    public Utilizador (String s, String n, double x, double y)
    {
        this.cod = s;
        this.nome = n;
        this.lat = x;
        this.lon = y;
    }
    
    public Utilizador (Utilizador u)
    {
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.lat = u.getLat();
        this.lon = u.getLon();
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
               this.lat == u.getLat() && this.lon == u.getLon();
    }
}
