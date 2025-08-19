// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/Principal.java
// Classe principal que interage com o usuário
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private LivroService livroService;
    private Scanner teclado = new Scanner(System.in);

    public Principal(LivroService livroService) {
        this.livroService = livroService;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    ***************************************************
                    1 - Buscar livro por título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    0 - Sair
                    ***************************************************
                    """;
            System.out.println(menu);
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void buscarLivroPorTitulo() {
        System.out.println("Digite o título do livro:");
        var titulo = teclado.nextLine();
        livroService.buscarLivroPorTitulo(titulo);
    }

    private void listarLivrosRegistrados() {
        livroService.listarTodosLivros();
    }

    private void listarAutoresRegistrados() {
        livroService.listarTodosAutores();
    }

    private void listarAutoresVivos() {
        System.out.println("Digite o ano para buscar autores vivos:");
        var ano = teclado.nextInt();
        teclado.nextLine();
        List<Autor> autoresVivos = livroService.listarAutoresVivos(ano);
        if (autoresVivos.isEmpty()) {
            System.out.println("Nenhum autor vivo encontrado para o ano " + ano);
        } else {
            autoresVivos.forEach(autor -> System.out.println(
                    "Nome: " + autor.getNome() +
                            ", Ano de Nascimento: " + autor.getAnoNascimento() +
                            ", Ano de Falecimento: " + (autor.getAnoFalecimento() != null ? autor.getAnoFalecimento() : "N/A")
            ));
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Digite o idioma para buscar (ex: en, es, fr):");
        var idioma = teclado.nextLine();
        List<Livro> livrosPorIdioma = livroService.listarLivrosPorIdioma(idioma);
        if (livrosPorIdioma.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o idioma " + idioma);
        } else {
            livrosPorIdioma.forEach(livro -> System.out.println(livro.getTitulo()));
        }
    }
}
