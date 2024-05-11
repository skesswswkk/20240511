package com.example.flow.controller;

//import com.darsgateway.ViewInfo.Model.ViewInfoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class redisController {
    private final RedisTemplate<String, String> redisTemplate;

//    @PostMapping("/redisTest")
//    public ResponseEntity<?> addRedisKey(@RequestBody ) {
//        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
////        valueOperations.set(vo.getCallId(), vo.getOpenedAt());
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
    @GetMapping("/redisTest/{key}")
    public ResponseEntity<?> getRedisKey(@PathVariable String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String value = valueOperations.get(key);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
}
