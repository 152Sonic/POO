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


}
