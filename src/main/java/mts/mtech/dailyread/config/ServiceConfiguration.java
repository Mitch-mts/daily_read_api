package mts.mtech.dailyread.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author Mitchell Tawanda Severa
 * @created 09/06/2022 - 5:30 AM
 */
@Configuration
public class ServiceConfiguration {
  @Value("${spring.mail.host}")
  private String emailHost;
  @Value("${spring.mail.port}")
  private int emailPort;
  @Value("${spring.mail.username}")
  private String emailUsername;
  @Value("${spring.mail.password}")
  private String emailPassword;

  @Bean
  public JavaMailSender javaMailSender(){
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(emailHost);
    mailSender.setPort(emailPort);
    mailSender.setUsername(emailUsername);
    mailSender.setPassword(emailPassword);

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
  }

}
