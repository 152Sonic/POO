import java.util.Map;
import java.util.TreeMap;

public class Lojas {
    private Map<String,Loja> lojas;

    public Lojas(){
        this.lojas = new TreeMap<>();
    }

    public Lojas(Map<String,Loja> lojas){
        this.setLojas(lojas);
    }

    public Lojas(Lojas l){
        this.setLojas(l.getLojas());
    }

    public Map<String,Loja> getLojas(){
        Map<String,Loja> aux = new TreeMap<>();
        for(Map.Entry<String,Loja> l : this.lojas.entrySet())
            aux.put(l.getKey(),l.getValue());
        return aux;
    }

    public void setLojas(Map<String,Loja> lojas){
        this.lojas = new TreeMap<>();
        for(Map.Entry<String,Loja> l : lojas.entrySet())
            this.lojas.put(l.getKey(),l.getValue().clone());
    }

    public void addLoja(Loja l){
        this.lojas.putIfAbsent(l.getCod(),l.clone());
    }

    public void rmLoja(Loja l){
        this.lojas.remove(l.getCod());
    }

    public void addEncomenda(String s, String l, String u, String[]ps, int []qt){
        this.lojas.get(l).addEncomenda(s,u,ps,qt);
    }

    public void addEncPronta(Encomenda e, String c){
        this.lojas.get(c).addEncPronta( e);
    }

    public void rmEncPronta(Encomenda e, String c){

        this.lojas.get(c).rmEncPronta(e);
    }

    public boolean verificaLogin(String s, String p){
        if(lojas.containsKey(s))
            return lojas.get(s).validaPass(p);
        else return false;
    }

    public Encomenda getEncomenda(String e, String c) {
        return this.lojas.get(c).getEncomenda(e);
    }


}
