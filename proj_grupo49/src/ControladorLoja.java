public class ControladorLoja {
    private String c;
    private Lojas l;
    private Utilizadores u;

    public void run(){
        int o;
        do{
            ViewLoja v = new ViewLoja();
            o = Input.lerInt();
                switch (o){
                    case 1:
                        String e = Input.lerString();
                         Encomenda enc = l.getEncomenda(e,c);
                        l.addEncPronta(enc,c);
                        l.rmEncPronta(enc,c);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                default:
                    System.out.println("Opçao invalida!");
            }

        }while(o!=0);
    }
}




