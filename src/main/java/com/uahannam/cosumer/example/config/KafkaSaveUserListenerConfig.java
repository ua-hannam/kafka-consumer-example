package com.uahannam.cosumer.example.config;

import com.uahannam.cosumer.example.dto.SaveUserKafkaDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaSaveUserListenerConfig {

    private final Environment environment;

    @Bean(name = "saveUserDataKafkaListenerContainerFactory")
    ConcurrentKafkaListenerContainerFactory<String, SaveUserKafkaDto> saveUserDataKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SaveUserKafkaDto> concurrentKafkaFactory =
                new ConcurrentKafkaListenerContainerFactory<>();

        concurrentKafkaFactory.setConsumerFactory(saveUserDataKafkaListenerConsumerFactory());

        return concurrentKafkaFactory;
    }

    @Bean(name = "saveUserDataKafkaListenerConsumerFactory")
    ConsumerFactory<String, SaveUserKafkaDto> saveUserDataKafkaListenerConsumerFactory() {
        JsonDeserializer<SaveUserKafkaDto> deserializer = new JsonDeserializer<>(SaveUserKafkaDto.class, false);

        Map<String, Object> saveUserDataConsumerConfig = Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("spring.kafka.producer.bootstrap-servers"),
                ConsumerConfig.GROUP_ID_CONFIG, "save-user-data",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer,
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest"
        );

        return new DefaultKafkaConsumerFactory<>(saveUserDataConsumerConfig, new StringDeserializer(), deserializer);
    }
}
