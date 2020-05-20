import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void parse(String filename){
        List<String> linhas = lerFicheiro(filename); //alterar nome do ficheiro
        String[] linhaPartida;
        Map<String,Encomenda> enc = new TreeMap<>();
        for (String linha : linhas) {
                linhaPartida = linha.split(":", 2);
                switch(linhaPartida[0]){
                case "Utilizador":
                        Utilizador u = parseUtilizador(linhaPartida[1]); // criar um Utilizador
                        System.out.println(u.toString()); //enviar para o ecrÃ¡n apenas para teste
                        break;
                case "Loja":
                        Loja l = parseLoja(linhaPartida[1]);
                        System.out.println(l.toString());
                        break;
                case "Transportadora":
                        Transportadora t = parseTransportadora(linhaPartida[1]);
                        System.out.println(t.toString());
                        break;
                case "Encomenda":
                        Encomenda e = parseEncomenda(linhaPartida[1]);
                        enc.put(e.getCodenc(),e);
                        System.out.println(e.toString());
                        break;
                case "Voluntario":
                        Voluntario v = parseVoluntario(linhaPartida[1]);
                        System.out.println(v.toString());
                        break;
                case "Aceite":
                        String aux = parseAceite(linhaPartida[1]);
                        if (enc.containsKey(aux)) enc.get(aux).setAceites(true);
                        System.out.println("Aceites: " + aux);
                        break;
                default:
                        System.out.println("Linha invÃ¡lida.");
                        break;
                }
        }
        System.out.println("done!");
        System.out.println("\n\n\n\n");
        System.out.println(enc.toString());
  }


  public static Utilizador parseUtilizador(String input){
        String[] campos = input.split(",");
        String nome = campos[0];
        String codUtilizador = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        return new Utilizador(codUtilizador,nome, new GPS(gpsx,gpsy),new ArrayList<Encomenda>());


  }

  public static Loja parseLoja(String input){
        String[] campos = input.split(",");
        String codLoja = campos[0];
        String nomeLoja = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        return new Loja(codLoja,nomeLoja,new GPS(gpsx,gpsy), new ArrayList<Encomenda>());
  }

   public static Transportadora parseTransportadora(String input){
        String[] campos = input.split(",");
        String cod = campos[0];
        String nome  = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        int nif = Integer.parseInt(campos[4]);
        double rai = Double.parseDouble(campos[5]);
        double taxa = Double.parseDouble(campos[6]);
        return new Transportadora(cod,nome,new GPS(gpsx,gpsy),nif,rai,taxa,0.1,100, new ArrayList<Encomenda>());
  }
    public static Encomenda parseEncomenda(String input){
        String[] campos = input.split(",");
        String cod = campos[0];
        String codUser = campos[1];
        String codLoja = campos[2];
        Double peso = Double.parseDouble(campos[3]);
        String codL;
        String desc;
        double q ;
        double preco;
        int i = 4;
        ArrayList<LinhaEncomenda> res = new ArrayList<>();
        while (i+3 <= campos.length){
            codL = campos[i];
            desc = campos[i+1];
            q = Double.parseDouble(campos[i+2]);
            preco = Double.parseDouble(campos[i+3]);
            i+=4;
            LinhaEncomenda a = new LinhaEncomenda(codL,desc,q,preco);
            res.add(a);
        }
        return new Encomenda(cod,codUser,codLoja,peso, res);
  }

    public static Voluntario parseVoluntario(String input){
        String[] campos = input.split(",");
        String cod = campos[0];
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        double raio = Double.parseDouble(campos[4]);
        return new Voluntario(cod,nome,new GPS(gpsx,gpsy),raio, true, new ArrayList<>());
  }

    public static String parseAceite(String input){
        String[] campos = input.split(",");
        String cod = campos[0];
        return cod;


  }


  public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println(exc.getMessage()); }
        return lines;
  }


    public static void main(String[] args) {
        GPS g1 = new GPS(-81.554855, 84.01756);
        GPS g2 = new GPS(-81.89932, 81.5264);
        double r = 80;

        double d = g1.distancia(g2);
        boolean v = g1.isNear(g2, r);

        System.out.println(d);
        System.out.println(v);

        parse("logs2.txt");





        //ler logs






    }



}