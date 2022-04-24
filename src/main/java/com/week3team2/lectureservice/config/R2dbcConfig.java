package com.week3team2.lectureservice.config;

import com.week3team2.lectureservice.model.LectureFactory;
import com.week3team2.lectureservice.repository.LectureRepository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Slf4j
@Configuration
@EnableR2dbcRepositories
@RequiredArgsConstructor
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    private final LectureFactory lectureFactory;


    @Override
    public ConnectionFactory connectionFactory() {
        return null;
    }

    @Bean
    public CommandLineRunner setUp(LectureRepository lectureRepository) {
        return args -> {
            lectureRepository.saveAll(lectureFactory.adminSetupListBuilder()).subscribe();
        };
    }
}
