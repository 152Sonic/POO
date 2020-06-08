package Model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Utilizadores {
    private Map<String,Utilizador> utilizadores;

    public Utilizadores(){
        this.utilizadores = new TreeMap<>();
    }

    public Utilizadores(Map<String,Utilizador> utilizadores){
        this.setUtilizadores(utilizadores);
    }

    public Utilizadores(Utilizadores l){
        this.setUtilizadores(l.getUtilizadores());
    }

    public Map<String,Utilizador> getUtilizadores() {
        Map<String, Utilizador> aux = new TreeMap<>();
        for (Map.Entry<String, Utilizador> l : this.utilizadores.entrySet())
            aux.put(l.getKey(), l.getValue());
        return aux;
    }

    public Utilizador getUtilizador(String cod){
        return this.utilizadores.get(cod);
    }

    public void setUtilizadores(Map<String,Utilizador> utilizadores){
        this.utilizadores = new TreeMap<>();
        for(Map.Entry<String,Utilizador> l : utilizadores.entrySet())
            this.utilizadores.put(l.getKey(),l.getValue().clone());
    }

    public void addUtilizador(Utilizador l){
        this.utilizadores.putIfAbsent(l.getCod(),l.clone());
    }

    public void rmUtilizador(Utilizador l){
        this.utilizadores.remove(l.getCod());
    }

    public boolean verificaLogin(String s, String p){
        if(utilizadores.containsKey(s))
            return utilizadores.get(s).validaPass(p);
        else return false;
    }

    public boolean existeUser(String c){ return this.utilizadores.containsKey(c);}


    public Set<Utilizador> maisUsados(Set<Utilizador> aux){
        for(Map.Entry<String,Utilizador> u : utilizadores.entrySet()){
            aux.add(u.getValue());
        }
        return aux;
    }

    public void addEncomendaParse(String l, Encomenda e){
        this.utilizadores.get(l).addEncomendaParse(e);
    }

}
