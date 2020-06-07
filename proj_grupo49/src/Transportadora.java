import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;

/**
 * Write a description of class Transportadora here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transportadora
{
    private String pass;
    private String cod;
    private String nome;
    private GPS gps;
    private int nif;
   // private boolean medico;
    private double raio;
    private double taxa;
    private double taxaPeso;
    private int pesoLimite;
    private List<Encomenda> listenc;
    private List<Encomenda> pedidos;
    private List<Encomenda> espera;

    public Transportadora()
    {
        this.pass = new String();
        this.cod = new String();
        this.nome = new String();
        this.gps = new GPS();
        this.nif = 0;
        this.raio = 0;
        this.taxa = 0;
        this.taxaPeso = 0;
        this.pesoLimite = 100;
        this.listenc = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.espera = new ArrayList<>();
    }

    public Transportadora (String s, String nome, GPS gps,int n, double r, double p,double tp, int peso, ArrayList<Encomenda> lista )
    {
        this.pass = s;
        this.cod = s;
        this.nome = nome;
        this.gps = gps.clone();
        this.nif = n;
        this.raio =r;
        this.taxa = p;
        this.taxaPeso = tp;
        this.pesoLimite = peso;
        this.setList(lista);
        this.pedidos = new ArrayList<>();
        this.espera = new ArrayList<>();

    }

    public Transportadora (String pass, String s, String nome, GPS gps,int n, double r, double p,double tp, int peso)
    {
        this.pass = pass;
        this.cod = s;
        this.nome = nome;
        this.gps = gps.clone();
        this.nif = n;
        this.raio =r;
        this.taxa = p;
        this.taxaPeso = tp;
        this.pesoLimite = peso;
        this.listenc = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.espera = new ArrayList<>();

    }

    public Transportadora (Transportadora u)
    {
        this.pass = u.getPass();
        this.cod = u.getCod();
        this.nome = u.getNome();
        this.gps = new GPS(u.getGPS());
        this.nif = u.getNif();
        this.raio = u.getRaio();
        this.taxa = u.getTaxa();
        this.taxaPeso = u.getTaxaPeso();
        this.pesoLimite = u.getPesoLimite();
        this.setList(u.getList());
        this.setPedidos(u.getPedidos());
        this.setEspera(u.getEspera());

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

    public int getNif()
    {
        return this.nif;
    }

    public double getRaio()
    {
        return this.raio;
    }

    public double getTaxa()
    {
        return this.taxa;
    }

    public double getTaxaPeso() {
        return taxaPeso;
    }

    public void setTaxaPeso(double taxaPeso) {
        this.taxaPeso = taxaPeso;
    }

    public int getPesoLimite() {
        return pesoLimite;
    }

    public void setPesoLimite(int pesoLimite) {
        this.pesoLimite = pesoLimite;
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
    public ArrayList<Encomenda> getEspera() {
        ArrayList<Encomenda> aux = new ArrayList<>();
        for (Encomenda l : this.espera)
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
    public void setEspera (ArrayList<Encomenda> l)
    {
        this.espera = new ArrayList<>();
        for(Encomenda li : l)
            this.espera.add(li);
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

    public void setNif (int n)
    {
        this.nif = n;
    }

    public void setRaio (double r)
    {
        this.raio = r;
    }

    public void setTaxa(double p)
    {
        this.taxa = p;
    }

    public Transportadora clone()
    {
        return new Transportadora(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transportadora{");
        sb.append("cod='").append(cod).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", gps=").append(gps);
        sb.append(", nif=").append(nif);
        sb.append(", raio=").append(raio);
        sb.append(", taxa=").append(taxa);
        sb.append(", taxaPeso=").append(taxaPeso);
        sb.append(", pesoLimite=").append(pesoLimite);
        sb.append(", listenc=").append(listenc);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transportadora)) return false;
        Transportadora that = (Transportadora) o;
        return nif == that.nif &&
                Double.compare(that.raio, raio) == 0 &&
                Double.compare(that.taxa, taxa) == 0 &&
                Double.compare(that.taxaPeso, taxaPeso) == 0 &&
                pesoLimite == that.pesoLimite &&
                Objects.equals(cod, that.cod) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(gps, that.gps) &&
                Objects.equals(listenc, that.listenc);
    }


    public double getPreço(GPS loja, GPS user, Encomenda e){
        double d1 = this.gps.distancia(loja);
        double d2 = loja.distancia(user);
        return taxa * (d1 + d2) + (taxaPeso * e.getPeso()) ;

    }

    public double getTempo(GPS loja, GPS user){
        double d1 = this.gps.distancia(loja);
        double d2 = loja.distancia(user);
        double v = 50;
        return (d1+d2)/v;
    }
    public boolean validaPass(String p){
        return this.pass.equals(p);
    }

    public void aceitaPedido(Encomenda e){
        this.pedidos.remove(e);
        this.espera.add(e);
    }

    public void rejeitaPedido(Encomenda e){ this.pedidos.remove(e);}

    public double getMedia() {
        double tc = this.listenc.stream().filter(Encomenda::getAceites).mapToDouble(Encomenda::getClassificacao).sum();
        double t = this.listenc.stream().filter(Encomenda::getAceites).count();
        return tc / t;
    }

    public boolean existeEnc(String cod){
        Iterator<Encomenda> it = listenc.iterator();
        boolean r = false;
        while (it.hasNext() && !r){
            Encomenda aux = it.next();
            if (aux.getCodenc().equals(cod)){
                r = true;
            }
        }
        return r;
    }

    public boolean getEntregue(String cod){
        Iterator<Encomenda> it = listenc.iterator();
        boolean r = false;
        while (it.hasNext() && !r){
            Encomenda aux = it.next();
            if (aux.getCodenc().equals(cod) && aux.getEntregue()){
                r = true;
            }
        }
        return r;
    }

    public Encomenda getEncomenda(String e) {
        Encomenda enc = new Encomenda();
        Iterator<Encomenda> it = listenc.iterator();
        boolean found = false;
        while(it.hasNext() && !found){
            Encomenda en = it.next();
            if(en.getCodenc() == e){
                found = true;
                enc = en;
            }

        }
        return enc;
    }

    public void addPedido(Encomenda e){
        this.pedidos.add(e);
    }

    public void rmPedido(Encomenda e){
        this.pedidos.remove(e);
    }

    public void addEncT(Encomenda e){
        this.listenc.add(e);
    }

    public double getClGeral(){
        double r=0;
        double size = 0;
        for(Encomenda e : this.listenc){
            if(e.getClassificacao()!=-1 && e.getEntregue()){
                r+=e.getClassificacao();
                size++;
            }
        }
        if(size==0) return 0;
        else return r/size;
    }

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

    public void encEntregue(Encomenda e, LocalDateTime fi) {
        Iterator<Encomenda> it = this.listenc.iterator();
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