public class ControladorLogInTransp {
    private Modelo m;

    public ControladorLogInTransp(Modelo m){
        this.m = m;
    }
    public void run() {
        ControladorTransp transp = new ControladorTransp();
        ViewLogin v = new ViewLogin();
        int o,o2;
        do {
            v.menuLogin();
            v.Op();
            o = Input.lerInt();
            switch (o) {
                case 1:
                    v.ID();
                    String u = Input.lerString();
                    v.pass();
                    String p = Input.lerString();
                    if (m.verificaLogin(u,p,1)){
                        v.loginAccep();
                        transp.run();
                    }
                    else v.LoginDeny();
                    break;
                case 2:
                    v.ID();
                    String c = Input.lerString();
                    if(m.existeTransp(c)){
                        v.siginD();
                        break;
                    }
                    v.pass();
                    String pa = Input.lerString();
                    v.nome();
                    String n = Input.lerString();
                    v.GPS();
                    double x = Input.lerDouble();
                    double y = Input.lerDouble();
                    v.raio();
                    double r = Input.lerDouble();
                    v.nif();
                    int nif = Input.lerInt();
                    v.taxa();
                    double taxa = Input.lerDouble();
                    v.taxapeso();
                    double taxapeso = Input.lerDouble();
                    v.pesol();
                    int pesol = Input.lerInt();
                    GPS gps = new GPS(x, y);
                    Transportadora novo = new Transportadora(pa, c, n, gps, nif, r, taxa, taxapeso, pesol);
                    m.addTransportadora(novo);
                    v.siginA();

                    v.continuar();
                    o2 = Input.lerInt();
                    continuar(transp, o2);
                    break;
                default:
                    v.printError();
                    break;
            }
        } while (o != 0);
    }

    public boolean verificaLogin(String u, String p){ return m.verificaLogin(u,p,1);}

    public void continuar(ControladorTransp t, int o) {
        ViewLogin v = new ViewLogin();
        if (o == 1) {
            v.pressioneEnter();
            v.flush();
            t.run();
        }
    }
}
