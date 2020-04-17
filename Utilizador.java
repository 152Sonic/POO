
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
    private GPS gps;
    
    public Utilizador()
    {
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
    }
    
    public Utilizador (String s, String n, double x, double y)
    {
        this.cod = s;
        this.nome = n;
        this.gps = new GPS(x,y);
    }
    
    public Utilizador (Utilizador u)
    {
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
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
