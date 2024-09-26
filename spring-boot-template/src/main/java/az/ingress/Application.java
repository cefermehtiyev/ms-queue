package az.ingress;

import az.ingress.configuration.QueueProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static org.springframework.boot.SpringApplication.run;
@SpringBootApplication
@EnableConfigurationProperties(QueueProperties.class)
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }
}