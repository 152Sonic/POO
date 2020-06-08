import java.time.LocalDateTime;

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
                        v.printDadosAtuais(m.getTransportadora(this.cod));
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
                case 5:
                    op5(v,this.cod);
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
            case 7:
                t.altMedico();
                int op7 = -1;
                boolean op7b = false;
                while (!op7b){
                    op7 = Input.lerInt();
                    switch (op7){
                        case 1:
                            m.getTransportadora(cod).aceitaMedicamentos(true);
                            op7b = true;
                            break;
                        case 2:
                            m.getTransportadora(cod).aceitaMedicamentos(false);
                            op7b = true;
                        default:
                            t.printError();
                            break;
                    }
                }

            default:
                t.printError();
        }
    }

    public void op5(ViewTransp v, String cod) {
        try {
            v.print1stDate();
            v.ano();
            int y = Input.lerInt();
            v.mes();
            int m = Input.lerInt();
            v.dia();
            int d = Input.lerInt();
            v.hora();
            int h = Input.lerInt();
            v.minuto();
            int min = Input.lerInt();
            LocalDateTime date1 = LocalDateTime.of(y, m, d, h, min);

            v.print2ndDate();
            v.ano();
            int y2 = Input.lerInt();
            v.mes();
            int m2 = Input.lerInt();
            v.dia();
            int d2 = Input.lerInt();
            v.hora();
            int h2 = Input.lerInt();
            v.minuto();
            int min2 = Input.lerInt();
            LocalDateTime date2 = LocalDateTime.of(y2, m2, d2, h2, min2);

            v.printFat(date1, date2, this.m.faturado(date1, date2, this.m.getTransportadora(cod)));
        } catch (Exception e) {
            v.invalidDate();
        }
    }

}
