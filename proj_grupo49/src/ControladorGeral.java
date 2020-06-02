public class ControladorGeral {

    public void run() {
        ViewGeral.MenuInicial();
        int o;
        do {
            o = Input.lerInt();
            switch (o) {
                case 1:
                    ControladorLogInUser.run();
                case 2:
                    ControladorLogInLoja.run();
                case 3:
                    ControladorLogInVoluntarios.run();
                case 4:
                    ControladorLogInTransp.run();
                default:
                    System.out.println("Opção invalida");
            }
        } while (o != 0);
    }
}
