### H2 Settings for DBeaver
- How to enable H2 Database Server Mode in Spring Boot
https://stackoverflow.com/a/43276769/5715800

First edit pom.xml - delete <scope>runtime</scope> from h2 dependency:
```
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
```

Then add H2 server bean to SpringBootApplication or Configuration class:
```
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Start internal H2 server so we can query the DB from IDE
     *
     * @return H2 Server instance
     * @throws SQLException
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
```

Last - edit application.properties - set the name of the database:
```
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=123456aA@

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.settings.web-allow-others=true
```

- Connect from DBeaver
``` 
jdbc:h2:tcp://localhost:9092/mem:testdb
```
