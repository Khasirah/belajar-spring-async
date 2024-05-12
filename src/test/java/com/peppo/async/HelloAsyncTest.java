package com.peppo.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void testHelloAsync() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            helloAsync.hello();
        }

        log.info("after call helloAsync");
        Thread.sleep(Duration.ofSeconds(10));
    }

    @Test
    void testHello2() throws ExecutionException, InterruptedException {
        Future<String> future = helloAsync.hello2("haris");
        log.info("after call hello2(haris)");
        String response = future.get();
        log.info("response: {}", response);
    }
}