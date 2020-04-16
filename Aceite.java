
/**
 * Write a description of class Aceite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class Aceite
{
    private ArrayList<String> aceites;
    
    public Aceite()
    {
        this.aceites = new ArrayList<>();
    }
    
    public Aceite(ArrayList<String> a)
    {
        this.setAceites(a);
    }
    
    public Aceite(Aceite a)
    {
        this.setAceites(a.getAceites());
    }
    
    public ArrayList<String> getAceites()
    {
        ArrayList<String> aux = new ArrayList<>();
        for(String s : this.aceites)
            aux.add(s);
        return aux;
    }
    
    public void setAceites(ArrayList<String> a)
    {
        this.aceites = new ArrayList<>();
        for(String s : a)
            this.aceites.add(s);
    }
    
    public Aceite clone()
    {
        return new Aceite(this);
    }
    
    public boolean equals (Object o)
    {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Aceite a = (Aceite) o;
        return this.aceites.equals(a.getAceites());
    }
    
}
