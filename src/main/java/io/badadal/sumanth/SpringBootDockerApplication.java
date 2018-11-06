package io.badadal.sumanth;

import io.badadal.sumanth.model.Patient;
import io.badadal.sumanth.repository.PatientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDockerApplication {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDockerApplication.class, args);
    }

    @Bean
    public InitializingBean initialData() {

        return () -> {
            patientRepository.save(new Patient("Test Patient", "BLR"));
            patientRepository.save(new Patient("Test Patient 2", "BLR"));
        };
    }
}
