import java.util.List;

public class ViewTransp {

    public void menuTransp(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Escolha uma opção:                                                                          |");
        System.out.println("|1  -> Aceitar Entrega                                                                       |");
        System.out.println("|2  -> Ver historico de encomendas  entregues                                                |");
        System.out.println("|3  -> Alterar dados pessoais                                                                |");
        System.out.println("|4  -> Encomenda entregue                                                                    |");
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

    public void inst(){
        System.out.println("\nEscolha a instrução: ");
    }

    public void printVazia(){System.out.println("Nao existem pedidos de momento.");}

    public void printError(){
        System.out.println("\nNão escreveu nenhuma das duas opções válidas!");
        System.out.print("Por favor tente outra vez: ");
    }

    public void printEntregue(){System.out.println("Insira o código da encomenda que entregou:");}

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

    public void op1(Encomenda e){System.out.println(e.toString());}

    public void aceite(){
        System.out.println("Encomenda Aceite para entrega!");
    }
    public void rejeite(){System.out.println("Encomenda rejeitada");}

    public void printMenuPedidos(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Escolha uma opção:                                                                          |");
        System.out.println("|1  -> Aceitar Pedido                                                                        |");
        System.out.println("|2  -> Rejeitar Pedido                                                                       |");
        System.out.println("|____________________________________________________________________________________________|");
    }


    // ===================== Alterar dados ==============================================

    public void printMenuDados(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Escolha uma opção:                                                                          |");
        System.out.println("|1  -> Alterar Nome                                                                          |");
        System.out.println("|2  -> Alterar Password                                                                      |");
        System.out.println("|3  -> Alterar Localização                                                                   |");
        System.out.println("|4  -> Alterar raio de ação                                                                  |");
        System.out.println("|4  -> Alterar taxa                                                                          |");
        System.out.println("|4  -> Alterar taxa de peso                                                                  |");
        System.out.println("|0  -> Voltar ao menu Transportadora                                                         |");
        System.out.println("|____________________________________________________________________________________________|");
    }

    public void altNome(){
        System.out.println("Insira o nome novo:");
    }

    public void passordAntiga(){
        System.out.println("Insira a password atual:");
    }

    public void passError(){
        System.out.println("Palavra pass incorreta");
    }

    public void passordNova(){
        System.out.println("Insira a password nova:");
    }

    public void altloc(){
        System.out.println("Insira a nova latitude:");
    }

    public void altloclon(){
        System.out.println("Insira a nova longitude:");
    }

    public void altRaio(){ System.out.println("Insira o novo raio de ação:");}

    public void raioSuc(){System.out.println("Raio de ação alterado com sucesso!");}

    public void altT(){System.out.println("Insira a nova taxa:");}

    public void altTP(){System.out.println("Insira a nova taxa de peso:");}


}
