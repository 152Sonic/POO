public class ControladorLoja {
    private String c;   // cod loja
    private Lojas l;    // lojas
    private Utilizadores u;

    public void run(){
        int o;
        do{
            ViewLoja v = new ViewLoja();
            v.menuLoja();
            v.inst();
            o = Input.lerInt();
                switch (o){
                    case 1:
                        v.pressioneEnter();
                        v.flush();
                        String e = Input.lerString();
                        Encomenda enc = l.getEncomenda(e,c);
                        l.addEncPronta(enc,c);
                        l.rmEncPronta(enc,c);
                        break;
                    case 2:
                        v.pressioneEnter();
                        v.flush();
                        break;
                    case 3:
                        v.pressioneEnter();
                        v.flush();
                        v.opc3(l.getLoja(c).getProntas());
                        break;
                    case 4:
                        v.pressioneEnter();
                        v.flush();
                        v.opc3(l.getLoja(c).getListaEnc());
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

    public Lojas getL() {
        return l;
    }

    public void setL(Lojas l) {
        this.l = l;
    }

    public Utilizadores getU() {
        return u;
    }

    public void setU(Utilizadores u) {
        this.u = u;
    }
}




