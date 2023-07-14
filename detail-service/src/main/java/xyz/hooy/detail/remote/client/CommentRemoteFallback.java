package xyz.hooy.detail.remote.client;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.util.Collections;

@Slf4j
public class CommentRemoteFallback {

    /**
     * 触发熔断时调用
     */
    public static ClientHttpResponse fallbackException(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception){
        String message = "服务熔断，已降级";
        log.warn(message);
        return new SentinelClientHttpResponse(JSON.toJSONString(Collections.singletonMap("message", message)));
    }
}
