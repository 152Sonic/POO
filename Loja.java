
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
    
    public Loja()
    {
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
    }
    
    public Loja (String s, String n)
    {
        this.cod = s;
        this.nome = n;
        this.gps = new GPS();
    }
    
    public Loja (Loja u)
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
