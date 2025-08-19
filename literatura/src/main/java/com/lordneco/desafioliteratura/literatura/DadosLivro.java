// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/DadosLivro.java
// Record para mapear os dados do livro, incluindo o nome do campo
// 'authors' da API, garantindo que o método 'autores()' seja visível.
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DadosAutor> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Long contagemDownloads
) {
    // Este construtor e método são necessários para garantir a compatibilidade
    // e o reconhecimento do método 'autores()' pelo compilador.
    public DadosLivro(String titulo, List<DadosAutor> autores, List<String> idiomas, Long contagemDownloads) {
        this.titulo = titulo;
        this.autores = autores;
        this.idiomas = idiomas;
        this.contagemDownloads = contagemDownloads;
    }

    public List<DadosAutor> autores() {
        return autores;
    }
}
