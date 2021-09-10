package com.highsoft.gildedrose.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GildedRoseConfiguration {
    @Bean
    public ExceptionTranslator exceptionTranslator(MessageSource messageSource) {
        return new ExceptionTranslator(new MessageResolverImpl(messageSource));
    }

}
