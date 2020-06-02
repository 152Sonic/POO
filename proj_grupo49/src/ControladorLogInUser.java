import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class ControladorLogInUser {
    private Modelo m;

    public ControladorLogInUser(Modelo m){
        this.m = m;
    }
    public void run() {
        ControladorUser user = new ControladorUser(m);
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
                    if (m.verificaLogin(u, p,3)){
                        v.loginAccep();
                        user.run(u);
                    }
                    else v.LoginDeny();
                    break;
                case 2:
                    v.ID();
                    String c = Input.lerString();
                    if(m.existeUser(c)){
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
                    GPS gps = new GPS(x, y);
                    Utilizador novo = new Utilizador(pa,c,n,gps);
                    m.addUtilizador(novo);
                    v.siginA();
                    break;
            }
        } while (o != 0);
    }


    public boolean verificaLogin(String u, String p){
        return m.verificaLogin(u,p,3);
    }


}