package com.kontrol.javaeedemo.flyway;

import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class FlywayStarter {

    @Resource(lookup = "java:global/jdbc/postgres")
    private DataSource dataSource;

    @PostConstruct
    public void initFlyway() {
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
