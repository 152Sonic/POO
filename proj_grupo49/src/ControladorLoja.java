public class ControladorLoja {
    private String c;   // cod loja
    private Modelo m;

    public ControladorLoja(String c, Modelo m) {
        this.c = c;
        this.m = m;
    }

    public void run(){
        int o;
        do{
            ViewLoja v = new ViewLoja();
            v.menuLoja();
            v.inst();
            o = Input.lerInt();
                switch (o){
                    case 0:
                        break;
                    case 1:
                        v.pressioneEnter();
                        v.flush();
                        v.op1();
                        String e = Input.lerString();
                        if(m.op1Loja(e,c) == 1) v.instExec();
                        else v.op1Error();
                        break;
                    case 2:
                        v.pressioneEnter();
                        v.flush();
                        v.addCP();
                        String p = Input.lerString();
                        if (!m.getLojas().getLoja(c).existeProd(p)) {
                            v.addDesP();
                            String des = Input.lerString();
                            v.addPeso();
                            double pr = Input.lerDouble();
                            v.addQP();
                            double q = Input.lerDouble();
                            Produto produto = new Produto(p, des, pr, q);
                            m.op2Loja(produto,c);
                        }
                        else v.addPError();
                        break;
                    case 3:
                        v.pressioneEnter();
                        v.flush();
                        v.opc3(m.getLojas().getLoja(c).getProntas());
                        break;
                    case 4:
                        v.pressioneEnter();
                        v.flush();
                        v.opc4(m.getLojas().getLoja(c).getListaEnc());
                        break;
                    case 5:
                        v.pressioneEnter();
                        v.flush();
                        v.opc5(m.getLojas().getLoja(c).getListaEnc());
                        break;
                    case 6:
                        v.pressioneEnter();
                        v.flush();
                        v.printProd(m.getLojas().getLoja(c).getStock());
                        break;
                    case 7:
                        int op = -1;
                        while (op!=0) {
                            v.flush();
                            v.printDadosAtuais(m.getLojas().getLoja(c));
                            v.pressioneEnter();
                            v.printMenuDados();
                            v.inst();
                            op = Input.lerInt();
                            op7(v, op);
                        }
                        break;
                    default:
                    System.out.println("Opçao invalida!");
            }

        }while(o!=0);
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public Modelo getM(){return this.m;}


    public void op7(ViewLoja v, int op){
        switch (op){
            case 0:
                break;
            case 1:
//                v.flush();
//                v.pressioneEnter();
                v.altNome();
                String nome = Input.lerString();
                m.op7LojaNome(nome, c);
                break;
            case 2:
//                v.flush();
//                v.pressioneEnter();
                v.passordAntiga();
                String passAnt = Input.lerString();
                if (passAnt.equals(m.getLojas().getLoja(c).getPass())){
                    v.passordNova();
                    String nova = Input.lerString();
                    m.op7LojaPass(nova,c);
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
                m.op7LojaGPS(lat,lon,c);
                break;
            default:
                v.printError();
        }
    }
}




