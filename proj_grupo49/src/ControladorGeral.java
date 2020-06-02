public class ControladorGeral {

    public void run() {
        ViewGeral v = new ViewGeral();
        ControladorLogInTransp t = new ControladorLogInTransp();
        ControladorLogInVoluntarios vol = new ControladorLogInVoluntarios();
        ControladorLogInLoja l = new ControladorLogInLoja();
        ControladorLogInUser u = new ControladorLogInUser();
        v.menuInicial();
        int o;
        do {
            o = Input.lerInt();
            switch (o) {
                case 1:
                    l.run();
                case 2:
                    u.run();
                case 3:
                    vol.run();
                case 4:
                    t.run();
                default:
                    System.out.println("Opção invalida");
            }
        } while (o != 0);
    }
}
