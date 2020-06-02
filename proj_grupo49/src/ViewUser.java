import java.util.List;

public class ViewUser {


    public void menuUser(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Escolha uma opção:                                                                          |");
        System.out.println("|1  -> Fazer Encomenda                                                                       |");
        System.out.println("|2  -> Aceitar Entrega                                                                       |");
        System.out.println("|3  -> Ver historico de encomendas                                                           |");
        System.out.println("|4  -> Classificar Serviço de entrega                                                        |");
        System.out.println("|5  -> Aletrar dados pessoais                                                                |");
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
