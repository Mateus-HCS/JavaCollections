package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas() {
        pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorAltura, new comparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas listaDePessoas = new OrdenacaoPessoas();

        listaDePessoas.adicionarPessoa("Mateus", 21, 1.70);
        listaDePessoas.adicionarPessoa("Miguel", 19, 1.90);

        System.out.println("Lista ordenada por idade: " + listaDePessoas.ordenarPorIdade());
        System.out.println("Lista ordenada por altura: " + listaDePessoas.ordenarPorAltura());
    }
}