package xyz.hooy.order.remote.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @LoadBalanced
    @Bean("detailRemote")
    public RestTemplate detailRemote(){
        return new RestTemplate();
    }
}
