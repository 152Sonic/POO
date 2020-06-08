package Controlador;

import Model.*;
import View.ViewLogin;


public class ControladorLogInVoluntarios {
    private Modelo m;

    public ControladorLogInVoluntarios(Modelo m){
        this.m = m;
    }

    public void run() {
        ViewLogin v = new ViewLogin();
        int o,o2;
        boolean medico = false;
        boolean cenas = true;
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
                        ControladorVoluntario vol = new ControladorVoluntario(u,m);
                        v.pressioneEnter();
                        Input.lerString();
                        v.flush();
                        vol.run();
                    }
                    else {
                        v.pressioneEnter();
                        Input.lerString();
                        v.flush();
                        v.LoginDeny();
                    }
                    break;
                case 2:
                    v.IDV();
                    String c = Input.lerString();
                    if(m.existeVol(c) || c.charAt(0)!='v'){
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
                    while (!medico && cenas){
                        v.addMedico();
                        int med = Input.lerInt();
                        if (med == 1){
                            medico = true;
                        }
                        else if (med == 0) cenas = false;
                        else v.printError();
                    }

                    Voluntario novo = new Voluntario(pa,c,n,gps,r, medico);
                    v.printDadosVol(novo);
                    m.addVoluntario(novo);
                    v.siginA();

                    v.continuar();
                    o2 = Input.lerInt();
                    continuar(c,m, o2);
                    medico = false;
                    cenas = true;
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

    public void continuar(String u, Modelo m, int o) {
        ViewLogin v = new ViewLogin();
        if (o == 1) {
            ControladorVoluntario vol = new ControladorVoluntario(u,m);
            v.pressioneEnter();
            v.flush();
            vol.run();
        }
    }
}
