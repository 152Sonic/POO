import java.util.List;

public class ViewTransp {

    public void menuTransp(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Escolha uma opção:                                                                          |");
        System.out.println("|1  -> Aceitar Entrega                                                                       |");
        System.out.println("|2  -> Ver historico de encomendas  entregues                                                |");
        System.out.println("|3  -> Aletrar dados pessoais                                                                |");
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

    public void aceitar(){
        System.out.println("Deseja aceitar entregar a encomenda:");
    }

    public void esperaUaceitar(){
        System.out.println("Necessário aceitação do utilizador. Por favor aguarde!");
    }

    public void opc2(List<Encomenda> e){
        System.out.println("Codigo");
        for (Encomenda es : e){
            if (!es.getAceites()) System.out.println(es.getCodenc());
        }
    }

}
