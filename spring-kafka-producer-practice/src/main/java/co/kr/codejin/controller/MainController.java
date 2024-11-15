package co.kr.codejin.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Log4j2
@RestController
public class MainController {

    private final KafkaTemplate<String,String> kafkaTemplte;

    @GetMapping("/publish/topic1")
    public String publish1(){

        for(int i=1;i<=10000;i++){
            //카프카 발행
            kafkaTemplte.send("my-topic-01","publish1-message"+i);

        }

        return "done";
    }
    @GetMapping("/publish/topic2")
    public String publish2(){
        for(int i=1;i<=100000;i++){
            kafkaTemplte.send("my-topic-02","publish2-message"+i);
        }
        return "done";
    }

    @GetMapping("/publish/topic3")
    public String publish3(){
        return "done";
    }
}
