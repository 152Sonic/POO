public class ControladorTransp {
    private String cod;
    private Modelo m;

    public ControladorTransp(String cod, Modelo m){
        this.cod = cod;
        this.m = m;
    }

    public void run(){
        int o;
        do{
            ViewTransp v = new ViewTransp();
            v.menuTransp();
            o = Input.lerInt();
            switch (o){
                case 0:
                    break;
                case 1:
                    if (m.getTransportadora(cod).getPedidos().isEmpty()){
                        v.printVazia();
                        break;
                    }
                    else{
                        for(Encomenda e : m.getTransportadora(cod).getPedidos()) {
                            v.op1(e);
                            int op;
                            v.printMenuPedidos();
                            v.inst();
                            op = Input.lerInt();
                            if (op == 1) {
                                m.op1Transp_1(cod,e);
                                v.aceite();
                            }
                            else if (op == 2) {
                                m.opTransp_2(cod,e);
                                v.rejeite();
                            }
                        }
                    }
                    break;

                case 2:
                    v.opc2(m.getTransportadora(cod).getList());
                    break;
                case 3:
                    int op = -1;
                    while (op!=0) {
                        v.pressioneEnter();
                        v.flush();
                        v.printMenuDados();
                        v.inst();
                        op = Input.lerInt();
                        op3(v, op);
                    }
                    break;
                case 4:
                    v.printEntregue();
                    String e = Input.lerString();
                    if(m.op4Transp(e,cod) ==1);
                    else v.printNonE();
                        break;
                default:
                    v.printError();
                    break;
            }

        }while(o!=0);
    }


    public void op3(ViewTransp t, int op){

        switch (op){
            case 0:
                break;
            case 1:
//                v.flush();
//                v.pressioneEnter();
                t.altNome();
                String nome = Input.lerString();
                m.op3TranspNome(nome,cod);
                break;
            case 2:
//                v.flush();
//                v.pressioneEnter();
                t.passordAntiga();
                String passAnt = Input.lerString();
                if (passAnt.equals(m.getTransportadora(cod).getPass())){
                    t.passordNova();
                    String nova = Input.lerString();
                    m.op3TranspPass(nova,cod);
                }
                else t.passError();
                break;
            case 3:
//                v.flush();
//                v.pressioneEnter();
                t.altloc();
                double lat = Input.lerDouble();
                t.altloclon();
                double lon = Input.lerDouble();
                m.op3TranspGPS(lat,lon,cod);
                break;
            case 4:
                t.altRaio();
                double raio = Input.lerDouble();
                m.op3TranspRaio(raio,cod);
                t.raioSuc();
                break;
            case 5:
                t.altT();
                double taxa = Input.lerDouble();
                m.op3TranspTaxa(taxa,cod);
                break;
            case 6:
                t.altTP();
                double taxap = Input.lerDouble();
                m.op3TranspTaxap(taxap,cod);
                break;
            default:
                t.printError();
        }
    }
}
