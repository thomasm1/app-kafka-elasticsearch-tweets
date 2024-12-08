package com.friendsofgroot.app.bootstrap;

import com.friendsofgroot.app.dataLoader.BootstrapData;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.repositories.ChainsRepository;
import com.friendsofgroot.app.repositories.UsersRepository;
import com.friendsofgroot.app.service.ChainCsvService;
import com.friendsofgroot.app.service.ChainCsvServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@DataJpaTest
@Import(ChainCsvServiceImpl.class)
class BootstrapDataTest {

    @Autowired
    ChainsRepository chainRepository;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    ChainCsvService csvService;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(chainRepository, userRepository, csvService);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);
long users= (long) userRepository.count() ;
        System.out.println("users: " + users);
    }

}
