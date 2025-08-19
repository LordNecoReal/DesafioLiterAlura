// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/Livro.java
// Classe Livro, corrigida para usar o record DadosLivro e
// com o mapeamento JPA correto.
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import jakarta.persistence.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idiomas;
    private Long contagemDownloads;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro() {}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.idiomas = dadosLivro.idiomas().stream()
                .collect(Collectors.joining(", "));
        this.contagemDownloads = dadosLivro.contagemDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Long getContagemDownloads() {
        return contagemDownloads;
    }

    public void setContagemDownloads(Long contagemDownloads) {
        this.contagemDownloads = contagemDownloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", contagemDownloads=" + contagemDownloads +
                '}';
    }
}
