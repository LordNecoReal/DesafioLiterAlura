// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/DadosAutor.java
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") Integer anoNascimento,
        @JsonAlias("death_year") Integer anoMorte
) {
}
