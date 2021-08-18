package com.dell.testapp.config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ConfigurationProperties
public class config {

    @Value( "${spring.dswrite.url}")
    private String dswriteurl;

    @Value( "${spring.dswrite.username}")
    private String dswriteusername;

    @Value( "${spring.dswrite.password}")
    private String dswritepassword;

    @Value( "${spring.dswrite.driverClassName}")
    private String dswritedriverClassName;

    @Value( "${spring.dsread.url}")
    private String dsreadurl;

    @Value( "${spring.dsread.username}")
    private String dsreadusername;

    @Value( "${spring.dsread.password}")
    private String dsreadpassword;

    @Value( "${spring.dsread.driverClassName}")
    private String dsreaddriverClassName;

    @Primary
    @Bean(name = "readdb")
    public DataSource readDataSource() {
        System.out.println("==================readdb datasource");
        return DataSourceBuilder.create()
                .driverClassName(dsreaddriverClassName)
                .url(dsreadurl)
                .username(dsreadusername)
                .password(dsreadpassword)
        .build();
    }

    @Bean(name = "readJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("readdb") DataSource read) {
        System.out.println("================readdb template");
        return new JdbcTemplate(read);
    }

    @Bean(name = "writedb")
    public DataSource writeDataSource() {
        System.out.println("===============writedb datasource");
        return  DataSourceBuilder.create()
                .driverClassName(dswritedriverClassName)
                .url(dswriteurl)
                .username(dswriteusername)
                .password(dswritepassword)
                .build();
    }

    @Bean(name = "writeJdbcTemplate")
    public JdbcTemplate writeJdbcTemplate(@Qualifier("writedb")
                                                     DataSource write) {
        System.out.println("=========================writedb template");
        return new JdbcTemplate(write);
    }
}
