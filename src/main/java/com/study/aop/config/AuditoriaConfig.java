package com.study.aop.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Configuration
@RequiredArgsConstructor
public class AuditoriaConfig {
    private final AuditoriaConverter auditoriaConverter;
    @Bean
    @RequestScope
    public AuditoriaDTO auditoria() throws IOException {
        return localizacao();
    }

    private AuditoriaDTO localizacao() throws IOException {
        URL ipUrl = new URL("https://api.ipify.org");
        Scanner scanner = new Scanner(ipUrl.openStream());
        String ip = scanner.nextLine();
        scanner.close();

        URL geoUrl = new URL("https://ipwhois.app/json/" + ip);
        HttpURLConnection conn = (HttpURLConnection) geoUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        InputStream inputStream = conn.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(inputStream);

        return auditoriaConverter.convertJsonToDTO(root.toString());
    }
}
