package jp.co.gxp.bot.skype.repository.skype;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import jp.co.gxp.bot.skype.domain.cleanUp.CleanUpDuty;

@Repository
public class CleanStaffRepositoryInpl implements CleanStaffRepository{
	@Override
	public CleanUpDuty getName(LocalDate d){

		//5/1~
		if(d.isAfter(LocalDate.of(2017,4,30)) && d.isBefore(LocalDate.of(2017,5,8))){
			return new CleanUpDuty("梶","間瀬","三井");
		}

		//5/8~
		if(d.isAfter(LocalDate.of(2017,5,7)) && d.isBefore(LocalDate.of(2017,5,15))){
			return new CleanUpDuty("土屋","伊藤","曽我");
		}

		//5/15~
		if(d.isAfter(LocalDate.of(2017,5,14)) && d.isBefore(LocalDate.of(2017,5,22))){
			return new CleanUpDuty("安","齊藤悠","原田");
		}

		//5/22~
		if(d.isAfter(LocalDate.of(2017,5,21)) && d.isBefore(LocalDate.of(2017,5,29))){
			return new CleanUpDuty("土屋","伊藤","曽我");
		}

		//5.29~
		if(d.isAfter(LocalDate.of(2017,5,28)) && d.isBefore(LocalDate.of(2017,6,5))){
			return new CleanUpDuty("安","齊藤悠","原田");
		}

		//6/5~
		if(d.isAfter(LocalDate.of(2017,6,4)) && d.isBefore(LocalDate.of(2017,6,12))){
			return new CleanUpDuty("梶","斎藤","木村");
		}

		//6/12~
		if(d.isAfter(LocalDate.of(2017,6,11)) && d.isBefore(LocalDate.of(2017,6,19))){
			return new CleanUpDuty("岸田","鳥原","神原");
		}

		//6/19~
		if(d.isAfter(LocalDate.of(2017,6,18)) && d.isBefore(LocalDate.of(2017,6,26))){
			return new CleanUpDuty("杉山","外山","三井");
		}

		//6/26~
		if(d.isAfter(LocalDate.of(2017,6,25)) && d.isBefore(LocalDate.of(2017,7,3))){
			return new CleanUpDuty("梁","間瀬","木村");
		}


		//7/3~ ここからローテ開始
		if(d.isAfter(LocalDate.of(2017,7,2)) && d.isBefore(LocalDate.of(2017,7,10))){
			return new CleanUpDuty("岸田","斎藤","三井");
		}

		//7/10~
		if(d.isAfter(LocalDate.of(2017,7,9)) && d.isBefore(LocalDate.of(2017,7,17))){
			return new CleanUpDuty("杉山","鳥原","木村");
		}

		//7/17~
		if(d.isAfter(LocalDate.of(2017,7,16)) && d.isBefore(LocalDate.of(2017,7,24))){
			return new CleanUpDuty("梁","外山","神原");
		}

		//7/24~
		if(d.isAfter(LocalDate.of(2017,7,23)) && d.isBefore(LocalDate.of(2017,7,31))){
			return new CleanUpDuty("梶","間瀬","三井");
		}

		//7/31~
		if(d.isAfter(LocalDate.of(2017,7,30)) && d.isBefore(LocalDate.of(2017,8,7))){
			return new CleanUpDuty("岸田","斎藤","木村");
		}

		//8/7~
		if(d.isAfter(LocalDate.of(2017,8,6)) && d.isBefore(LocalDate.of(2017,8,14))){
			return new CleanUpDuty("杉山","鳥原","神原");
		}

		//8/14~
		if(d.isAfter(LocalDate.of(2017,8,13)) && d.isBefore(LocalDate.of(2017,8,21))){
			return new CleanUpDuty("梁","外山","三井");
		}

		//8/21~
		if(d.isAfter(LocalDate.of(2017,8,20)) && d.isBefore(LocalDate.of(2017,8,28))){
			return new CleanUpDuty("岸田","斎藤","木村");
		}

		//8/28~
		if(d.isAfter(LocalDate.of(2017,8,27)) && d.isBefore(LocalDate.of(2017,9,4))){
			return new CleanUpDuty("杉山","鳥原","神原");
		}

		//9/4~
		if(d.isAfter(LocalDate.of(2017,9,3)) && d.isBefore(LocalDate.of(2017,9,11))){
			return new CleanUpDuty("梁","外山","三井");
		}

		//9/11~
		if(d.isAfter(LocalDate.of(2017,9,10)) && d.isBefore(LocalDate.of(2017,9,18))){
			return new CleanUpDuty("梶","間瀬","木村");
		}

		//9/18~
		if(d.isAfter(LocalDate.of(2017,9,17)) && d.isBefore(LocalDate.of(2017,9,25))){
			return new CleanUpDuty("岸田","斎藤","神原");
		}

		//9/25~
		if(d.isAfter(LocalDate.of(2017,9,24)) && d.isBefore(LocalDate.of(2017,10,2))){
			return new CleanUpDuty("杉山","鳥原","三井");
		}

		//10/2~
		if(d.isAfter(LocalDate.of(2017,10,1)) && d.isBefore(LocalDate.of(2017,10,9))){
			return new CleanUpDuty("梁","外山","木村");
		}

		//10/9~
		if(d.isAfter(LocalDate.of(2017,10,8)) && d.isBefore(LocalDate.of(2017,10,16))){
			return new CleanUpDuty("梶","間瀬","神原");
		}

		//10/16~
		if(d.isAfter(LocalDate.of(2017,10,15)) && d.isBefore(LocalDate.of(2017,10,23))){
			return new CleanUpDuty("岸田","斎藤","三井");
		}

		//10/23~
		if(d.isAfter(LocalDate.of(2017,10,22)) && d.isBefore(LocalDate.of(2017,10,30))){
			return new CleanUpDuty("杉山","鳥原","木村");
		}

		//10/30~
		if(d.isAfter(LocalDate.of(2017,10,29)) && d.isBefore(LocalDate.of(2017,11,6))){
			return new CleanUpDuty("梁","外山","神原");
		}

		return new CleanUpDuty("梶","梶","梶");
	}

}
