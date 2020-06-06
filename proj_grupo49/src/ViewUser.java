import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public void codEnc(){
        System.out.println("Introduza o código da sua encomenda:");
    }

    public void codloja(){
        System.out.println("Introduza o código da loja que pretende fazer a encomenda:");
    }

    public void quant(){
        System.out.println("Quantos produtos diferentes pretende pedir?");
    }

    public void codProd(){
        System.out.println("Introduza o código de produto:");
    }

    public void quantp(){
        System.out.println("Qual a quantidade do produto?");
    }

    public void succes(){
        System.out.println("Encomenda bem sucedida!");
    }

    public void lojaInv(){ System.out.println("Esta loja não existe, por favor insira uma loja válida!");}

    public void printLojas(Lojas l){
        System.out.println("Código           Nome da Loja\n");
        for(Map.Entry<String,Loja> loja : l.getLojas().entrySet()){
            System.out.printf("%4s           %s\n", loja.getKey(), loja.getValue().getNome());
        }
    }

    public void printProdutos(Set<Produto> p){
        System.out.println("Código           Preço           Descrição\n");
        for(Produto pr : p){
            System.out.printf("%4s             %f                %s\n", pr.getCod(), pr.getPreçouni(), pr.getNome());
        }
    }





}
