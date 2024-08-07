package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class CarrinhoDeCompras {
    private List<Item> itemList = new ArrayList();

    public CarrinhoDeCompras() {
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList();
        if (!this.itemList.isEmpty()) {
            Iterator var3 = this.itemList.iterator();

            while(var3.hasNext()) {
                Item i = (Item)var3.next();
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }

            this.itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }

    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        if (this.itemList.isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        } else {
            double valorItem;
            for(Iterator var3 = this.itemList.iterator(); var3.hasNext(); valorTotal += valorItem) {
                Item item = (Item)var3.next();
                valorItem = item.getPreco() * (double)item.getQuantidade();
            }

            return valorTotal;
        }
    }

    public void exibirItens() {
        if (!this.itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia!");
        }

    }

    public String toString() {
        return "CarrinhoDeCompras: itemList = " + this.itemList;
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("Arroz", 5.0, 3);
        carrinhoDeCompras.adicionarItem("Feijão", 10.0, 1);
        carrinhoDeCompras.adicionarItem("Macarrão", 3.0, 1);
        carrinhoDeCompras.adicionarItem("Bolacha", 2.0, 2);
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Arroz");
        carrinhoDeCompras.exibirItens();
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}
