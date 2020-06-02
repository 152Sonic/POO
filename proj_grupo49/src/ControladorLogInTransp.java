public class ControladorLogInTransp {
    private Modelo m;

    public void run() {
        int o = Input.lerInt();
        if(o==1){
            String u = Input.lerString();
            String p = Input.lerString();
            if(verificaLogin(u,p)) ControladorTransp.run();
            else System.out.println("Login errado");
        }
        else{
            String p = Input.lerString();
            String c = Input.lerString();
            String n = Input.lerString();
            double x = Input.lerDouble();
            double y = Input.lerDouble();
            double r = Input.lerDouble();
            int nif = Input.lerInt();
            double taxa = Input.lerDouble();
            double taxapeso = Input.lerDouble();
            int pesol = Input.lerInt();
            GPS gps = new GPS(x,y);
            Transportadora novo = new Transportadora(p,c,n,gps,nif,r,taxa,taxapeso,pesol);
            m.addTransportadora(novo);
        }
    }

    public boolean verificaLogin(String u, String p){ return m.verificaLogin(u,p,1);}
}
