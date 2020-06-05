import org.ietf.jgss.GSSContext;

import java.util.*;

/**
 * Write a description of class Loja here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Loja
{
    private String pass;
    private String cod;
    private String nome;
    private GPS gps;
    private List<Encomenda> listaEnc;
    private List<Encomenda> prontas;
    private Set<Produto> stock;

    public Loja()
    {
        this.pass = new String();
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
        this.listaEnc = new ArrayList<>();
        this.prontas = new ArrayList<>();
        this.stock = new TreeSet<>();

    }

    public Loja (String s, String n, GPS gps, ArrayList<Encomenda> li, ArrayList<Encomenda> prontas)
    {
        this.pass = s;
        this.cod = s;
        this.nome = n;
        this.gps = gps.clone();
        this.setListaEnc(li);
        this.setProntas(prontas);
        this.stock = new TreeSet<>();
    }

    public Loja (String p, String s, String n, GPS gps)
    {
        this.pass = p;
        this.cod = s;
        this.nome = n;
        this.gps = gps.clone();
        this.listaEnc = new ArrayList<>();
        this.prontas = new ArrayList<>();
        this.stock = new TreeSet<>();
    }

    public Loja (Loja u)
    {
        this.pass = u.getPass();
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
        this.setListaEnc(u.getListaEnc());
        this.setProntas(u.getProntas());
        this.setStock(u.getStock());
    }


    public ArrayList<Encomenda> getListaEnc() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for (Encomenda l : this.listaEnc)
            aux.add(l);
        return aux;
    }

    public ArrayList<Encomenda> getProntas() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for (Encomenda l : this.prontas)
            aux.add(l);
        return aux;
    }

    public TreeSet<Produto> getStock(){
        return new TreeSet<>(stock);
    }

    public void setStock(TreeSet<Produto> p){
        this.stock = new TreeSet<>();
        for (Produto pi: p){
            stock.add(pi);
        }
    }

    public void setListaEnc (ArrayList<Encomenda> l)
    {
        this.listaEnc = new ArrayList<>();
        for(Encomenda li : l)
            this.listaEnc.add(li);
    }



    public void setProntas (ArrayList<Encomenda> l)
    {
        this.prontas = new ArrayList<>();
        for(Encomenda li : l)
            this.prontas.add(li);
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Loja{");
        sb.append("cod='").append(cod).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", gps=").append(gps);
        sb.append(", listaEnc=").append(listaEnc);
        sb.append('}');
        return sb.toString();
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

    public void addEncomenda(String e, String u, String[]ps, int []qts){
        ArrayList<LinhaEncomenda> linhas = new ArrayList<>();
        double p=0;
        for(int i=0;i<ps.length;i++){
//            if(stock.contains(ps[i])){
//                LinhaEncomenda linha = new LinhaEncomenda(stock.get(ps[i]).getCod(), ps[i], qts[i],qts[i] * stock.get(ps[i]).getPeso(), stock.get(ps[i]).getPreçouni() * qts[i]);
//                linhas.add(linha);
//            }
            for(LinhaEncomenda li : linhas) {
                p += li.getPeso();
            }
            Encomenda enc = new Encomenda (e,this.cod,u,p,linhas);
            this.listaEnc.add(enc);

        }
    }

    public void addEncomenda(Encomenda e){
        this.listaEnc.add(e);
    }

    public void addEncomendaParse(Encomenda e) {
        if (!listaEnc.contains(e)) {
            listaEnc.add(e);
        }
    }

    public void setEntregue(Encomenda e){
        Iterator<Encomenda> it = this.listaEnc.iterator();
        boolean r = false;
        while(it.hasNext() && !r){
            Encomenda enc = it.next();
            if(enc.equals(e)) {
                enc.setEntregue(true);
                r=true;
            }
        }
    }

    public boolean validaPass(String p){
        return this.pass.equals(p);
    }

    public Encomenda getEncomenda(String e) {
        Encomenda enc = new Encomenda();
        Iterator<Encomenda> it = listaEnc.iterator();
        boolean found = false;
        while(it.hasNext() && !found){
            Encomenda en = it.next();
            if(en.getCodenc() == e){
                found = true;
                enc = en.clone();
            }

        }
        return enc;
    }

    public void addEncPronta(Encomenda e){
        this.prontas.add(e);
    }
    public void rmEncPronta(Encomenda e){
        this.prontas.remove(e);
    }

    public void addProdutos(TreeSet<Produto> p){
        stock.addAll(p);
    }
    
    public void addProduto(Produto p){stock.add(p);}

    public boolean existeProd(String cod){
        Iterator<Produto> it = stock.iterator();
        boolean r = false;
        while (it.hasNext() && !r){
            Produto aux = it.next();
            if (aux.getCod().equals(cod)){
                r = true;
            }
        }
        return r;
    }


}