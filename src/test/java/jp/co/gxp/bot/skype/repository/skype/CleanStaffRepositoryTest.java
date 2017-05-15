package jp.co.gxp.bot.skype.repository.skype;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CleanStaffRepositoryTest {
	@Autowired
	private CleanStaffRepository csr;

	@Test
	public void getNameTest() {

		String actual = csr.getName(LocalDate.of(2017, 5, 7));

		assertThat(actual, is("梶,間瀬,三井"));

	}
}