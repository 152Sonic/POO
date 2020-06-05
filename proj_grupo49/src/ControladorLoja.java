public class ControladorLoja {
    private String c;   // cod loja
    private Loja l;    // lojas
    private Utilizadores u;

    public ControladorLoja(String c, Loja l, Utilizadores u) {
        this.c = c;
        this.l = l;
        this.u = u;
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
                        if (l.getListaEnc().contains(e) && !l.getProntas().contains(e)) {
                            Encomenda enc = l.getEncomenda(e).clone();
                            l.addEncPronta(enc);
                            //l.rmEncPronta(enc);
                            v.instExec();
                        }
                        else v.op1Error();
                        break;
                    case 2:
                        v.pressioneEnter();
                        v.flush();
                        v.addCP();
                        String p = Input.lerString();
                        if (!l.existeProd(p)) {
                            v.addDesP();
                            String des = Input.lerString();
                            v.addPeso();
                            double pr = Input.lerDouble();
                            v.addQP();
                            double q = Input.lerDouble();
                            Produto produto = new Produto(p, des, pr, q);
                            l.addProduto(produto);
                        }
                        else v.addPError();
                        break;
                    case 3:
                        v.pressioneEnter();
                        v.flush();
                        v.opc3(l.getProntas());
                        break;
                    case 4:
                        v.pressioneEnter();
                        v.flush();
                        v.opc4(l.getListaEnc());
                        break;
                    case 5:
                        v.pressioneEnter();
                        v.flush();
                        v.opc5(l.getListaEnc());
                        break;
                    case 6:
                        v.pressioneEnter();
                        v.flush();
                        v.printProd(l.getStock());
                        break;
                    case 7:
                        int op = -1;
                        while (op!=0) {
                            v.pressioneEnter();
                            v.flush();
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

    public Loja getL() {
        return l;
    }

    public void setL(Loja l) {
        this.l = l;
    }

    public Utilizadores getU() {
        return u;
    }

    public void setU(Utilizadores u) {
        this.u = u;
    }

    public void op7(ViewLoja v, int op){

        switch (op){
            case 0:
                break;
            case 1:
//                v.flush();
//                v.pressioneEnter();
                v.altNome();
                String nome = Input.lerString();
                l.setNome(nome);
                break;
            case 2:
//                v.flush();
//                v.pressioneEnter();
                v.passordAntiga();
                String passAnt = Input.lerString();
                if (passAnt.equals(l.getPass())){
                    v.passordNova();
                    String nova = Input.lerString();
                    l.setPass(nova);
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
                l.setGPS(lat, lon);
                break;
            default:
                v.printError();
        }
    }
}




