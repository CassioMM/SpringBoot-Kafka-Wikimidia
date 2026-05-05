package net.javaguides.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootProducerApplication.class);

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;


    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("INICIANDO STREAM...");
        wikimediaChangesProducer.sendMenssage();

    }
}
