package com.project.db;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DbApplicationTests {

	@Test
    @Transactional
	void test(){}
}
