package com.highsoft.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = TestContainersInitializer.class)
public abstract class IntegrationTest {
    protected TestResponse lastResponse;
    protected @Resource
    TestRestTemplate testRestTemplate;

    @BeforeAll
    static void startContainers() {
    }

    protected TestResponse post(String urlTemplate, Object body, Object... vars) {
        return exchange(getRequest(urlTemplate, body, vars, HttpMethod.POST));
    }

    protected TestResponse put(String urlTemplate, Object body, Object... vars) {
        return exchange(getRequest(urlTemplate, body, vars, HttpMethod.PUT));
    }

    protected TestResponse delete(String urlTemplate, Object... vars) {
        return exchange(getRequest(urlTemplate, null, vars, HttpMethod.DELETE));
    }

    protected TestResponse get(String urlTemplate, Object... vars) {
        return get(urlTemplate, Map.of(), vars);
    }

    protected TestResponse get(String urlTemplate, Map<String, Object> params, Object... vars) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlTemplate);
        params.forEach(builder::queryParam);
        URI uri = builder.buildAndExpand(vars).encode().toUri();
        RequestEntity<?> request = new RequestEntity<>(requestHeader(), HttpMethod.GET, uri);
        return exchange(request);
    }

    private RequestEntity<?> getRequest(String urlTemplate, Object body, Object[] vars, HttpMethod put) {
        URI uri = UriComponentsBuilder.fromUriString(urlTemplate).buildAndExpand(vars).encode().toUri();
        return new RequestEntity<>(body, requestHeader(), put, uri);
    }

    private TestResponse exchange(RequestEntity<?> request) {
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        TestResponse result = new TestResponse(response);
        lastResponse = result;
        return result;
    }

    protected HttpHeaders requestHeader() {
        return new HttpHeaders();
    }
}
