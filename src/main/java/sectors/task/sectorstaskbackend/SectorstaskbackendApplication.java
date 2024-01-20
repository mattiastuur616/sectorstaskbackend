package sectors.task.sectorstaskbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SectorstaskbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SectorstaskbackendApplication.class, args);
    }

}
