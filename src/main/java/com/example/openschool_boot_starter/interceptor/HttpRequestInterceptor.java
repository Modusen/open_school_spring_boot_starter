package com.example.openschool_boot_starter.interceptor;

import com.example.openschool_boot_starter.config.StarterProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class HttpRequestInterceptor implements HandlerInterceptor {

    private final StarterProperties props;
    private final String DELIMITER = "---------------------------------------------------------------------------------";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("PreHandle from user {}\r\nMethod: {}\r\nURL: {}\r\n{}",
                props.getUser(),
                request.getMethod(),
                request.getRequestURL(),
                DELIMITER
        );
        String requestId = UUID.randomUUID().toString();
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        request.setAttribute("requestId", requestId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("PostHandle from user {}\r\nMethod: {}\r\nURL: {}\r\nHeaders: {}\r\n{}",
                props.getUser(),
                request.getMethod(),
                request.getRequestURL(),
                response.getHeaderNames(),
                DELIMITER
        );
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        log.info("AfterCompletion from user {}\r\nMethod: {}\r\nURL: {}\r\nHeaders: {}\r\nStatusCode: {}\r\nExecutionTime: {} ms\r\n{}",
                props.getUser(),
                request.getMethod(),
                request.getRequestURL(),
                response.getHeaderNames(),
                response.getStatus(),
                executionTime,
                DELIMITER
        );
    }
}
