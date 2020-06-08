package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Write a description of class Model.Voluntario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Voluntario
{
    private String pass;
    private String cod;
    private String nome;
    private GPS gps;
    private double raio;
    private boolean livre;
    private List<Encomenda> pedidos;
    private List<Encomenda> listenc;
    private boolean medico;

    public Voluntario()
    {
        this.pass = new String();
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
        this.raio = 0;
        this.livre = true;
        this.pedidos = new ArrayList<>();
        this.listenc = new ArrayList<>();
        this.medico = false;
    }

    public Voluntario (String s, String n, GPS gps, double r, boolean b, ArrayList<Encomenda> lista, boolean med)
    {
        this.pass = s;
        this.cod = s;
        this.nome = n;
        this.gps = gps.clone();
        this.raio =r;
        this.livre = b;
        this.pedidos = new ArrayList<>();
        this.setList(lista);
        this.medico = med;

    }
    public Voluntario (String p, String s, String n, GPS gps, double r, boolean med)
    {
        this.pass = s;
        this.cod = s;
        this.nome = n;
        this.gps = gps.clone();
        this.raio =r;
        this.livre = true;
        this.pedidos = new ArrayList<>();
        this.listenc = new ArrayList<>();
        this.medico = med;

    }

    public Voluntario (Voluntario u)
    {
        this.pass = u.getPass();
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
        this.raio = u.getRaio();
        this.livre = u.getLivre();
        this.setPedidos(u.getPedidos());
        this.setList(u.getList());
        this.medico = u.aceitoTransporteMedicamentos();
    }

    public boolean aceitoTransporteMedicamentos() {
        return medico;
    }

    public void aceitaMedicamentos(boolean medico) {
        this.medico = medico;
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

    public double getRaio()
    {
        return this.raio;
    }

    public boolean getLivre()
    {
        return this.livre;
    }


    public ArrayList<Encomenda> getList() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for (Encomenda l : this.listenc)
            aux.add(l);
        return aux;
    }

    public ArrayList<Encomenda> getPedidos() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for (Encomenda l : this.pedidos)
            aux.add(l);
        return aux;
    }

    public void setList (ArrayList<Encomenda> l)
    {
        this.listenc = new ArrayList<>();
        for(Encomenda li : l)
            this.listenc.add(li);
    }

    public void setPedidos (ArrayList<Encomenda> l)
    {
        this.pedidos = new ArrayList<>();
        for(Encomenda li : l)
            this.pedidos.add(li);
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
               this.pedidos == u.getPedidos() &&
               this.livre == u.getLivre();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Model.Voluntario{");
        sb.append("cod='").append(cod).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", gps=").append(gps);
        sb.append(", raio=").append(raio);
        sb.append(", livre=").append(livre);
        sb.append(", listenc=").append(listenc);
        sb.append('}');
        return sb.toString();
    }
    public boolean validaPass(String p){
        return this.pass.equals(p);
    }

    public void aceitaPedido(Encomenda e, LocalDateTime i){
        this.pedidos.remove(e);
        this.listenc.add(e);
        this.livre = false;
        Iterator<Encomenda> it = listenc.iterator();
        boolean f = false;
        while(it.hasNext() && !f){
            Encomenda enc = it.next();
            if(enc.equals(e)){
                enc.setDatai(i);
                enc.setTransp(this.cod);
                f=true;
            }
        }
    }

    public void rejeitaPedido(Encomenda e){
        this.pedidos.remove(e);
    }


    public void addPedido(Encomenda e){ this.pedidos.add(e);}

    public void rmPedido(Encomenda e){ this.pedidos.remove(e);}

    public void setCl(Encomenda e, int cl){
        Iterator<Encomenda> it = pedidos.iterator();
        boolean f = false;
        while(it.hasNext() && !f){
            Encomenda enc = it.next();
            if(enc.equals(e)){
                enc.setClassificacao(cl);
                f=true;
            }
        }
    }

    public double getClGeral() {
        double r = 0;
        double size = 0;
        if (this.listenc.size() <= 0) return 0;
        else {
            for (Encomenda e : this.listenc){
                if (e.getClassificacao() != -1 && e.getEntregue()) {
                    r += e.getClassificacao();
                    size++;
                }
            }
            if (size == 0) return 0;
            else return r / size;
        }
    }

    public void encEntregue(Encomenda e, LocalDateTime fi) {
        Iterator<Encomenda> it = this.listenc.iterator();
        this.livre = true;
        boolean f = false;
        while (it.hasNext() && !f) {
            Encomenda e1 = it.next();
            if (e1.equals(e)) {
                e1.setDataf(fi);
                e1.setEntregue(true);
                f = true;
            }
        }
    }

}