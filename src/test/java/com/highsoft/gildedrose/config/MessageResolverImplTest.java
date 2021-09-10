package com.highsoft.gildedrose.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class MessageResolverImplTest {
    private static final String MESSAGE_FROM_MESSAGE_SOURCE = "message-from-message-source";
    private static final String CODE = "code";
    private static final Object[] ARGS = {2, 5};

    @Test
    public void can_resolve_message_correctly() {
        MessageSource messageSource = mock(MessageSource.class);
        Locale locale = LocaleContextHolder.getLocale();
        given(messageSource.getMessage(CODE, ARGS, CODE, locale)).willReturn(MESSAGE_FROM_MESSAGE_SOURCE);
        MessageResolver messageResolver = new MessageResolverImpl(messageSource);
        Assert.assertEquals(MESSAGE_FROM_MESSAGE_SOURCE, messageResolver.resolve(CODE, ARGS));
    }
}
