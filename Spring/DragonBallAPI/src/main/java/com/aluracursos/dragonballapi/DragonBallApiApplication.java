package com.aluracursos.dragonballapi;

import com.aluracursos.dragonballapi.principal.InteraccionApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DragonBallApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DragonBallApiApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        InteraccionApi interaccionApi = new InteraccionApi();
        interaccionApi.menu();
    }
}
