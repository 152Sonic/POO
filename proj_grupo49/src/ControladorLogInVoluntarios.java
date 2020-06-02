public class ControladorLogInVoluntarios {
    private Modelo m;

    public ControladorLogInVoluntarios(Modelo m){
        this.m = m;
    }

    public void run() {
        ControladorVoluntario vol = new ControladorVoluntario();
        ViewLogin v = new ViewLogin();
        int o;
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
                    if (m.verificaLogin(u, p,2)){
                        v.loginAccep();
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
                    break;
            }
        } while (o != 0);
    }

    public boolean verificaLogin(String u, String p){
        return m.verificaLogin(u,p,2);
    }
}
