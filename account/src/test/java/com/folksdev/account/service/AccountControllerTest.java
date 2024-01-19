package com.folksdev.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Supplier;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
        "server-port = 0",
        "command.line.runner.enabled = false"
})

@DirtiesContext
@RunWith(SpringRunner.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Clock clock;

    @MockBean
    private Supplier<UUID> uuidSupplier;
}
