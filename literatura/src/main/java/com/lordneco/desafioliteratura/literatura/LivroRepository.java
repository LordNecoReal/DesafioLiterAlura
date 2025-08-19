// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/LivroRepository.java
// Repositório para a entidade Livro
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    @Query("SELECT l FROM Livro l JOIN l.idiomas i WHERE i = :idioma")
    List<Livro> findByIdiomas(@Param("idioma") String idioma);
}
