package jp.co.gxp.bot.skype.repository.skype;

import java.time.LocalDate;

import jp.co.gxp.bot.skype.domain.cleanUp.CleanUpDuty;

public interface CleanStaffRepository {

	CleanUpDuty getName(LocalDate d);

}
