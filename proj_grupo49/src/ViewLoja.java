import java.util.List;

public class ViewLoja {

    public void menuLoja(){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("|Escolha uma opção:                                                                          |");
        System.out.println("|1  -> Sinalizar uma Encomenda pronta para Transporte                                        |");
        System.out.println("|2  -> Adicionar produto                                                                     |");
        System.out.println("|3  -> Ver quantas e quais encomendas já foram entregues                                     |");
        System.out.println("|4  -> Ver encomendas a entregar                                                             |");
        System.out.println("|5  -> Consultar stock de um produto                                                         |");
        System.out.println("|6  -> Alterar dados pessoais                                                                |");
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

    public void inst(){
        System.out.println("\nEscolha a instrução: ");
    }


    public void encSine(){
        System.out.println("O codigo de encomenda a sinalizar:");
    }

        public void encSineError(){
        System.out.println("O codigo inserido não existe:");
    }

    public void opc3(List<Encomenda> e){
        System.out.println("Codigo");
        for (Encomenda es : e){
            System.out.println(es.getCodenc());
        }
    }

    public void opc4(List<Encomenda> e){
        System.out.println("Codigo");
        for (Encomenda es : e){
            if (!es.getAceites()) System.out.println(es.getCodenc());
        }
    }

    public void cunsultaStock(){
        System.out.println("Deseja consultar o stock do produto :");
    }

    public void cunsultaError(){
        System.out.println("O produto inserido não existe:");
    }

    public void consultaResult(int p){
        System.out.printf("Existem %d unidades do produto:\n", p);
    }


    public void op1(){
        System.out.println("Insira a encomenda a sinalizar para entrega:");
    }

    public void op1Error(){
        System.out.println("A encomenda inserida não existe ou não é válida");
    }


    public void op2(){
        System.out.println("Insira o Codigo do produto a adicionar:");
    }
    public void op2_2(){
        System.out.println("Insira a descrição do produto:");
    }

    public void op2_3(){
        System.out.println("Insira o peso de uma unidade do produto:");
    }
    public void op2_4(){
        System.out.println("Insira o preço unitário de um produto:");
    }



}
