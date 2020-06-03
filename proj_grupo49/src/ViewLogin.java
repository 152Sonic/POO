public class ViewLogin {

        public void menuLogin(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Escolha uma opção:                                                                          |");
        System.out.println("|1  -> SIGN IN                                                                               |");
        System.out.println("|2  -> SIGN UP                                                                               |");
        System.out.println("|0  -> Exit Program                                                                          |");
        System.out.println("|____________________________________________________________________________________________|");
    }

    public void printBarraN(){
        System.out.println();
    }
    public void flush(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void pressioneEnter(){
        System.out.println("\nPressione enter para continuar");
    }

    public void printExit(){
        System.out.println("\nObrigado por usar GestVendasApp!");
    }

    public void printError(){
        System.out.println("\nNão escreveu nenhuma das duas opções válidas!");
        System.out.print("Por favor tente outra vez: ");
    }


    public void LoginDeny(){
        System.out.println("Password ou ou ID incorreto!");
    }

    public void loginAccep(){
        System.out.println("Login aceite!");
    }

    public void siginD(){
        System.out.println("O ID que escolheu já existe! Por favor escolha outra opção");
    }

    public void siginA(){
        System.out.println("Conta criada com sucesso!");
    }


    public void Op(){
        System.out.println("Escolha uma opção:");
    }

    public void ID(){
            System.out.println("Insira o seu ID:");
    }

    public void pass(){
            System.out.println("Insira a palavra-passe:");
    }

    public void raio(){
            System.out.println("Insira o seu raio de ação em Km:");
    }

    public void GPS(){
            System.out.println("Insira a sua Latidude e Longitude:");
    }

    public void nome(){
            System.out.println("Insira o seu nome:");
    }

    public void nif(){
            System.out.println("Insira o seu nif:");
    }
    public void pesol(){
        System.out.println("Insira o peso limite dos carregamentos:");
    }
    public void taxa(){
        System.out.println("Insira a taxa sobre encomenda:");
    }

    public void taxapeso(){
        System.out.println("Insira a taxa sobre o peso:");
    }

    public void continuar(){
        System.out.println("Deseja prosseguir (1), Caso contrário (0):");
    }
}
