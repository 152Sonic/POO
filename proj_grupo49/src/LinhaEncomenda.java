/**
 * Write a description of class LinhaEncomenda here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinhaEncomenda {
    private String cod;
    private String desc;
    private double quant;
    private double valor;

    public LinhaEncomenda() {
        this.cod = new String();
        this.desc = new String();
        this.quant = 0;
        this.valor = 0;
    }

    public LinhaEncomenda(String s, String n, double x, double y) {
        this.cod = s;
        this.desc = n;
        this.quant = x;
        this.valor = y;
    }

    public LinhaEncomenda(LinhaEncomenda u) {
        this.cod = u.getCod();
        this.desc = u.getDesc();
        this.quant = u.getQuant();
        this.valor = u.getValor();
    }

    public String getCod() {
        return this.cod;
    }

    public String getDesc() {
        return this.desc;
    }

    public double getQuant() {
        return this.quant;
    }

    public double getValor() {
        return this.valor;
    }

    public void setCod(String s) {
        this.cod = s;
    }

    public void setDesc(String n) {
        this.desc = n;
    }

    public void setQuant(int l) {
        this.quant = l;
    }

    public void setValor(double l) {
        this.valor = l;
    }

    public LinhaEncomenda clone() {
        return new LinhaEncomenda(this);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        LinhaEncomenda u = (LinhaEncomenda) o;
        return this.cod.equals(u.getCod()) &&
                this.desc.equals(u.getDesc()) &&
                this.quant == u.getQuant() && this.valor == u.getValor();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinhaEncomenda{");
        sb.append("cod='").append(cod).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", quant=").append(quant);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }

    public double getPreco() {
        return quant * valor;
    }
}