package prj.springcrud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import prj.springcrud.db.DatabaseConnection;

@Configuration
@ComponentScan("prj.springcrud")
public class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "cleanUp")
    public DatabaseConnection databaseConnection(){
        return new DatabaseConnection();
    }
}
