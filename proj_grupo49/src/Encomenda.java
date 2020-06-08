
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Encomenda {
    private String codenc;
    private String coduser;
    private String codloja;
    private String transp;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private boolean medica;
    private double peso;
    private boolean aceites;
    private int classificacao;
    private boolean entregue;
    private List<LinhaEncomenda> linha;


    public Encomenda() {
        this.codenc = new String();
        this.coduser = new String();
        this.codloja = new String();
        this.transp = new String();
        this.inicio = LocalDateTime.of(0,1,1,0,0);
        this.fim = LocalDateTime.of(0,1,1,0,0);
        this.peso = 0;
        this.medica = false;
        this.aceites = false;
        this.entregue = false;
        this.classificacao = -1;
        this.linha = new ArrayList<>();

    }

    public Encomenda(String e, String u, String l, double y,List<LinhaEncomenda> li) {
        this.codenc = e;
        this.coduser = u;
        this.codloja = l;
        this.transp = new String();
        this.peso = y;
        this.inicio = LocalDateTime.of(0,1,1,0,0);
        this.fim = LocalDateTime.of(0,1,1,0,0);
        this.medica = false;
        this.aceites = false;
        this.entregue = false;
        this.classificacao = -1;
        this.setLinha(li);
    }

    public Encomenda(Encomenda e) {
        this.codenc = e.getCodenc();
        this.coduser = e.getCoduser();
        this.codloja = e.getCodloja();
        this.transp = e.getTransp();
        this.inicio = e.getDatai();
        this.fim = e.getDataf();
        this.medica = e.getMedica();
        this.peso = e.getPeso();
        this.entregue = e.getEntregue();
        this.classificacao = e.getClassificacao();
        this.setLinha(e.getLinha());
    }

    public String getCodenc() {
        return this.codenc;
    }

    public String getTransp(){ return this.transp;}

    public boolean getEntregue(){return this.entregue;}

    public boolean getMedica() {
        return medica;
    }

    public void setMedica(boolean medica) {
        this.medica = medica;
    }

    public int getClassificacao(){ return this.classificacao;}

    public String getCoduser() {
        return this.coduser;
    }

    public String getCodloja() {
        return this.codloja;
    }

    public double getPeso() {
        return this.peso;
    }

    public LocalDateTime getDatai(){ return this.inicio;}

    public LocalDateTime getDataf(){ return this.fim;}

    public List<LinhaEncomenda> getLinha() {
        List<LinhaEncomenda> aux = new ArrayList<>();
        for (LinhaEncomenda l : this.linha)
            aux.add(l);
        return aux;
    }

    public void setCodenc(String s) {
        this.codenc = s;
    }

    public void setDatai(LocalDateTime d){ this.inicio = d;}

    public void setDataf(LocalDateTime d){this.fim = d;}

    public void setTransp(String t) { this.transp = t;}

    public void setCoduser(String n) {
        this.coduser = n;
    }

    public void setEntregue(boolean b){ this.entregue = b;}

    public void setClassificacao(int c){ this.classificacao = c;}

    public void setCodloja(String l) {
        this.codloja = l;
    }

    public void setPeso(double l) {
        this.peso = l;
    }

    public void setLinha(List<LinhaEncomenda> l) {
        this.linha = new ArrayList<>();
        for (LinhaEncomenda li : l)
            this.linha.add(li);
    }

    public boolean getAceites() {
        return this.aceites;
    }

    public void setAceites(boolean aceites) {
        this.aceites = aceites;
    }

    public Encomenda clone() {
        return new Encomenda(this);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Encomenda u = (Encomenda) o;
        return this.codenc.equals(u.getCodenc()) &&
                this.coduser.equals(u.getCoduser()) &&
                this.codloja.equals(u.getCodloja()) &&
                this.peso == u.getPeso() &&
                this.linha.equals(u.getLinha());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Encomenda{");
        sb.append("codenc='").append(codenc).append('\'');
        sb.append(", coduser='").append(coduser).append('\'');
        sb.append(", codloja='").append(codloja).append('\'');
        sb.append(", peso=").append(peso);
        sb.append(", aceites=").append(aceites);
        sb.append(", linha=").append(linha);
        sb.append('}');
        return sb.toString();
    }

    public int compareTo(Encomenda e1){
        return this.getCodenc().compareTo(e1.getCodenc());
    }

    public double getPreco() {
        return this.linha.stream().mapToDouble(LinhaEncomenda::getPreco).sum();
    }

    public double getPesoLinhas() {
        return this.linha.stream().mapToDouble(LinhaEncomenda::getPeso).sum();
    }


}