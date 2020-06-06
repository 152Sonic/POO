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
            o = Input.lerInt();
            switch (o){
                case 0:
                    break;
                case 1:
                    v.codEnc();
                    String e = Input.lerString();
                    v.printLojas(m.getLojas());
                    v.codloja();
                    String l = Input.lerString();
                    String u = this.user;
                    v.quant();
                    int quantos = Input.lerInt();
                    String[] ps = new String[quantos];
                    int[] qts = new int[quantos];
                    for(; quantos>0; quantos--){
                        v.codProd();
                        String p = Input.lerString();
                        v.quantp();
                        int q = Input.lerInt();
                        ps[quantos-1] = p;
                        qts[quantos-1] = q;
                    }
                    m.addEncomendaLoja( e, l, u, ps, qts);
                    v.succes();
                case 2:



                default:
                    System.out.println("Opçao invalida!");
            }

        }while(o!=0);
    }
}
