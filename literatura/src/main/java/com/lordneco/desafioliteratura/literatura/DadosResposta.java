// =============================================================
// Arquivo: src/main/java/com/lordneco/desafioliteratura/literatura/DadosResposta.java
// =============================================================
package com.lordneco.desafioliteratura.literatura;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResposta(List<DadosLivro> results) {
}
