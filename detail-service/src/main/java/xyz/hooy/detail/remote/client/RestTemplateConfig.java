package xyz.hooy.detail.remote.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @LoadBalanced
    @Bean("commentRemote")
    public RestTemplate commentRemote() {
        return new RestTemplate();
    }
}
