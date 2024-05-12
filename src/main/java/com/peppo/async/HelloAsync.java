package com.peppo.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
@Slf4j
public class HelloAsync {

    @Async
    @SneakyThrows
    public void hello() {
        Thread.sleep(Duration.ofSeconds(2));
        log.info("hello after 2 second {}", Thread.currentThread());
    }

    @Async("singleThreadExecutor")
    @SneakyThrows
    public Future<String> hello2(final String name) {
        CompletableFuture<String> future = new CompletableFuture<>();

        Thread.sleep(Duration.ofSeconds(2));
        future.complete("hello " + name + " from thread: " + Thread.currentThread());
        return future;
    }
}
