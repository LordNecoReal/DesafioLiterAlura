// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/DadosRoot.java
// Record para mapear a raiz da resposta da API.
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

public record DadosRoot(@JsonAlias("results") List<DadosLivro> results) {
    public List<Object> getResults() {
        return List.of();
    }
}
