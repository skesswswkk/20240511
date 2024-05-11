package com.example.flow;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

@SpringBootApplication
@RequiredArgsConstructor
public class FlowApplication implements ApplicationListener<ApplicationReadyEvent> {
//public class FlowApplication {
	private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(FlowApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		reactiveRedisTemplate.opsForValue().set("key", "value").subscribe();
	}
}
