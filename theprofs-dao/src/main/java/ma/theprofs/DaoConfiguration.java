package ma.theprofs;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "ma.theprofs.dao" })
@PropertySource(value = { "classpath:application.properties" })
@EnableJpaRepositories(basePackages = { "ma.theprofs.dao.repository" })
public class DaoConfiguration {
  @Autowired
  private Environment environment;

  // @Bean
  // public DataSource dataSource() {
  // DriverManagerDataSource dataSource = new DriverManagerDataSource();
  // dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
  // dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
  // dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
  // dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
  // return dataSource;
  // }

  @Bean
  public DriverManagerDataSource dataSource() throws URISyntaxException {
    URI dbUri = new URI(System.getenv("DATABASE_URL"));

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
    dataSource.setUrl(dbUrl);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    return dataSource;
  }

  @Bean
  public EntityManagerFactory entityManagerFactory() throws URISyntaxException {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("ma.theprofs.dao.model");
    factory.setDataSource(dataSource());
    factory.afterPropertiesSet();
    return factory.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager() throws URISyntaxException {
    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory());
    return txManager;
  }
}
