package com.rafael.springframework.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
