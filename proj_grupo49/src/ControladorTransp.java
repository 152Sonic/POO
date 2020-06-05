public class ControladorTransp {
    private String cod;
    private Transportadora transp;
    private Utilizadores u;

    public ControladorTransp(String cod, Transportadora t, Utilizadores u){
        this.cod = cod;
        this.transp = t;
        this.u = u;
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
                    if (transp.getPedidos().isEmpty()){
                        v.printVazia();
                        break;
                    }
                    else{
                        for(Encomenda e : transp.getPedidos()) {
                            v.op1(e);
                            int op;
                            v.printMenuPedidos();
                            v.inst();
                            op = Input.lerInt();
                            if (op == 1) {
                                transp.aceitaPedido(e);
                                v.aceite();
                            }
                            else if (op == 2) {
                                transp.rejeitaPedido(e);
                                v.rejeite();
                            }
                        }
                    }
                    break;

                case 2:
                    v.opc2(transp.getList());
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
                default:
                    System.out.println("Opçao invalida!");
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
                transp.setNome(nome);
                break;
            case 2:
//                v.flush();
//                v.pressioneEnter();
                t.passordAntiga();
                String passAnt = Input.lerString();
                if (passAnt.equals(transp.getPass())){
                    t.passordNova();
                    String nova = Input.lerString();
                    transp.setPass(nova);
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
                transp.setGPS(lat, lon);
                break;
            case 4:
                t.altRaio();
                double raio = Input.lerDouble();
                transp.setRaio(raio);
                t.raioSuc();
                break;
            case 5:
                t.altT();
                double taxa = Input.lerDouble();
                transp.setTaxa(taxa);
                break;
            case 6:
                t.altTP();
                double taxap = Input.lerDouble();
                transp.setTaxaPeso(taxap);
                break;
            default:
                t.printError();
        }
    }
}
