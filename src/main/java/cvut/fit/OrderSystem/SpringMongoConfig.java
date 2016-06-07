package cvut.fit.ordersystem;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Mongo DB configuration class.
 * Created by Jakub Tuček on 3.4.2016.
 */
@Configuration
@EnableMongoRepositories
public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "librarydb";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1");
    }

}
