package com.ayo.java.assessment.infra.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResourceConversionTest {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();
    private final HttpHeaders httpHeaders = new HttpHeaders();

    @LocalServerPort
    private int port;


    @Test
    public void givenACelsiusValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double fahrenheitValue = 59.54;
        double celsiusValue = 15.3;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/temperature/metric/" + fahrenheitValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(celsiusValue), responseEntity.getBody());
    }

    @Test
    public void givenAFahrenheitValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double celsiusValue = 45.9;
        double fahrenheitValue = 114.62;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/temperature/imperial/" + celsiusValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(fahrenheitValue), responseEntity.getBody());
    }


    @Test
    public void givenAnAcreValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double acreValue = 36.9;
        double hectareValue = 14.93;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/area/metric/" + acreValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(hectareValue), responseEntity.getBody());
    }

    @Test
    public void givenAHectareValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double hectareValue = 22.22;
        double acreValue = 54.91;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/area/imperial/" + hectareValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(acreValue), responseEntity.getBody());
    }

    @Test
    public void givenAMileValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double mileValue = 500.4;
        double kilometerValue = 805.14;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/length/metric/" + mileValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(kilometerValue), responseEntity.getBody());
    }

    @Test
    public void givenKilometerValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double mileValue = 400.58;
        double kilometerValue = 644.54;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/length/imperial/" + kilometerValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(mileValue), responseEntity.getBody());
    }

    @Test
    public void givenAGallonValueToConvert_whenExecuted_thenResponseContainsCorrectLitreValueAndCorrectCode() {
        double gallonValue = 50.45;
        double litreValue = 229.35;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/volume/metric/" + gallonValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(litreValue), responseEntity.getBody());
    }

    @Test
    public void givenLitreValueToConvert_whenExecuted_thenResponseContainsCorrectGallonValueAndCorrectCode() {
        double gallonValue = 4.5;
        double litreValue = 20.4412;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/volume/imperial/" + litreValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(gallonValue), responseEntity.getBody());
    }

    @Test
    public void givenPoundValueToConvert_whenExecuted_thenResponseContainsCorrectKilogramValueAndCorrectCode() {
        double poundValue = 10.8;
        double kilogramValue = 4.90;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/weight/metric/" + poundValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(kilogramValue), responseEntity.getBody());
    }

    @Test
    public void givenKilogramValueToConvert_whenExecuted_thenResponseContainsCorrectPoundValueAndCorrectCode() {
        double poundValue = 25.2;
        double kilogramValue = 11.43;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/weight/imperial/" + kilogramValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(poundValue), responseEntity.getBody());
    }

    @Test
    public void givenAnUnknownMeasurement_whenExecuted_thenResponseWithErrorCodeAndMessage() {
        double kilogramValue = 10.8;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/test-measurement/imperial/" + kilogramValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void givenAnUnknownSystem_whenExecuted_thenResponseWithErrorCodeAndMessage() {
        double kilogramValue = 10.8;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/weight/test-system/" + kilogramValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    private String createUrlWithPort(final String uri) {
        return "http://localhost:" + port + "/convert" + uri;
    }
}
