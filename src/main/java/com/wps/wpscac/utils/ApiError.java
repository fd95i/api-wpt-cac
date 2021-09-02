package com.wps.wpscac.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

@Builder
@Log4j2
public class ApiError {

    @JsonProperty("codigoEstado")
    private Integer status;

    @JsonProperty("marcaTemporal")
    private LocalDateTime timestamp;

    @JsonProperty("infoError")
    private String msg;

    public static ResponseEntity<Object> forException(Exception e, Integer status, HttpServletRequest req) {
        logInfo(e, status, req);
        return ResponseEntity
                .status(status)
                .body(ApiError.builder()
                .status(status)
                .timestamp(LocalDateTime.now())
                .msg(e.getMessage())
                .build());
    }

    private static void logInfo(Exception e, Integer status, HttpServletRequest req) {
        try {
            log.error("------------------- AN EXCEPTION OCCURRED ---------------------------");
            log.error("Request URL: " + req.getRequestURL() + ", Method: " + req.getMethod());
            log.error("Status resolved: " + HttpStatus.resolve(status));
            log.error("Exception Cause: " + e.getClass().getSimpleName()    );
            log.error("Exception Message: " + e.getMessage());
            log.error("Request Body: " );
            for(String s : IOUtils.toString(req.getInputStream(), Charset.defaultCharset()).split("\n"))
                log.error(s);
            log.error("------------------- END EXCEPTION OCCURRED ---------------------------");
        } catch (Exception ex) {
            log.error("Couldnt parse Request Body, got Exception: " + ex.getMessage());
        }
    }
}
