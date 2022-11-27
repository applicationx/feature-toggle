package nu.handlar.toggle.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.ReactiveMongoTransactionManager;

@Configuration
public class MongoConfig {
	@Bean
	ReactiveMongoTransactionManager transactionManager(ReactiveMongoDatabaseFactory dbFactory) {
		return new ReactiveMongoTransactionManager(dbFactory);
	}
}
