public class ControladorLogInLoja {
    private Modelo m;

    public void run() {
        ControladorLoja loja = new ControladorLoja();
        ViewLogin v = new ViewLogin();
        int o;
        do {
            v.menuLogin();
            v.Op();
            o = Input.lerInt();
            switch (o){
                case 1:

                    String u = Input.lerString();
                    String p = Input.lerString();
                    if(verificaLogin(u,p)) loja.run();
                    else System.out.println("Login errado");
                    break;
                case 2:
                    String pi = Input.lerString();
                    String c = Input.lerString();
                    String n = Input.lerString();
                    double x = Input.lerDouble();
                    double y = Input.lerDouble();
                    GPS gps = new GPS(x,y);
                    Loja novo = new Loja(pi,c,n,gps);
                    m.addLoja(novo);
                    break;
                default:
                    v.printError();
                    break;
            }
        }while (o!=0);
    }

    public boolean verificaLogin(String u, String p){
        return m.verificaLogin(u,p,0);
    }

}
