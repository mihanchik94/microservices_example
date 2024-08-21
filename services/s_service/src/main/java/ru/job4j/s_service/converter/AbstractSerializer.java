package ru.job4j.s_service.converter;

public interface AbstractSerializer<T, S> {
    S serialize(T data);
    T deserialize(S data);
}