package com.exalt.usecase;

import com.exalt.usecase.dto.UserCreateDto;
import com.exalt.usecase.dto.UserDto;
import com.exalt.usecase.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTest {
/*
    @Autowired
    UserService service;

    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    int randomServerPort;

    @BeforeEach
    public void init() throws URISyntaxException {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setName("abd qarmash");
        userCreateDto.setEmail("abd.qarmash@test.com");
        userCreateDto.setPassword("Test Abd ");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserCreateDto> request = new HttpEntity<UserCreateDto>(userCreateDto, headers);

        URI uri = new URI("http://localhost:" + randomServerPort + "/users");

        testRestTemplate.postForEntity(uri, request, UserDto.class);

    }


    @Test
    public void testCreateUser() throws URISyntaxException {

        UserCreateDto userCreateDto = new UserCreateDto();

        userCreateDto.setName("Abd Salah");
        userCreateDto.setEmail("abd.salah@test.com");
        userCreateDto.setPassword("9345652");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserCreateDto> request = new HttpEntity<UserCreateDto>(userCreateDto, headers);

        URI uri = new URI("http://localhost:" + randomServerPort + "/users");

        ResponseEntity<UserDto> responseUser = testRestTemplate.postForEntity(uri, request, UserDto.class);

        //Verify request succeed
        assertEquals(200, responseUser.getStatusCodeValue());
        assertAll(
                () -> assertEquals(userCreateDto.getName(), responseUser.getBody().getName()),
                () -> assertEquals(userCreateDto.getEmail(), responseUser.getBody().getEmail()),
                () -> assertEquals(userCreateDto.getPassword(), responseUser.getBody().getPassword())
        );

    }

    @Test
    public void testGet() throws URISyntaxException {

        int userid = 1;
        URI uri = new URI("http://localhost:" + randomServerPort + "/users/" + userid);
        ResponseEntity<UserDto> responseUser = testRestTemplate.getForEntity(uri, UserDto.class);
        UserDto user = responseUser.getBody();
        assertEquals(200, responseUser.getStatusCodeValue());

        assertAll(() -> assertNotNull(user.getId()),
                () -> assertEquals("abd qarmash", user.getName()),
                () -> assertEquals("abd.qarmash@test.com", user.getEmail()),
                () -> assertEquals("Test Abd ", user.getPassword())
        );
    }

    @Test
    public void testGetAll() throws URISyntaxException {

        addusers();

        URI uri = new URI("http://localhost:" + randomServerPort + "/users/all");
        ResponseEntity<UserDto[]> responseUser = testRestTemplate.getForEntity(uri, UserDto[].class);
        UserDto[] users = responseUser.getBody();
        assertEquals(200, responseUser.getStatusCodeValue());
        int j = -1;
        for (UserDto user : users) {
            if (j == -1) {
                assertAll(() -> assertNotNull(user.getId()),
                        () -> assertEquals("abd qarmash", user.getName()),
                        () -> assertEquals("abd.qarmash@test.com", user.getEmail()),
                        () -> assertEquals("Test Abd ", user.getPassword())
                );
            } else {
                assertNotNull(user.getId());
                assertEquals("Name" + j, user.getName());
                assertEquals("Paswword" + j, user.getPassword());
                assertEquals("Test" + j + "@Creat.com", user.getEmail());
            }
            ++j;
        }
    }

    @Test
    public void testGetAllPaging() throws URISyntaxException {

        addusers();

        int page, limit;
        page = 0;
        limit = 10;

        URI uri = new URI("http://localhost:" + randomServerPort + "/users/page?page=" + page + "&limit=" + limit);
        ResponseEntity<UserDto[]> responseUser = testRestTemplate.getForEntity(uri, UserDto[].class);
        UserDto[] users = responseUser.getBody();
        assertEquals(200, responseUser.getStatusCodeValue());
        assertEquals(10, responseUser.getBody().length);

        int j = -1;
        for (UserDto user : users) {
            if (j == -1) {
                assertAll(() -> assertNotNull(user.getId()),
                        () -> assertEquals("abd qarmash", user.getName()),
                        () -> assertEquals("abd.qarmash@test.com", user.getEmail()),
                        () -> assertEquals("Test Abd ", user.getPassword())
                );
            } else {
                assertNotNull(user.getId());
                assertEquals("Name" + j, user.getName());
                assertEquals("Paswword" + j, user.getPassword());
                assertEquals("Test" + j + "@Creat.com", user.getEmail());
            }
            ++j;
        }

    }

    @Test
    @Transactional
    public void testdelete() throws URISyntaxException {
        int userid = 1;
        URI uri = new URI("http://localhost:" + randomServerPort + "/users/" + userid);
        ResponseEntity<Void> responseUser = testRestTemplate.exchange(new RequestEntity<>(HttpMethod.DELETE,uri),Void.class);
        assertEquals(200, responseUser.getStatusCodeValue());
    }

    @Test
    void testUpdate() throws RestClientException, URISyntaxException {
        int userid = 1;

        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setName("testUpdate");
        userCreateDto.setEmail("TsesUpdate@test.com");
        userCreateDto.setPassword("testUpdatePAssword");
        URI uri = new URI("http://localhost:" + randomServerPort + "/users/" + userid);

        ResponseEntity<Void> responseUser = testRestTemplate.exchange(new RequestEntity<>(userCreateDto, HttpMethod.PUT, uri), Void.class);

        assertEquals(200, responseUser.getStatusCodeValue());

    }


    private void addusers() throws RestClientException, URISyntaxException {

        UserCreateDto userDto = new UserCreateDto();

        for (int i = 0; i < 30; i++) {
            userDto.setName("Name" + i);
            userDto.setPassword("Paswword" + i);
            userDto.setEmail("Test" + i + "@Creat.com");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<UserCreateDto> request = new HttpEntity<UserCreateDto>(userDto, headers);
            URI uri = new URI("http://localhost:" + randomServerPort + "/users");
            testRestTemplate.postForEntity(uri, request, UserDto.class);
        }

    }

 */
}


