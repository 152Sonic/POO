package View;

public class ViewLogin {

        public void menuLogin(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Escolha uma opção:                                                                          |");
        System.out.println("|1  -> SIGN UP                                                                                  |");
        System.out.println("|2  -> SIGN IN                                                                            |");
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

}
