package org.smartvert.smartvert.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter octetStreamJsonConverter = new MappingJackson2HttpMessageConverter();
        octetStreamJsonConverter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_JSON));
        converters.add(0, octetStreamJsonConverter);
    }
}
