package ru.job4j.s_service.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.job4j.s_service.converter.AbstractSerializer;

@Component
@AllArgsConstructor
@Slf4j
public class AllStudentsConsumer {
    private final AbstractSerializer<String, String> serializer;

    @KafkaListener(topics = "${spring.kafka.topics.all-students-topic.name}", groupId = "${spring.kafka.consumer.all-students.group-id}")
    public String listenMessage(String studentsList) {
        log.info("консьюмер начал обработку сообщения для всех студентов");
        String json = serializer.deserialize(studentsList);
        System.out.println(json);
        return json;
    }
}