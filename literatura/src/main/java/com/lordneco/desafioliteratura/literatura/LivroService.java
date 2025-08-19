// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/LivroService.java
// Serviço para lógica de negócio de Livros e Autores
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private ConsumoApi consumoApi;

    public void buscarLivroPorTitulo(String titulo) {
        // Lógica para buscar livro por título
    }

    public void listarTodosLivros() {
        // Lógica para listar todos os livros
    }

    public void listarTodosAutores() {
        // Lógica para listar todos os autores
    }

    public List<Autor> listarAutoresVivos(Integer ano) {
        return autorRepository.findAutoresVivos(ano);
    }

    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroRepository.findByIdiomas(idioma);
    }
}
