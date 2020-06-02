public class ControladorLogInVoluntarios {
    private Modelo m;

    public void run() {
        ControladorVoluntario vol = new ControladorVoluntario();
        int o = Input.lerInt();
        if(o==1){
            String u = Input.lerString();
            String p = Input.lerString();
            if(verificaLogin(u,p)) vol.run();
            else System.out.println("Login errado");
        }
        else{
            String p = Input.lerString();
            String c = Input.lerString();
            String n = Input.lerString();
            double x = Input.lerDouble();
            double y = Input.lerDouble();
            int r = Input.lerInt();
            GPS gps = new GPS(x,y);
            Voluntario novo = new Voluntario(p,c,n,gps,r);
            m.addVoluntario(novo);
        }
    }

    public boolean verificaLogin(String u, String p){
        return m.verificaLogin(u,p,2);
    }
}
