package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> biblioteca;

    public CatalogoLivros(){
        this.biblioteca = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int ano){
        biblioteca.add(new Livro(titulo, autor, ano));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!biblioteca.isEmpty()){
            for(Livro l : biblioteca) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
        }else{
            System.out.println("A lista está vazia");
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorAno = new ArrayList<>();
        if(!biblioteca.isEmpty()) {
            for (Livro l : biblioteca) {
                if (l.getAno() >= anoInicial && l.getAno() <= anoFinal) {
                    livrosPorAno.add(l);
                }
            }
        }else{
            System.out.println("A lista está vazia");
        }
        return livrosPorAno;
    }

    public List<Livro> pesquisarPorTitulo(String titulo){
        List<Livro> livroPorTitulo = new ArrayList<>();
        if(!biblioteca.isEmpty()) {
            for (Livro l : biblioteca) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo.add(l);
                    break;
                }
            }
        }else{
            System.out.println("A lista está vazia");
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros livraria = new CatalogoLivros();

        livraria.pesquisarPorAutor("Mark Twain");
        livraria.pesquisarPorIntervaloAnos(1980, 1990);
        livraria.pesquisarPorTitulo("As intermitências da morte");

        livraria.adicionarLivro("O estranho misterioso", "Mark Twain", 1916);
        livraria.adicionarLivro("As intermitências da morte", "José Saramago", 2005);
        livraria.adicionarLivro("Caçando carneiros", "Haruki Murakami", 1982);

        System.out.println("Encontramos este(s) livro(s) deste autor: " + livraria.pesquisarPorAutor("Mark Twain"));
        System.out.println("\nEncontramos este(s) livro(s) deste intervalo de anos: " + livraria.pesquisarPorIntervaloAnos(1980, 1990));
        System.out.println("\nEncontramos este livro com este título: " + livraria.pesquisarPorTitulo("As intermitências da morte"));
    }
}
