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
            v.inst();
            o = Input.lerInt();
            switch (o){
                case 0:
                    break;
                case 1:
                    v.codEnc();
                    String e = Input.lerString();
                    if(!m.getEncomendas().containsKey(e)) {
                        v.printLojas(m.getLojas());
                        v.codloja();
                        String l = Input.lerString();
                        List<LinhaEncomenda> linha = new ArrayList<>();
                        int op = -1;
                        while (op != 0 ) {
                            v.printProdutos(m.getProdutos());
                            v.menuEncomenda();
                            op = Input.lerInt();
                            op1(op, e, l, v, linha, m.getProdutos());
                            if (op == 4) break;
                        }

                    }
                    else v.existe();
                    break;
                case 2:
                    if(m.getUtilizador(user).getPedidos().size()<=0) break;
                    else{
                        v.printEnc(m.getUtilizador(user).getPedidos());
                        v.codEncC();
                        String ec = Input.lerString();
                        boolean ri = true;
                        while (ri) {
                            if (m.getUtilizador(user).getPedidos().size() <= 0) ri = false;
                            else if (m.getUtilizador(user).getPedidos().containsKey(ec)) {
                                v.pedTransp(ec);
                                for (String t : m.getUtilizador(user).getPedidos().get(ec)) {
                                    //falta funçao de tempo estimado
                                    v.printTransp(m.getTransportadora(t), m.getPrecoTransp(ec, t), m.getTempoEstimado(ec, t));
                                }
                                boolean r = true;
                                while (r) {
                                    v.acceptTransp();
                                    String ct = Input.lerString();
                                    if (m.getUtilizador(user).getPedidos().get(ec).contains(ct)) {
                                        m.aceite(user, ct, ec);
                                        r = false;
                                    } else v.printNonT();
                                }
                                ri = false;
                            } else v.printNonE();
                        }
                    }
                    break;
                case 3:
                    v.histEnc(m.getUtilizador(user).getEntregues());
                    break;
                case 4:
                    List<Encomenda> cl = listaCl(m.getUtilizador(user).getEntregues());
                    if(cl.size()<=0){
                        v.vazia();
                        break;
                    }
                    else {
                        v.classifica(cl);
                        String en = Input.lerString();
                        int op4 = -1;
                        while (op4 == -1) {
                            v.classificacao();
                            op4 = Input.lerInt();
                            m.op4(en, op4);
                            v.obg();
                        }
                    }
                    break;
                case 5:
                    int op5 = -1;
                    while (op5!=0) {
                        v.flush();
                        v.printDadosAtuais(m.getUtilizador(user));
                        v.pressioneEnter();
                        Input.lerString();
                        v.flush();
                        v.printMenuDados();
                        v.inst();
                        op5 = Input.lerInt();
                        opU(v, op5);
                    }
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
                    v.pressioneEnter();
                    Input.lerString();
                    v.flush();
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
                v.pressioneEnter();
                Input.lerString();
                v.flush();
                break;
            case 3:
                v.getEstadoEnc(linha);
                v.pressioneEnter();
                Input.lerString();
                v.flush();
                break;
            case 4:
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
    public void opU(ViewUser v, int op){
        switch (op){
            case 0:
                break;
            case 1:
//                v.flush();
//                v.pressioneEnter();
                v.altNome();
                String nome = Input.lerString();
                m.opUNome(nome, user);
                break;
            case 2:
//                v.flush();
//                v.pressioneEnter();
                v.passordAntiga();
                String passAnt = Input.lerString();
                if (passAnt.equals(m.getUtilizador(user).getPass())){
                    v.passordNova();
                    String nova = Input.lerString();
                    m.opUPass(nova,user);
                }
                else v.passError();
                break;
            case 3:
//                v.flush();
//                v.pressioneEnter();
                v.altloc();
                double lat = Input.lerDouble();
                v.altloclon();
                double lon = Input.lerDouble();
                m.opUGPS(lat,lon,user);
                break;
            default:
                v.printError();
        }
    }



    public List<Encomenda> listaCl(List<Encomenda> list){
        List<Encomenda> aux = new ArrayList<>();
        if(list.size() <=0) return aux;
        else{
            for(Encomenda e: list){
                if(e.getEntregue() && e.getClassificacao() ==-1)
                    aux.add(e);
            }
        }
        return aux;
    }
}


