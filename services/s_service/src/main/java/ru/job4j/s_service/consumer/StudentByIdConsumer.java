package ru.job4j.s_service.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.job4j.s_service.converter.AbstractSerializer;

@Component
@AllArgsConstructor
@Slf4j
public class StudentByIdConsumer {
    private final AbstractSerializer<String, String> serializer;

    @KafkaListener(topics = "${spring.kafka.topics.student-by-id-topic.name}", groupId = "${spring.kafka.consumer.student-by-id.group-id}")
    public String listenMessage(String studentsList) {
        log.info("консьюмер начал обработку сообщения студента по id");
        String json = serializer.deserialize(studentsList);
        System.out.println(json);
        return json;
    }
}