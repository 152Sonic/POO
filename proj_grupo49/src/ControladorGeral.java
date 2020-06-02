public class ControladorGeral {
    private Modelo modelo;

    public ControladorGeral(Modelo m){
        this.modelo  = m;
    }

    public void run() {
        Input i = new Input();
        ViewGeral v = new ViewGeral();
        ControladorLogInTransp t = new ControladorLogInTransp(modelo);
        ControladorLogInVoluntarios vol = new ControladorLogInVoluntarios(modelo);
        ControladorLogInLoja l = new ControladorLogInLoja(modelo);
        ControladorLogInUser u = new ControladorLogInUser(modelo);
        int op =-1;
        v.printHeader();

        while (op!=0){
            v.menuInicial();
            System.out.println("\nEscolha a instrução: ");
            op = Input.lerInt();
            switch (op) {
                case 0:
                    v.printExit();
                    break;
                case 1:
                    v.pressioneEnter();
                    v.flush();
                    l.run();
                    break;
                case 2:
                    v.pressioneEnter();
                    v.flush();
                    u.run();
                    break;
                case 3:
                    v.pressioneEnter();
                    v.flush();
                    vol.run();
                    break;
                case 4:
                    v.pressioneEnter();
                    v.flush();
                    t.run();
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }
}
