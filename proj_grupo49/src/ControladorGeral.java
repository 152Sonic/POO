public class ControladorGeral {

    public void run() {
        Input i = new Input();
        ViewGeral v = new ViewGeral();
        ControladorLogInTransp t = new ControladorLogInTransp();
        ControladorLogInVoluntarios vol = new ControladorLogInVoluntarios();
        ControladorLogInLoja l = new ControladorLogInLoja();
        ControladorLogInUser u = new ControladorLogInUser();
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
