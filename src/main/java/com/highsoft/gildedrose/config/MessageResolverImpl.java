package com.highsoft.gildedrose.config;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageResolverImpl implements MessageResolver {
    private final MessageSource messageSource;

    public MessageResolverImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String resolve(String code, Object... args) {
        return messageSource.getMessage(code, args, code, LocaleContextHolder.getLocale());
    }
}
