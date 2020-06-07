public class Produto implements Comparable<Produto> {
            private String cod;
            private String nome;
         // private boolean medico;
            private double peso;
            private double preçouni;

            public Produto(){
                this.cod = new String();
                this.nome = new String();
                this.peso = 0;
                this.preçouni = 0;
            }

            public Produto(String c, String n, double peso, double p){
                this.cod = c;
                this.nome = n;
                this.peso = peso;
                this.preçouni = p;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreçouni() {
        return preçouni;
    }

    public void setPreçouni(double preçouni) {
        this.preçouni = preçouni;
    }

    public int compareTo(Produto p1){
        return cod.compareTo(p1.getCod());
    }
}
