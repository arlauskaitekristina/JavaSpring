package spring;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.LoggingExecutionTimeProperties;

@Configuration
@EnableConfigurationProperties(LoggingExecutionTimeProperties.class)
public class SpringLoggerExecutionTimeStarter {
    @Bean
    LoggingExecutionTime loggingExecutionTime(LoggingExecutionTimeProperties properties) {
        return new LoggingExecutionTime(properties);
    }
}