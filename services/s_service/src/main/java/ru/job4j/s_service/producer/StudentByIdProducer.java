package ru.job4j.s_service.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.job4j.s_service.converter.AbstractSerializer;
import ru.job4j.s_service.dto.StudentDto;

@Component
@Slf4j
public class StudentByIdProducer extends AbstractProducer<StudentDto> {

    protected StudentByIdProducer(AbstractSerializer<String, String> serializer, KafkaTemplate<String, Object> kafkaTemplate,
                                  @Value("${spring.kafka.topics.student-by-id-topic.name}") String topicName) {
        super(serializer, kafkaTemplate, topicName);
    }
}