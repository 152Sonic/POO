public class ControladorUser {
    private Lojas l;
    private Utilizador u;

    public void run(){
        int o;
        do{
            o = Input.lerInt();
            switch (o){
                case 1:
                    String e = Input.lerString();
                    String l = Input.lerString();
                    String u = this.u.getCod();
                    int quantos = Input.lerInt();
                    String[] ps = new String[quantos];
                    int[] qts = new int[quantos];
                    for(; quantos>0; quantos--){
                        String p = Input.lerString();
                        int q = Input.lerInt();
                        ps[quantos-1] = p;
                        qts[quantos-1] = q;
                    }
                    this.l.addEncomenda( e, l, u, ps, qts);
                case 2:


                default:
                    System.out.println("Opçao invalida!");
            }

        }while()
    }
}
