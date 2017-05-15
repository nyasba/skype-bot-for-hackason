package jp.co.gxp.bot.skype.repository.skype;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.gxp.bot.skype.domain.cleanUp.CleanUpDuty;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CleanStaffRepositoryTest {
	@Autowired
	private CleanStaffRepository csr;

	@Test
	public void getNameTest() {

		CleanUpDuty actual = csr.getName(LocalDate.of(2017, 5, 7));

		assertThat(actual, is(new CleanUpDuty("梶","間瀬","三井")));

	}
}