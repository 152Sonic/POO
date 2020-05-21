public class ControladorLogInLoja {
    private Lojas lojas;

    public void run() {
        int o = Input.lerInt();
        if(o==1){
            String u = Input.lerString();
            String p = Input.lerString();
            if(verificaLogin(u,p)) ControladorLoja.run();
            else System.out.println("Login errado");
        }
        else{
            String p = Input.lerString();
            String c = Input.lerString();
            String n = Input.lerString();
            double x = Input.lerDouble();
            double y = Input.lerDouble();
            GPS gps = new GPS(x,y);
            Loja novo = new Loja(p,c,n,gps);
            lojas.addLoja(novo);
        }
    }

    public boolean verificaLogin(String u, String p){
        return lojas.verificaLogin(u,p);
    }

}
