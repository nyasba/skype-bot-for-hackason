package jp.co.gxp.bot.skype.repository.skype;

import java.time.LocalDate;

public class CleanStaffRepositoryInpl implements CleanStaffRepository{
	public String getName(LocalDate d){

		if(LocalDate.of(2017, 5, 1) .equals(d)){
			return "梶,間瀬,三井";

		}
		return "梶,梶,梶";
	}

}
