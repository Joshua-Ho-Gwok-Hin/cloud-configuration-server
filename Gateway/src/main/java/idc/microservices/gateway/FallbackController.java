package idc.microservices.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    final static Logger logger = LoggerFactory.getLogger(FallbackController.class);

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order service is taking too long to respond or is down. Please try again later.");
    }

    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Payment service is taking too long to respond or is down. Please try again later.");
    }

    @GetMapping("/something")
    public ResponseEntity<String> createLogs() {
        logger.warn("Just checking");
        return ResponseEntity.ok().body("All Ok");
    }



}
