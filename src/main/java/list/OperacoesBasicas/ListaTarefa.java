package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> tarefaList = new ArrayList();

    public ListaTarefa() {
    }

    public void adicionarTarefa(String descricao) {
        this.tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList();
        Iterator var3 = this.tarefaList.iterator();

        while(var3.hasNext()) {
            Tarefa t = (Tarefa)var3.next();
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(t);
            }
        }

        this.tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return this.tarefaList.size();
    }

    public void obterDescricoesTarefas() {
        System.out.println(this.tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.adicionarTarefa("Tarefa 01");
        listaTarefa.adicionarTarefa("Tarefa 01");
        listaTarefa.adicionarTarefa("Tarefa 02");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.removerTarefa("Tarefa 01");
        System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.obterDescricoesTarefas();
    }
}
