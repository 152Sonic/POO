import java.util.Map;
import java.util.TreeMap;

public class Voluntarios {
    private Map<String,Voluntario> voluntarios;

    public Voluntarios(){
        this.voluntarios = new TreeMap<>();
    }

    public Voluntarios(Map<String,Voluntario> Voluntarios){
        this.setVoluntarios(Voluntarios);
    }

    public Voluntarios(Voluntarios l){
        this.setVoluntarios(l.getVoluntarios());
    }

    public Map<String,Voluntario> getVoluntarios(){
        Map<String,Voluntario> aux = new TreeMap<>();
        for(Map.Entry<String,Voluntario> l : this.voluntarios.entrySet())
            aux.put(l.getKey(),l.getValue());
        return aux;
    }

    public void setVoluntarios(Map<String,Voluntario> Voluntarios){
        this.voluntarios = new TreeMap<>();
        for(Map.Entry<String,Voluntario> l : Voluntarios.entrySet())
            this.voluntarios.put(l.getKey(),l.getValue().clone());
    }

    public void addVoluntario(Voluntario l){
        this.voluntarios.putIfAbsent(l.getCod(),l.clone());
    }

    public void rmVoluntario(Voluntario l){
        this.voluntarios.remove(l.getCod());
    }

    public boolean verificaLogin(String s, String p){
        if(voluntarios.containsKey(s))
            return voluntarios.get(s).validaPass(p);
        else return false;
    }

    public boolean existeVol(String c){ return this.voluntarios.containsKey(c);}

    public Voluntario getVoluntario(String c){ return this.voluntarios.get(c);}
}
