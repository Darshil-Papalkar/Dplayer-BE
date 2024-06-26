package com.dplay.dplayer.loggers;

import com.dplay.dplayer.utils.logger.LoggingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseBodyInterceptor implements ResponseBodyAdvice<Object> {

    @Autowired
    LoggingService loggingService;

    private final ObjectMapper objectMapper;

    public ResponseBodyInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    private boolean isJsonContentType(MediaType mediaType) {
        return mediaType != null && mediaType.includes(MediaType.APPLICATION_JSON);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        loggingService.displayResp(((ServletServerHttpRequest) request).getServletRequest(), ((ServletServerHttpResponse) response).getServletResponse(),body);

        if (body instanceof String && !isJsonContentType(response.getHeaders().getContentType())) {
            return "{\"message\":\"" + body + "\"}";
        }

        return body;
    }
}