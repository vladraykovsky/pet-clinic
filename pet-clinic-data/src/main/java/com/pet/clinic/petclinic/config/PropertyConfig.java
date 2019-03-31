package com.pet.clinic.petclinic.config;

import com.pet.clinic.petclinic.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources( {
    @PropertySource("classpath:custom.properties"),
    @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

  @Autowired
  Environment environment;


  @Value("${guru.user}")
  String user;

  @Value("${guru.password}")
  String password;

  @Value("${guru.dburl}")
  String url;

  @Bean
  public FakeDataSource fakeDataSource(){
    System.out.println(environment.getProperty("USERNAME"));
    FakeDataSource fakeDataSource = new FakeDataSource();
    fakeDataSource.setName(user);
    fakeDataSource.setPassword(password);
    fakeDataSource.setUrl(url);
    return fakeDataSource;
  }


  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
    return propertySourcesPlaceholderConfigurer;
  }


}
