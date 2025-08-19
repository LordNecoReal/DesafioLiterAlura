package com.lordneco.desafioliteratura.literatura;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
