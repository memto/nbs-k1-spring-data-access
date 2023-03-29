### HibernateTest
- setup Deps in pom.xml 
```xml
		<!--	Spring JDBC API	-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>

		<!--	Spring Data JPA	-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
<!--			<scope>runtime</scope>-->
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
```
- config hibernate in src/resources/hibernate.cfg.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="connection.driver_class">org.postgresql.Driver</property>
        <property name="connection.url">jdbc:postgresql://localhost:9432/hibernate</property>
        <property name="connection.username">postgres</property>
        <property name="connection.password">xxx</property>

        <property name="connection.pool_size">1</property>

        <property name="dialect">org.hibernate.dialect.PostgreSQL81Dialect</property>
        <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

        <property name="show_sql">true</property>
        <property name="hbm2ddl.auto">create</property>

        <mapping class="com.nbstech.spring.basic.dataaccess.Hibernate.Dto.UserDetails" />
    </session-factory>
</hibernate-configuration>
```

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
