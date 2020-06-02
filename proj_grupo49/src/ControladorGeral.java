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
        int op;
        v.printHeader();

        do {
            v.menuInicial();
            System.out.println("\nEscolha a instrução: ");
            op = Input.lerInt();
            switch (op) {
                case 1:
                    v.pressioneEnter();
                    v.flush();
                    l.run();
                    break;
                case 2:
                    u.run();
                    break;
                case 3:
                    vol.run();
                    break;
                case 4:
                    t.run();
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while (op != 0);
    }
}
