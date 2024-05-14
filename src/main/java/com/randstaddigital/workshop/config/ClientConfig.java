package com.randstaddigital.workshop.config;

import com.randstaddigital.workshop.api.DefaultApi;
import com.randstaddigital.workshop.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

  @Value("${bike.client.basepath}")
  private String basePath;

  @Value("${bike.client.api.key}")
  private String apiKey;

  @Bean
  @Primary
  public ApiClient apiClient() {
    var client = new ApiClient(restTemplate());
    client.setBasePath(basePath).setApiKey(apiKey);

    return client;
  }

  @Bean
  public DefaultApi defaultApi(ApiClient apiClient) {
    return new DefaultApi(apiClient);
  }

  public RestTemplate restTemplate() {
    return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
  }
}
