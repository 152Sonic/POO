public class ControladorVoluntario {
    private Lojas l;
    private Utilizadores u;

    public void run(){
        int o;
        do{
            ViewVoluntario v = new ViewVoluntario();
            v.menuVol();
            o = Input.lerInt();
            switch (o){
                case 1:

                case 2:

                default:
                    System.out.println("Opçao invalida!");
            }

        }while(o!=0);
    }
}
