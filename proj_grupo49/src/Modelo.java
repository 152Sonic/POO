import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Modelo {
    private Lojas lojas;
    private Transportadoras transportadoras;
    private Voluntarios voluntarios;
    private Utilizadores utilizadores;
    private Map<String, Encomenda> encomendas;
    private Set<Produto> produtos;




    public Modelo(Lojas lojas, Transportadoras transportadoras, Voluntarios voluntarios, Utilizadores utilizadores, Map<String, Encomenda> encomendas) {
        this.lojas = lojas;
        this.transportadoras = transportadoras;
        this.voluntarios = voluntarios;
        this.utilizadores = utilizadores;
        this.encomendas = encomendas;
        this.produtos = new TreeSet<>();
    }

    public Lojas getLojas() {
        return lojas;
    }

    public Modelo setLojas(Lojas lojas) {
        this.lojas = lojas;
        return this;
    }

    public Transportadoras getTransportadoras() {
        return transportadoras;
    }

    public Modelo setTransportadoras(Transportadoras transportadoras) {
        this.transportadoras = transportadoras;
        return this;
    }

    public Voluntarios getVoluntarios() {
        return voluntarios;
    }

    public Modelo setVoluntarios(Voluntarios voluntarios) {
        this.voluntarios = voluntarios;
        return this;
    }

    public Utilizadores getUtilizadores() {
        return utilizadores;
    }

    public Modelo setUtilizadores(Utilizadores utilizadores) {
        this.utilizadores = utilizadores;
        return this;
    }

    public Map<String, Encomenda> getEncomendas() {
        return encomendas;
    }

    public Modelo setEncomendas(Map<String, Encomenda> encomendas) {
        this.encomendas = encomendas;
        return this;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public Modelo setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public void addLoja(Loja l){
        this.lojas.addLoja(l);
    }
    public void addUtilizador(Utilizador u){ this.utilizadores.addUtilizador(u);}
    public void addVoluntario(Voluntario v) { this.voluntarios.addVoluntario(v);}
    public void addTransportadora(Transportadora t) { this.transportadoras.addTransportadora(t);}
    public Encomenda getEncomenda(String e) { return this.encomendas.get(e);}

    public boolean existeLoja(String c){ return this.lojas.existeLoja(c);}
    public boolean existeTransp(String c){ return this.transportadoras.existeTransp(c);}
    public boolean existeUser(String c){ return this.utilizadores.existeUser(c);}
    public boolean existeVol(String c){ return this.voluntarios.existeVol(c);}


    public boolean verificaLogin(String u ,String p, int param){
        boolean ret = false;
        switch (param){
            case 0:
                ret = lojas.verificaLogin(u,p);
                break;
            case 1:
                ret = transportadoras.verificaLogin(u,p);
                break;
            case 2:
                ret = voluntarios.verificaLogin(u,p);
                break;
            case 3:
                ret = utilizadores.verificaLogin(u,p);
                break;
            default:
                ret=false;
                break;
        }
        return ret;
    }

    /*
    public void addUtilizador(Utilizador u){
        utilizadors.addUtilizador(u);
    }
    */


    public void addEncomendaLoja( String e,String l,String u,String[] ps,int[] qts){
        lojas.addEncomenda(e,l,u,ps,qts);
    }


    public void parse(String filename) {
        List<String> linhas = lerFicheiro(filename); //alterar nome do ficheiro
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) {
                case "Utilizador":
                    Utilizador u = parseUtilizador(linhaPartida[1]); // criar um Utilizador
                    utilizadores.addUtilizador(u);
                   // System.out.println(u.toString()); //enviar para o ecrÃ¡n apenas para teste
                    break;
                case "Loja":
                    Loja l = parseLoja(linhaPartida[1]);
                    lojas.addLoja(l);
                  //  System.out.println(l.toString());
                    break;
                case "Transportadora":
                    Transportadora t = parseTransportadora(linhaPartida[1]);
                    transportadoras.addTransportadora(t);
                   // System.out.println(t.toString());
                    break;
                case "Encomenda":
                    Encomenda e = parseEncomenda(linhaPartida[1]);
                    encomendas.put(e.getCodenc(), e);

                   // System.out.println(e.toString());
                    break;
                case "Voluntario":
                    Voluntario v = parseVoluntario(linhaPartida[1]);
                    voluntarios.addVoluntario(v);
                   // System.out.println(v.toString());
                    break;
                case "Aceite":
                    String aux = parseAceite(linhaPartida[1]);
                    if (encomendas.containsKey(aux)) encomendas.get(aux).setAceites(true);
                   // System.out.println("Aceites: " + aux);
                    break;
                default:
                    System.out.println("Linha invÃ¡lida.");
                    break;
            }
            for (Map.Entry<String,Encomenda> e : this.encomendas.entrySet()){
                //if (e.getValue().getAceites()){
                    lojas.addEncomendaParse(e.getValue().getCodloja(), e.getValue());
                    utilizadores.addEncomendaParse(e.getValue().getCoduser(), e.getValue());
                //}
            }
            for (Map.Entry<String,Loja> l: lojas.getLojas().entrySet()){
                lojas.addProdutosLoja(l.getKey(), (TreeSet<Produto>) produtos);
            }
        }
        System.out.println("done!");
        System.out.println("\n\n\n\n");
        //System.out.println(encomendas.toString());
    }


    public static Utilizador parseUtilizador(String input) {
        String[] campos = input.split(",");
        String nome = campos[1];
        String codUtilizador = campos[0];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        return new Utilizador(codUtilizador, nome, new GPS(gpsx, gpsy), new ArrayList<Encomenda>());


    }

    public static Loja parseLoja(String input) {
        String[] campos = input.split(",");
        String codLoja = campos[0];
        String nomeLoja = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        return new Loja(codLoja, nomeLoja, new GPS(gpsx, gpsy), new ArrayList<Encomenda>(), new ArrayList<Encomenda>());
    }

    public static Transportadora parseTransportadora(String input) {
        String[] campos = input.split(",");
        String cod = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        int nif = Integer.parseInt(campos[4]);
        double rai = Double.parseDouble(campos[5]);
        double taxa = Double.parseDouble(campos[6]);
        return new Transportadora(cod, nome, new GPS(gpsx, gpsy), nif, rai, taxa, 0.1, 100, new ArrayList<Encomenda>());
    }

    public Encomenda parseEncomenda(String input) {
        String[] campos = input.split(",");
        String cod = campos[0];
        String codUser = campos[1];
        String codLoja = campos[2];
        Double peso = Double.parseDouble(campos[3]);
        String codL;
        String desc;
        double q;
        double preco;
        int i = 4;
        List<LinhaEncomenda> res = new ArrayList<>();
        while (i + 3 <= campos.length) {
            codL = campos[i];
            desc = campos[i + 1];
            q = Double.parseDouble(campos[i + 2]);
            preco = Double.parseDouble(campos[i + 3]);
            i += 4;
            LinhaEncomenda a = new LinhaEncomenda(codL, desc, q, 0, preco);
            res.add(a);
            produtos.add(new Produto(codL,desc,q,preco));
        }
        Encomenda enc =new Encomenda(cod, codUser, codLoja, peso, res);
        //lojas.addEncomendaParse(codLoja, enc);

        return enc;
    }

    public Voluntario parseVoluntario(String input) {
        String[] campos = input.split(",");
        String cod = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        double raio = Double.parseDouble(campos[4]);
        return new Voluntario(cod, nome, new GPS(gpsx, gpsy), raio, true, new ArrayList<>());
    }

    public String parseAceite(String input) {
        String[] campos = input.split(",");
        String cod = campos[0];
        //encomendas.get(cod).setAceites(true);
        return cod;


    }

    public void addEncomenda (Encomenda e){
        this.encomendas.put(e.getCodenc(),e);
        this.lojas.getLoja(e.getCodloja()).addEncomenda(e);
    }


    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8);
        } catch (IOException exc) {
            System.out.println(exc);
        }
        return lines;
    }

    public void setPossiveisEntregadores(Encomenda e){

        Loja l = this.lojas.getLoja(e.getCodloja());
        Utilizador u = this.utilizadores.getUtilizador(e.getCoduser());
        GPS cordl = l.getGPS().clone();
        GPS cordu = u.getGPS().clone();
        for(Map.Entry<String,Transportadora> t : this.transportadoras.getTransportadoras().entrySet()) {
            if (t.getValue().getGPS().isNear(cordl, t.getValue().getRaio()) && t.getValue().getGPS().isNear(cordu, t.getValue().getRaio())) {
                t.getValue().addPedido(e);
            }
        }
        for(Map.Entry<String,Voluntario> v : this.voluntarios.getVoluntarios().entrySet()) {
            if (v.getValue().getGPS().isNear(cordl, v.getValue().getRaio()) && v.getValue().getGPS().isNear(cordu, v.getValue().getRaio()) && v.getValue().getLivre()) {
                v.getValue().addPedido(e);
            }
        }

    }

    public Map<String,List<String>> getPossiveisEntregadores(Encomenda e){
        Map<String,List<String>> aux = new HashMap<>();
        Loja l = this.lojas.getLoja(e.getCodloja());
        Utilizador u = this.utilizadores.getUtilizador(e.getCoduser());
        GPS cordl = l.getGPS().clone();
        GPS cordu = u.getGPS().clone();
        aux.put("T",new ArrayList<>());
        aux.put("V", new ArrayList<>());
        for(Map.Entry<String,Transportadora> t : this.transportadoras.getTransportadoras().entrySet()) {
            if (t.getValue().getGPS().isNear(cordl, t.getValue().getRaio()) && t.getValue().getGPS().isNear(cordu, t.getValue().getRaio())) {
                aux.get("T").add(t.getValue().getCod());
            }
        }
        for(Map.Entry<String,Voluntario> v : this.voluntarios.getVoluntarios().entrySet()) {
            if (v.getValue().getGPS().isNear(cordl, v.getValue().getRaio()) && v.getValue().getGPS().isNear(cordu, v.getValue().getRaio()) && v.getValue().getLivre()) {
                aux.get("V").add(v.getValue().getCod());
            }
        }
        return aux;
    }

    public void rejeitaOutraTransp(Map<String,List<String>> map, String codt, Encomenda e){
        for(String t : map.get("T")){
            if(!t.equals(codt)){
                this.transportadoras.getTransportadora(t).rmPedido(e);
                this.transportadoras.getTransportadora(t).getEspera().remove(e);
            }
        }
        for(String v : map.get("V")){
            if(!v.equals(codt)) this.voluntarios.getVoluntario(v).rmPedido(e);
        }
        this.lojas.getLoja(e.getCodloja()).rmEncPronta(e);
        e.setAceites(true);
        e.setTransp(codt);
    }

    public Voluntario getVoluntario(String cod){
        return this.getVoluntarios().getVoluntario(cod);
    }

    public Loja getLoja(String cod){
        return this.getLojas().getLoja(cod);
    }

    public Transportadora getTransportadora(String cod){
        return this.getTransportadoras().getTransportadora(cod);
    }

    public Utilizador getUtilizador(String cod){
        return this.getUtilizadores().getUtilizador(cod);
    }

    public boolean existeProd(String cod, Set<Produto> pr){
        Iterator<Produto> it = pr.iterator();
        boolean r = false;
        while (it.hasNext() && !r){
            Produto aux = it.next();
            if (aux.getCod().equals(cod)){
                r = true;
            }
        }
        return r;
    }
    //////////////////////////////////////////// Funções básicas //////////////////////////////////////////////////////////////////

    public Set<Utilizador> maisUsados(){
        Set<Utilizador> mais= new TreeSet<>(new ComparatorUtilizador());
        this.utilizadores.maisUsados(mais);
        return mais;
        }

    public Set<Transportadora> maisUsadosT(){
        Set<Transportadora> mais= new TreeSet<>(new ComparatorTransp());
        for(Map.Entry<String,Transportadora> t: transportadoras.getTransportadoras().entrySet()){
            mais.add(t.getValue());
        }
        return mais;
    }


    //////////////////////////////////////////// Interpretador Loja ////////////////////////////////////////////////////////////////
    public int op1Loja(String e, String l){
        int r = 0;
        if(this.encomendas.containsKey(e)) {
            Encomenda enc = this.encomendas.get(e);
            if (this.lojas.getLoja(l).getListaEnc().contains(enc) && !enc.getAceites()){
                this.lojas.getLoja(l).addEncPronta(enc);
                setPossiveisEntregadores(enc);
                r=1;
            }
        }
        return r;
    }

    public void op2Loja(Produto p, String c){
        lojas.getLoja(c).addProduto(p);
    }

    public void op7LojaNome(String nome, String c){
        lojas.getLoja(c).setNome(nome);
    }

    public void op7LojaPass (String pass, String c){
        lojas.getLoja(c).setPass(pass);
    }

    public void op7LojaGPS(double x, double y, String c){
        lojas.getLoja(c).setGPS(x,y);
    }

    //////////////////////////////////////////// Interpretador Voluntario ////////////////////////////////////////////////////////////////

    public void op1Voluntario_1(String cod, Encomenda e){
        LocalDateTime i = LocalDateTime.now();
        this.getVoluntario(cod).aceitaPedido(e,i);
        this.encomendas.get(e.getCodenc()).setAceites(true);
        this.encomendas.get(e.getCodenc()).setTransp(cod);
        this.encomendas.get(e.getCodenc()).setDatai(i);
        this.getUtilizador(e.getCoduser()).encAceite(e,cod,i);
        rejeitaOutraTransp(getPossiveisEntregadores(e), cod, e);
    }

    public void op1Voluntario_2(String cod, Encomenda e){
        this.voluntarios.getVoluntario(cod).rejeitaPedido(e);
    }

    public void op3VolNome(String nome, String c){
        voluntarios.getVoluntario(c).setNome(nome);
    }

    public void op3VolPass (String pass, String c){
        voluntarios.getVoluntario(c).setPass(pass);
    }

    public void op3VolGPS(double x, double y, String c){
        voluntarios.getVoluntario(c).setGPS(x,y);
    }

    public void op3VolRaio(double x, String c){
        voluntarios.getVoluntario(c).setRaio(x);
    }

    public int op4Vol(String e, String cod){
        int r=0;
        LocalDateTime f = LocalDateTime.now();
        if(this.encomendas.containsKey(e)){
            Encomenda enc = this.encomendas.get(e);
            if(this.voluntarios.getVoluntario(cod).getList().contains(enc)){
                this.encomendas.get(e).setEntregue(true);
                this.encomendas.get(e).setDataf(f);
                this.getVoluntario(cod).encEntregue(encomendas.get(e),f);
                this.lojas.getLoja(enc.getCodloja()).setEntregue(enc,f);
                this.getUtilizador(encomendas.get(e).getCoduser()).encEntregue(encomendas.get(e),f);
                r=1;
            }
        }
        return r;
    }

    //////////////////////////////////////////// Interpretador Transportadora ////////////////////////////////////////////////////////////////

    public void op1Transp_1(String cod, Encomenda e){
        this.getTransportadora(cod).aceitaPedido(e);
        this.encomendas.get(e.getCodenc()).setAceites(true);
        this.getUtilizador(e.getCoduser()).addPedidos(e.getCodenc(),cod);
    }

    public void opTransp_2(String cod, Encomenda e){ this.getTransportadora(cod).rejeitaPedido(e);}

    public void op3TranspNome(String nome, String c){
        transportadoras.getTransportadora(c).setNome(nome);
    }

    public void op3TranspPass (String pass, String c){
        transportadoras.getTransportadora(c).setPass(pass);
    }

    public void op3TranspGPS(double x, double y, String c){
        transportadoras.getTransportadora(c).setGPS(x,y);
    }

    public void op3TranspRaio(double x, String c){
        transportadoras.getTransportadora(c).setRaio(x);
    }

    public void op3TranspTaxa(double x, String c){
        transportadoras.getTransportadora(c).setTaxa(x);
    }

    public void op3TranspTaxap(double x, String c){
        transportadoras.getTransportadora(c).setTaxaPeso(x);
    }

    public int op4Transp(String e, String cod){
        LocalDateTime f = LocalDateTime.now();
        int r=0;
        if(this.encomendas.containsKey(e)){
            Encomenda enc = this.encomendas.get(e);
            if(this.getTransportadora(cod).getList().contains(enc)){
                this.encomendas.get(e).setEntregue(true);
                this.encomendas.get(e).setDataf(f);
                getTransportadora(cod).encEntregue(encomendas.get(e),f);
                this.lojas.getLoja(enc.getCodloja()).setEntregue(enc,f);
                getTransportadora(cod).addKms(getDT(getTransportadora(cod), encomendas.get(e)));
                getUtilizador(encomendas.get(e).getCoduser()).encEntregue(encomendas.get(e),f);
                r=1;
            }
        }
        return r;
    }

    public double getDT(Transportadora t, Encomenda e){
        double d = 0;
        if(e.getEntregue()){
            d = t.getGPS().distancia(getLoja(e.getCodloja()).getGPS()) + getLoja(e.getCodloja()).getGPS().distancia(getUtilizador(e.getCoduser()).getGPS());
        }
        return d;
    }

    //////////////////////////////////////////// Interpretador Utilizador ////////////////////////////////////////////////////////////////

    public void op1User_3(Encomenda e){
        this.encomendas.put(e.getCodenc(),e.clone());
        getUtilizador(e.getCoduser()).addEncomenda(e);
        this.getLoja(e.getCodloja()).addEncomenda(e.clone());
    }

    public double getPrecoTransp(String e, String t){
        String cl = encomendas.get(e).getCodloja();
        GPS l = lojas.getLoja(cl).getGPS().clone();
        String user = encomendas.get(e).getCoduser();
        GPS us = utilizadores.getUtilizador(user).getGPS().clone();
        return this.getTransportadora(t).getPreço(l,us,encomendas.get(e).clone());
    }
    public double[] getTempoEstimado(String e, String t){
        String cl = encomendas.get(e).getCodloja();
        GPS l = lojas.getLoja(cl).getGPS().clone();
        String user = encomendas.get(e).getCoduser();
        GPS us = utilizadores.getUtilizador(user).getGPS().clone();
        double horas = this.getTransportadora(t).getTempo(l,us);
        return getTime(horas);
    }

    public void aceite(String user, String t, String e){
        LocalDateTime i = LocalDateTime.now();
        encomendas.get(e).setAceites(true);
        encomendas.get(e).setTransp(t);
        encomendas.get(e).setDatai(i);
        this.getUtilizador(user).getPedidos().remove(e);
        getUtilizador(user).encAceite(encomendas.get(e),t,i);
        rejeitaOutraTransp(getPossiveisEntregadores(encomendas.get(e)), t, encomendas.get(e));
        this.getTransportadora(t).addEncT(encomendas.get(e));
    }

    public void opUNome(String nome, String c){
        utilizadores.getUtilizador(c).setNome(nome);
    }

    public void opUPass (String pass, String c){
        utilizadores.getUtilizador(c).setPass(pass);
    }

    public void opUGPS(double x, double y, String c){
        utilizadores.getUtilizador(c).setGPS(x,y);
    }

    public void op4(String e, int cl) {
        encomendas.get(e).setClassificacao(cl);
        getUtilizador(encomendas.get(e).getCoduser()).setCl(encomendas.get(e), cl);
        char c = encomendas.get(e).getTransp().charAt(0);
        if (c == 'v') {
            getVoluntario(encomendas.get(e).getTransp()).setCl(encomendas.get(e), cl);
        } else {
            getTransportadora(encomendas.get(e).getTransp()).setCl(encomendas.get(e), cl);
        }
    }

    public double[] getTime(double horas){
        double[] a = new double[3];
        double dias = horas/24;
        double rest = dias %1;
        horas = rest *24;
        a[0] = dias - rest;
        double restH = horas %1;
        horas = horas - restH;
        double min = restH * 60 - ((restH*60)%1);
        a[1] = horas;
        a[2] = min;
        return a;
    }
}


