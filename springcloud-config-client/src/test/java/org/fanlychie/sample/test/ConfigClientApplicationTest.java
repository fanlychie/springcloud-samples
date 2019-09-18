package org.fanlychie.sample.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigClientApplicationTest {

	@Value("${message}")
	private String message;

	@Test
	public void doTest() {
		assertThat(message).isNotBlank();
		System.out.println(message);
	}

}