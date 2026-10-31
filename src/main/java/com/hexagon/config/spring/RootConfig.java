package com.hexagon.config.spring;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(
        value = "file:./config/db-local.properties",
        encoding = "UTF-8"
)
public class RootConfig {

    // 개인 설정 파일에서 DB 접속 정보 읽기
    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource(Environment environment) {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(
                "oracle.jdbc.driver.OracleDriver"
        );

        dataSource.setJdbcUrl(
                environment.getRequiredProperty("db.url")
        );

        dataSource.setUsername(
                environment.getRequiredProperty("db.username")
        );

        dataSource.setPassword(
                environment.getRequiredProperty("db.password")
        );

        dataSource.setMaximumPoolSize(2);
        dataSource.setMinimumIdle(1);

        return dataSource;
    }

    // Flyway 실행
    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {

        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .baselineVersion("0")
                .load();
    }

    // Tomcat 없이 실행
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        RootConfig.class
                )) {

            System.out.println(
                    "===== Flyway 처리 완료 ====="
            );
        }
    }
}