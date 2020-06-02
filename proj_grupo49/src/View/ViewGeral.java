package View;

public class ViewGeral {

    public void printHeader(){
        System.out.println("|============================================================================================|");
        System.out.println("||                                     Welcome to                                           ||");
        System.out.println("||                                      TRAZ AQUI !                                         ||");
        System.out.println("|============================================================================================|");
    }

    public void menuInicial(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Sign in / Sign up as:                                                           |");
        System.out.println("|1  -> Loja                                                                                  |");
        System.out.println("|2  -> Utilizador                                                                            |");
        System.out.println("|3  -> Voluntário                                                                            |");
        System.out.println("|4  -> Transportadora                                                                        |");
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

}
