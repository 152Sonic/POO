public class ControladorLogInVoluntarios {
    private Modelo m;

    public ControladorLogInVoluntarios(Modelo m){
        this.m = m;
    }

    public void run() {
        ViewLogin v = new ViewLogin();
        int o,o2;
        do {
            v.menuLogin();
            v.Op();
            o = Input.lerInt();
            switch (o) {
                case 0:
                    break;
                case 1:
                    v.ID();
                    String u = Input.lerString();
                    v.pass();
                    String p = Input.lerString();
                    if (m.verificaLogin(u, p,2)){
                        v.loginAccep();
                        ControladorVoluntario vol = new ControladorVoluntario(u,m.getVoluntarios().getVoluntario(u),m.getUtilizadores());
                        vol.run();
                    }
                    else v.LoginDeny();
                    break;
                case 2:
                    v.ID();
                    String c = Input.lerString();
                    if(m.existeVol(c)){
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
                    GPS gps = new GPS(x, y);
                    Voluntario novo = new Voluntario(pa,c,n,gps,r);
                    m.addVoluntario(novo);
                    v.siginA();

                    v.continuar();
                    o2 = Input.lerInt();
                    continuar(c,m.getVoluntarios().getVoluntario(c), m.getUtilizadores(), o2);
                    break;
                default:
                    v.printError();
                    break;
            }
        } while (o != 0);
    }

    public boolean verificaLogin(String u, String p){
        return m.verificaLogin(u,p,2);
    }

    public void continuar(String u, Voluntario vo, Utilizadores us, int o) {
        ViewLogin v = new ViewLogin();
        if (o == 1) {
            ControladorVoluntario vol = new ControladorVoluntario(u,m.getVoluntarios().getVoluntario(u),m.getUtilizadores());
            v.pressioneEnter();
            v.flush();
            vol.run();
        }
    }
}
