package ru.job4j.s_service.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.serializer.support.SerializationFailedException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class XmlSerializer implements AbstractSerializer<String, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public String serialize(String data) {
        try {
            return xmlMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.error("сериализация объекта {} в xml-формат невозможна. Переданный объект не в формате json", data, e);
            throw new SerializationFailedException(
                    String.format("ошибка! убедитесь, что переданный объект в формате json: %s", data));
        }
    }

    @Override
    public String deserialize(String data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.error("сериализация объекта {} в json-формат невозможна. Переданный объект не в формате xml", data, e);
            throw new SerializationFailedException(
                    String.format("ошибка! убедитесь, что переданный объект в формате xml: %s", data));
        }
    }
}