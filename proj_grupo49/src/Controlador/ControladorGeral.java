package Controlador;

import Model.*;
import View.ViewGeral;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ControladorGeral  {
    private Modelo modelo;

    public ControladorGeral(Modelo m){
        this.modelo  = m;
    }
    public ControladorGeral(){
        Lojas lojas = new Lojas();
        Transportadoras transportadoras = new Transportadoras();
        Voluntarios voluntarios = new Voluntarios();
        Utilizadores utilizadors = new Utilizadores();
        Map<String, Encomenda> encomendas = new TreeMap<>();
        Set<Produto> produtos;
        this.modelo = new Modelo(lojas,transportadoras,voluntarios,utilizadors,encomendas);
    }

    public void setModel(Modelo m){
        this.modelo = m;
    }

    public void run() {
        InterfaceInput i = new Input();
        ViewGeral v = new ViewGeral();
        ControladorLogInTransp t = new ControladorLogInTransp(modelo);
        ControladorLogInVoluntarios vol = new ControladorLogInVoluntarios(modelo);
        ControladorLogInLoja l = new ControladorLogInLoja(modelo);
        ControladorLogInUser u = new ControladorLogInUser(modelo);

//        Model.Lojas lojas = new Model.Lojas();
//        Model.Transportadoras transportadoras = new Model.Transportadoras();
//        Model.Voluntarios voluntarios = new Model.Voluntarios();
//        Model.Utilizadores utilizadors = new Model.Utilizadores();
//        Map<String, Model.Encomenda> encomendas = new TreeMap<>();
//        Set<Model.Produto> produtos;
//        Model.Modelo m = new Model.Modelo(lojas,transportadoras,voluntarios,utilizadors,encomendas);
//        setModel(m);

        //boolean load = false;
        int op =-1;
        //int op1 =-1;
        v.printHeader();

        while (op!=0){
            v.menuInicial();
            System.out.println("\nEscolha a instrução: ");
            op = i.lerInt();
            switch (op) {
                case 0:
                    v.printExit();
                    break;
                case 1:
                    v.pressioneEnter();
                    i.lerString();
                    v.flush();
                    l.run();
                    break;
                case 2:
                    v.pressioneEnter();
                    i.lerString();
                    v.flush();
                    u.run();
                    break;
                case 3:
                    v.pressioneEnter();
                    i.lerString();
                    v.flush();
                    vol.run();
                    break;
                case 4:
                    v.pressioneEnter();
                    i.lerString();
                    v.flush();
                    t.run();
                    break;
                case 5:
                    v.maisUsados(modelo.maisUsados());
                    break;
                case 6:
                    v.maisUsadosT(modelo.maisUsadosT());
                    break;
                case 7:
                    break;
                case 8:
//                    op1 = Controlador.Input.lerInt();
//                    v.pressioneEnter();
//                    Controlador.Input.lerString();
//                    v.flush();
//                    v.load();
//                    while(op1 != 0 ) {
//                        switch (op1) {
//                            case 0:
//                                break;
//                            case 1:
//                                while (!load) {
//                                    try {
//                                        v.insiraFilePath();
//                                        String file = Controlador.Input.lerString();
//                                        modelo.parse(file);
//                                        v.alreadyLoad();
//                                        load = true;
//                                        op1 = 0;
//                                    } catch (Exception e) {
//                                        v.readError();
//                                    }
//                                }
//                                break;
//                            case 2:
//                                try {
//                                    v.insiraFilePath();
//                                    String file2 = Controlador.Input.lerString();
//                                    //loadData()
//                                    v.alreadyLoad();
//                                    op1 = 0;
//                                    load = true;
//                                } catch (Exception e) {
//                                    v.readError();
//                                }
//                                break;
//                        }
//                    }
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }
}
