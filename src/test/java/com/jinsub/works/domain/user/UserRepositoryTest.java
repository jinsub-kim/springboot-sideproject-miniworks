package com.jinsub.works.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void User저장_불러오기() {
        // given
        Long domainId = 100L;
        String account = "test@account.com";
        String userName = "테스트 유저";
        String userExternalKey = "TESTEXTERNALKEY";
        String cellPhone = "010-5254-9161";
        String email = "jinsub-kim@gmail.com";
        LocalDateTime hireDate = LocalDateTime.now();

        userRepository.save(User.builder()
            .domainId(domainId)
            .account(account)
            .userName(userName)
            .userExternalKey(userExternalKey)
            .cellPhone(cellPhone)
            .email(email)
            .hireDate(hireDate)
            .build());

        // when
        List<User> userList = userRepository.findAll();

        // then
        User user = userList.get(0);
        assertThat(user.getDomainId()).isEqualTo(domainId);
        assertThat(user.getAccount()).isEqualTo(account);
        assertThat(user.getUserName()).isEqualTo(userName);
        assertThat(user.getUserExternalKey()).isEqualTo(userExternalKey);
        assertThat(user.getCellPhone()).isEqualTo(cellPhone);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getHireDate()).isEqualTo(hireDate);
    }
}
