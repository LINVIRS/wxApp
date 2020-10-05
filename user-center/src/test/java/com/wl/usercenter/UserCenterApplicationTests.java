package com.wl.usercenter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserCenterApplicationTests {
@Resource
private UserRepository userRepository;
	@Test
	void contextLoads() {
	}

	 @Test
	void  ce(){
    System.out.println(userRepository.findSize());
	 }
}
