package nu.handlar.toggle.app.facade;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import nu.handlar.toggle.app.config.JSONMapper;
import nu.handlar.toggle.app.error.CantSendRecordException;
import nu.handlar.toggle.app.model.domain.Feature;

@Slf4j
@Component
public class KafkaSender {

	private static final String CREATE_TOPIC = "feature-created";
	private final KafkaTemplate<String, Object> kafkaTemplate;
	private final JSONMapper jsonMapper;

	public KafkaSender(KafkaTemplate<String, Object> kafkaTemplate, JSONMapper jsonMapper) {
		this.kafkaTemplate = Objects.requireNonNull(kafkaTemplate, "kafkaTemplate");
		this.jsonMapper = Objects.requireNonNull(jsonMapper, "jsonMapper");
	}

	public void create(Feature feature) {
		try {
			SendResult<String, Object> result = kafkaTemplate.send(CREATE_TOPIC, feature.getId(), feature).get(1, TimeUnit.SECONDS);
			log.info("Sent message=[{}] with offset=[{}]", feature, result.getRecordMetadata().offset());

		} catch (Exception e) {
			throw new CantSendRecordException("Unable to send record to Kafka", e);
		}
	}
}
