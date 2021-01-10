package com.example.demo.resources;

import com.example.demo.dto.UsersDTO;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author martin
 */
@RestController
@RequestMapping("/")
public class ServerController {

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<?> get() {
        final UsersDTO r = gett();
        if (r == null) {
            return ResponseEntity.badRequest().body("MA13: error");
        }
        return ResponseEntity.ok(r);
    }

    private UsersDTO gett() {

        InstanceInfo instance = this.discoveryClient.getNextServerFromEureka("server1", false);
        if (instance == null) {
            return null;
        }

        System.out.println("MM: " + instance.getHomePageUrl());
        final Try<ResponseEntity<UsersDTO>> response = Try.of(()
                -> this.restTemplate.exchange(instance.getHomePageUrl(), HttpMethod.GET, HttpEntity.EMPTY, UsersDTO.class));

        if (response.isFailure()) {
            return null;
        }

        System.out.println("MA13-good: " + response.get().getBody());
        return response.get().getBody();
    }
}
