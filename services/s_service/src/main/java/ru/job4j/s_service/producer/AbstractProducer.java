package ru.job4j.s_service.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import ru.job4j.s_service.converter.AbstractSerializer;

@Slf4j
public abstract class AbstractProducer<T> {
    protected final AbstractSerializer<String, String> serializer;
    protected final KafkaTemplate<String, Object> kafkaTemplate;
    protected final String topicName;

    protected AbstractProducer(AbstractSerializer<String, String> serializer, KafkaTemplate<String, Object> kafkaTemplate, String topicName) {
        this.serializer = serializer;
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void publish(T object) {
        log.info("отправка {} в топик {}", object.toString(), topicName);
        String xml = serializer.serialize(object.toString());
        kafkaTemplate.send(topicName, xml);
    }
}