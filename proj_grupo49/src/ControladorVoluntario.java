public class ControladorVoluntario {
    private Voluntario vol;
    private String cod;
    private Utilizadores u;

    public ControladorVoluntario(String c, Voluntario v, Utilizadores u) {
        this.vol = v;
        this.u = u;
        this.cod = c;
    }

    public void run(){
        int o;
        do{
            ViewVoluntario v = new ViewVoluntario();
            v.menuVol();
            o = Input.lerInt();
            switch (o){
                case 1:
                    if (vol.getPedidos().isEmpty()){
                        v.printVazia();
                        break;
                    }
                    else{
                        for(Encomenda e : vol.getPedidos()) {
                            v.op1(e);
                            int op;
                            v.printMenuPedidos();
                            v.inst();
                            op = Input.lerInt();
                            if (op == 1) {
                                vol.aceitaPedido(e);
                                vol.setLivre(false);
                                v.aceite();
                            }
                            else if (op == 2) {
                                vol.rejeitaPedido(e);
                                v.rejeite();
                            }
                        }
                    }
                    break;
                case 2:
                    v.opc2(vol.getList());
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
    public void op1(ViewVoluntario v, int op, Encomenda e){
        switch(op){
            case 0:
                break;
            case 1:
                vol.aceitaPedido(e);
                break;
            case 2:
                vol.rejeitaPedido(e);
                break;
            default:
                System.out.println("Opçao Invalida!");

        }
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
                vol.setNome(nome);
                break;
            case 2:
//                v.flush();
//                v.pressioneEnter();
                v.passordAntiga();
                String passAnt = Input.lerString();
                if (passAnt.equals(vol.getPass())){
                    v.passordNova();
                    String nova = Input.lerString();
                    vol.setPass(nova);
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
                vol.setGPS(lat, lon);
                break;
            case 4:
                v.altRaio();
                double raio = Input.lerDouble();
                vol.setRaio(raio);
                v.raioSuc();
                break;
            default:
                v.printError();
        }
    }
}
