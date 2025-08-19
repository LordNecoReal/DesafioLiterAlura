// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/AutorRepository.java
// Repositório para a entidade Autor
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :ano AND (a.anoFalecimento > :ano OR a.anoFalecimento IS NULL)")
    List<Autor> findAutoresVivos(@Param("ano") Integer ano);
}
