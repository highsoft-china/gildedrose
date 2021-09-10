package com.highsoft.gildedrose.controller;

import com.highsoft.gildedrose.IntegrationTest;
import com.highsoft.gildedrose.TestResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class TestControllerTest extends IntegrationTest {
    @Test
    void should_be_able_to_get_test() {
        TestResponse response = get("/tests");
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.textBody()).isEqualTo("test");
    }
}
