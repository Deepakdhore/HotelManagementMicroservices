package com.lcwd.user.service.UserService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced //used to help restTemplate to use HOSTNAME(HOTESERVICE,....) instead of actual host(loacalHost)
    public RestTemplate restTemplate()
    {
        return new RestTemplate(); // This is used to send HTTP requests and receive HTTP responses.
    }

    //loadbalencea is used to distribute the Load when Multiple Inctences are running
    //now u can change the port numeber and still the app will run and reconfigure automatically
}
