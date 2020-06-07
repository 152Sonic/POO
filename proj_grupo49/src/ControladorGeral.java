import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ControladorGeral {
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
        ViewGeral v = new ViewGeral();
        ControladorLogInTransp t = new ControladorLogInTransp(modelo);
        ControladorLogInVoluntarios vol = new ControladorLogInVoluntarios(modelo);
        ControladorLogInLoja l = new ControladorLogInLoja(modelo);
        ControladorLogInUser u = new ControladorLogInUser(modelo);

//        Lojas lojas = new Lojas();
//        Transportadoras transportadoras = new Transportadoras();
//        Voluntarios voluntarios = new Voluntarios();
//        Utilizadores utilizadors = new Utilizadores();
//        Map<String, Encomenda> encomendas = new TreeMap<>();
//        Set<Produto> produtos;
//        Modelo m = new Modelo(lojas,transportadoras,voluntarios,utilizadors,encomendas);
//        setModel(m);

        //boolean load = false;
        int op =-1;
        //int op1 =-1;
        v.printHeader();

        while (op!=0){
            v.menuInicial();
            System.out.println("\nEscolha a instrução: ");
            op = Input.lerInt();
            switch (op) {
                case 0:
                    v.printExit();
                    break;
                case 1:
                    v.pressioneEnter();
                    Input.lerString();
                    v.flush();
                    l.run();
                    break;
                case 2:
                    v.pressioneEnter();
                    Input.lerString();
                    v.flush();
                    u.run();
                    break;
                case 3:
                    v.pressioneEnter();
                    Input.lerString();
                    v.flush();
                    vol.run();
                    break;
                case 4:
                    v.pressioneEnter();
                    Input.lerString();
                    v.flush();
                    t.run();
                    break;
                case 5:
                    v.maisUsados(modelo.maisUsados());
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
//                    op1 = Input.lerInt();
//                    v.pressioneEnter();
//                    Input.lerString();
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
//                                        String file = Input.lerString();
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
//                                    String file2 = Input.lerString();
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
