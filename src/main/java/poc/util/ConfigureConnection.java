package poc.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

public class ConfigureConnection {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("wil");
        dataSource.setPassword("wil");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/medhead_poc?createDatabaseIfNotExist=true");

        return dataSource;
    }

    @Configuration
    @EnableTransactionManagement
    public class PersistenceJPAConfig{

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
                em.setDataSource(dataSource());
                em.setPackagesToScan(new String[] {
                        "model"
                });

            JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

            em.setJpaVendorAdapter(vendorAdapter);
            em.setJpaProperties(additionalProperties());

            return em;
        }

        @Bean
        public PlatformTransactionManager transactionManager(){
            JpaTransactionManager transactionManager = new JpaTransactionManager();

            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

            return  transactionManager;
        }

        @Bean
        public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
            return new PersistenceExceptionTranslationPostProcessor();
        }

        Properties additionalProperties(){
            Properties properties = new Properties();

            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

            return properties;
        }
    }

}
