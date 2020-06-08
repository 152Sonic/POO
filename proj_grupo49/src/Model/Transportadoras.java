package Model;

import java.util.Map;
import java.util.TreeMap;

public class Transportadoras {
    private Map<String,Transportadora> transp;

    public Transportadoras(){
        this.transp = new TreeMap<>();
    }

    public Transportadoras(Map<String,Transportadora> t){
        this.setTransportadoras(t);
    }

    public Transportadoras(Transportadoras l){
        this.setTransportadoras(l.getTransportadoras());
    }

    public Map<String,Transportadora> getTransportadoras(){
        Map<String,Transportadora> aux = new TreeMap<>();
        for(Map.Entry<String,Transportadora> l : this.transp.entrySet())
            aux.put(l.getKey(),l.getValue());
        return aux;
    }

    public void setTransportadoras(Map<String,Transportadora> lojas){
        this.transp = new TreeMap<>();
        for(Map.Entry<String,Transportadora> l : lojas.entrySet())
            this.transp.put(l.getKey(),l.getValue().clone());
    }

    public void addTransportadora(Transportadora l){
        this.transp.putIfAbsent(l.getCod(),l.clone());
    }

    public void rmTransportadora(Transportadora l){
        this.transp.remove(l.getCod());
    }

    public boolean verificaLogin(String s, String p){
        if(transp.containsKey(s))
            return transp.get(s).validaPass(p);
        else return false;
    }

    public boolean existeTransp(String t){ return this.transp.containsKey(t);}

    public Transportadora getTransportadora(String cod){
        return transp.get(cod);
    }

}
