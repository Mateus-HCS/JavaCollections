package list.OperacoesBasicas;

import java.util.List;
import java.util.ArrayList;

public class CarrinhoDeCompras {
    private List<Item> carrinhoDeCompras;

    public CarrinhoDeCompras(){
        this.carrinhoDeCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinhoDeCompras.add(new Item (nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> listaParaRemover = new ArrayList<>();
        for(Item i : carrinhoDeCompras){
            if(i.getNome().equalsIgnoreCase(nome)){
                listaParaRemover.add(i);
            }
        }
        carrinhoDeCompras.removeAll(listaParaRemover);
    }

    public double calcularValorTotal(){
        double valorTotal = 0;
        for(Item i : carrinhoDeCompras){
           valorTotal += i.getPreco() * i.getQuantidade();
        }
        return valorTotal;
    }

    public void exibirItens(){
        for(Item i : carrinhoDeCompras){
            System.out.println("Nome do produto: " + i.getNome());
            System.out.println("Quantidade que está comprando: " + i.getQuantidade());
            System.out.println("Preço de cada unidade: R$" + i.getPreco());
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoCompras = new CarrinhoDeCompras();

        carrinhoCompras.adicionarItem("Fone", 60.00, 2);
        carrinhoCompras.adicionarItem("Camisa", 30.50, 4);

        carrinhoCompras.exibirItens();

        System.out.println("O valor total da compra é: R$" + carrinhoCompras.calcularValorTotal());
        System.out.println("\n");

        carrinhoCompras.removerItem("Camisa");

        carrinhoCompras.exibirItens();

        System.out.println("O valor total da compra é: " + carrinhoCompras.calcularValorTotal());
    }
}
