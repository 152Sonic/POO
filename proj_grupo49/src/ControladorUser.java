import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ControladorUser {
    private Modelo m;
    private String user;

    public ControladorUser(Modelo m, String r){
        this.m = m;
        this.user = r;
    }

    public void run(){
        int o;
        do{
            ViewUser v = new ViewUser();
            v.menuUser();
            o = Input.lerInt();
            switch (o){
                case 0:
                    break;
                case 1:
                    v.codEnc();
                    String e = Input.lerString();
                    v.printLojas(m.getLojas());
                    v.codloja();
                    String l = Input.lerString();
                    List<LinhaEncomenda> linha = new ArrayList<>();
                    int op=-1;
                    while(op!=0) {
                        v.printProdutos(m.getProdutos());
                        v.menuEncomenda();
                        op = Input.lerInt();
                        op1(op, e, l, v, linha, m.getProdutos());
                        if(op ==3) break;
                    }
                    break;
                case 2:
                    v.printEnc(m.getUtilizador(user).getPedidos());
                    v.codEncC();
                    String ec = Input.lerString();
                    if (m.getUtilizador(user).getPedidos().containsKey(ec)){

                        v.pedTransp(ec);
                        for (String t: m.getUtilizador(user).getPedidos().get(ec) ){
                            v.printTransp(m.getTransportadora(t),m.getPrecoTransp(ec,t),0.0);
                        }
                        v.acceptTransp();
                        String ct= Input.lerString();
//                        if (m.getUtilizador(user).getPedidos().get(ec).contains(ct)){
//
//                        }

                    }
                    //double preço = m.getPrecoTransp()

                    break;

                default:
                    System.out.println("Opçao invalida!");
            }

        }while(o!=0);
    }


    public void op1(int op, String enc, String loja, ViewUser v, List<LinhaEncomenda> linha, Set<Produto> produtos){
        switch(op){
            case 0:
                break;
            case 1:
                v.codProd();
                String p = Input.lerString();
                if(m.existeProd(p,produtos)){
                    v.quantp();
                    int q = Input.lerInt();
                    Produto pr = getProd(p,produtos);
                    LinhaEncomenda li = new LinhaEncomenda(p,pr.getNome(),q,pr.getPeso(),pr.getPreçouni() * q);
                    linha.add(li);
                }
                else{
                    v.prodInv();
                }
                break;
            case 2:
                v.remProd();
                String p1 = Input.lerString();
                if(existeProd(p1,linha));
                else{
                    v.prodInv();
                }
                break;
            case 3:
                if(linha.size()<=0){
                    v.encVazia();
                }
                else {
                    Encomenda encomenda = new Encomenda(enc,this.user,loja, getPesoLinha(linha), linha);
                    m.op1User_3(encomenda);
                    v.succes();
                }
                break;
            default:
                v.printError();
                break;
        }
    }

    public boolean existeProd(String cod, List<LinhaEncomenda> l){
        Iterator<LinhaEncomenda> it = l.iterator();
        boolean found = false;
        while(it.hasNext() && !found){
            LinhaEncomenda li = it.next();
            if(li.getCod().equals(cod)) {
                found = true;
                l.remove(li);
            }
        }
        return found;
    }

    public double getPesoLinha(List<LinhaEncomenda> linha){return linha.stream().mapToDouble(LinhaEncomenda::getPeso).sum();
    }

    public Produto getProd( String cod,Set<Produto> p){
        Iterator<Produto> it = p.iterator();
        boolean found = false;
        Produto pr = new Produto();
        while(it.hasNext() && !found){
            pr = it.next();
            if(pr.getCod().equals(cod)) {
                found = true;
            }
        }
        return pr;
    }
}


