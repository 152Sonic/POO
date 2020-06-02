import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
                    System.out.println(u.toString()); //enviar para o ecrÃ¡n apenas para teste
                    break;
                case "Loja":
                    Loja l = parseLoja(linhaPartida[1]);
                    lojas.addLoja(l);
                    System.out.println(l.toString());
                    break;
                case "Transportadora":
                    Transportadora t = parseTransportadora(linhaPartida[1]);
                    transportadoras.addTransportadora(t);
                    System.out.println(t.toString());
                    break;
                case "Encomenda":
                    Encomenda e = parseEncomenda(linhaPartida[1]);
                    encomendas.put(e.getCodenc(), e);
                    System.out.println(e.toString());
                    break;
                case "Voluntario":
                    Voluntario v = parseVoluntario(linhaPartida[1]);
                    voluntarios.addVoluntario(v);
                    System.out.println(v.toString());
                    break;
                case "Aceite":
                    String aux = parseAceite(linhaPartida[1]);
                    if (encomendas.containsKey(aux)) encomendas.get(aux).setAceites(true);
                    System.out.println("Aceites: " + aux);
                    break;
                default:
                    System.out.println("Linha invÃ¡lida.");
                    break;
            }
        }
        System.out.println("done!");
        System.out.println("\n\n\n\n");
        System.out.println(encomendas.toString());
    }


    public static Utilizador parseUtilizador(String input) {
        String[] campos = input.split(",");
        String nome = campos[0];
        String codUtilizador = campos[1];
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

    public static Encomenda parseEncomenda(String input) {
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
        ArrayList<LinhaEncomenda> res = new ArrayList<>();
        while (i + 3 <= campos.length) {
            codL = campos[i];
            desc = campos[i + 1];
            q = Double.parseDouble(campos[i + 2]);
            preco = Double.parseDouble(campos[i + 3]);
            i += 4;
            LinhaEncomenda a = new LinhaEncomenda(codL, desc, q, 0, preco);
            res.add(a);
        }
        return new Encomenda(cod, codUser, codLoja, peso, res);
    }

    public static Voluntario parseVoluntario(String input) {
        String[] campos = input.split(",");
        String cod = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        double raio = Double.parseDouble(campos[4]);
        return new Voluntario(cod, nome, new GPS(gpsx, gpsy), raio, true, new ArrayList<>());
    }

    public static String parseAceite(String input) {
        String[] campos = input.split(",");
        String cod = campos[0];
        return cod;


    }


    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8);
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
        return lines;
    }


}