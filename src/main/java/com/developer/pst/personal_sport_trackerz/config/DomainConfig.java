package com.developer.pst.personal_sport_trackerz.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.developer.pst.personal_sport_trackerz")
@EnableJpaRepositories("com.developer.pst.personal_sport_trackerz")
@EnableTransactionManagement
public class DomainConfig {
}
