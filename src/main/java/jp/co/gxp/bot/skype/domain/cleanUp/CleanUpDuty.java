package jp.co.gxp.bot.skype.domain.cleanUp;

/* 掃除担当者名 */
public class CleanUpDuty {
	private String nameA;
	private String nameB;
	private String nameC;

	public CleanUpDuty(String nameA, String nameB, String nameC) {
		this.nameA = nameA;
		this.nameB = nameB;
		this.nameC = nameC;
	}

	public String getNameA() {
		return  this.nameA;
	}

	public String getNameB() {
		return  this.nameB;
	}

	public String getNameC() {
		return  this.nameC;
	}
}
