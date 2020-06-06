import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a description of class Utilizador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Utilizador
{
    private String pass;
    private String cod;
    private String nome;
    private GPS gps;
    private Map<String,List<String>> pedidos;
    private List<Encomenda> entregues;


    public Utilizador()
    {
        this.pass = new String();
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
        this.pedidos = new HashMap<>();
        this.entregues = new ArrayList<>();
    }

    public Utilizador (String s, String n, GPS gps, ArrayList<Encomenda> lista)
    {
        this.pass = s;
        this.cod = s;
        this.nome = n;
        this.gps = gps.clone();
        this.pedidos = new HashMap<>();
        this.setEntregues(lista);
    }
    public Utilizador (String p,String s, String n, GPS gps)
    {
        this.pass = p;
        this.cod = s;
        this.nome = n;
        this.gps = gps.clone();
        this.pedidos = new HashMap<>();
        this.entregues = new ArrayList<>();
    }

    public Utilizador (Utilizador u)
    {
        this.pass = u.getPass();
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
        this.setPedidos(u.getPedidos());
        this.setEntregues(u.getEntregues());
    }

    public void setPass(String p){this.pass = p;}

    public String getPass(){return this.pass;}

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

    public Map<String,List<String>> getPedidos() {
        Map<String,List<String>> aux = new HashMap<>();
        for (Map.Entry<String,List<String>> l : this.pedidos.entrySet()) {
            if (!aux.containsKey(l.getKey())) aux.put(l.getKey(), new ArrayList<>());
            aux.put(l.getKey(), l.getValue());
        }
        return aux;
    }
    public void setPedidos (Map<String,List<String>> l)
    {
        this.pedidos = new HashMap<>();
        for(Map.Entry<String,List<String>> li : l.entrySet()) {
            if (!pedidos.containsKey(li.getKey())) pedidos.put(li.getKey(), new ArrayList<>());
            this.pedidos.put(li.getKey(), li.getValue());
        }
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilizador{");
        sb.append("cod='").append(cod).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", gps=").append(gps);
        sb.append(", entregues=").append(entregues);
        sb.append('}');
        return sb.toString();
    }

    public boolean validaPass(String p){
        return this.pass.equals(p);
    }

    public void addPedidos(String e, String t){
        if(pedidos.containsKey(e)) pedidos.get(e).add(t);
        else {
            pedidos.put(e,new ArrayList<>());
            pedidos.get(e).add(t);
        }
    }
}