package mts.mtech.dailyread.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mitchell Tawanda Severa
 * @created 19/06/2022 - 5:52 PM
 */

public class WebConfiguration implements WebMvcConfigurer {

  /*this is used for enabling CORS request from any origin to
  any endpoint in the application*/
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**");
  }
}
