import java.util.*;

public class Main {


    public static void main(String[] args){
         Lojas lojas = new Lojas();
         Transportadoras transportadoras = new Transportadoras();
         Voluntarios voluntarios = new Voluntarios();
         Utilizadores utilizadors = new Utilizadores();
         Map<String, Encomenda> encomendas = new TreeMap<>();
         Set<Produto> produtos;


         Modelo m = new Modelo(lojas,transportadoras,voluntarios,utilizadors,encomendas);
         m.parse("logs2.txt");


       List<LinhaEncomenda> linha = new ArrayList<>();
        Encomenda e = new Encomenda ("e44", "u7", "l58", 89, linha);
        Encomenda e1 = new Encomenda ("e784", "u7", "l58", 89, linha);
       Encomenda e2 = new Encomenda ("e823", "u7", "l58", 89, linha);
       m.addEncomenda(e);
       m.addEncomenda (e1);
       m.addEncomenda (e2);

        ControladorGeral g = new ControladorGeral(m);
        g.run();

        //ler logs






    }



}