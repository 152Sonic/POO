public class ControladorVoluntario {
    private Modelo m;
    private String cod;


    public ControladorVoluntario(String c, Modelo m) {
        this.m = m;
        this.cod = c;
    }

    public void run(){
        int o;
        do{
            ViewVoluntario v = new ViewVoluntario();
            v.menuVol();
            o = Input.lerInt();
            switch (o){
                case 0:
                    break;
                case 1:
                    if (m.getVoluntarios().getVoluntario(cod).getPedidos().isEmpty() || !m.getVoluntario(cod).getLivre()){
                        v.printVazia();
                        break;
                    }
                    else{
                        for(Encomenda e : m.getVoluntario(cod).getPedidos()) {
                            v.op1(e);
                            int op;
                            v.printMenuPedidos();
                            v.inst();
                            op = Input.lerInt();
                            if (op == 1) {
                                m.op1Voluntario_1(cod,e);
                                v.aceite();
                                break;
                            }
                            else if (op == 2) {
                                m.op1Voluntario_2(cod,e);
                                v.rejeite();
                            }
                        }
                    }
                    break;
                case 2:
                    v.opc2(m.getVoluntario(cod).getList());
                    break;
                case 3:
                    int op = -1;
                    while (op!=0) {
                        v.pressioneEnter();
                        v.flush();
                        v.printDadosAtuais(m.getVoluntario(cod));
                        v.printMenuDados();
                        v.inst();
                        op = Input.lerInt();
                        op3(v, op);
                    }
                    break;
                case 4:
                    v.op4();
                    String e = Input.lerString();
                    if(m.op4Vol(e,cod) == 1);
                    else v.printError();
                    break;
                default:
                    System.out.println("Opçao invalida!");
            }

        }while(o!=0);
    }

    public void op3(ViewVoluntario v, int op){

        switch (op){
            case 0:
                break;
            case 1:
//                v.flush();
//                v.pressioneEnter();
                v.altNome();
                String nome = Input.lerString();
                m.op3VolNome(nome,cod);
                break;
            case 2:
//                v.flush();
//                v.pressioneEnter();
                v.passordAntiga();
                String passAnt = Input.lerString();
                if (passAnt.equals(m.getVoluntario(cod).getPass())){
                    v.passordNova();
                    String nova = Input.lerString();
                    m.op3VolPass(nova,cod);
                }
                else v.passError();
                break;
            case 3:
//                v.flush();
//                v.pressioneEnter();
                v.altloc();
                double lat = Input.lerDouble();
                v.altloclon();
                double lon = Input.lerDouble();
                m.op3VolGPS(lat,lon,cod);
                break;
            case 4:
                v.altRaio();
                double raio = Input.lerDouble();
                m.op3VolRaio(raio,cod);
                v.raioSuc();
                break;
            default:
                v.printError();
        }
    }
}
