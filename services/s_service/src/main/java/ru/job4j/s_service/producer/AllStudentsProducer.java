package ru.job4j.s_service.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.job4j.s_service.converter.AbstractSerializer;
import ru.job4j.s_service.dto.StudentDto;

import java.util.List;

@Component
@Slf4j
public class AllStudentsProducer extends AbstractProducer<List<StudentDto>> {
    protected AllStudentsProducer(AbstractSerializer<String, String> serializer, KafkaTemplate<String, Object> kafkaTemplate,
                                  @Value("${spring.kafka.topics.all-students-topic.name}") String topicName) {
        super(serializer, kafkaTemplate, topicName);
    }
}