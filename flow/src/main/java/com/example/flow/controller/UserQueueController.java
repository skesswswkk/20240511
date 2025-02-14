package com.example.flow.controller;

import com.example.flow.service.UserQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/queue")
@RequiredArgsConstructor
public class UserQueueController {
    private final UserQueueService userQueueService;

    //등록할 수 있는 API path
    @PostMapping("")
    public Mono<?> registerUser(@RequestParam(name = "user_id") Long userId) {
        return userQueueService.registerWaitQueue(userId);
    }
}
