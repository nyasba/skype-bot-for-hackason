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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameA == null) ? 0 : nameA.hashCode());
		result = prime * result + ((nameB == null) ? 0 : nameB.hashCode());
		result = prime * result + ((nameC == null) ? 0 : nameC.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CleanUpDuty other = (CleanUpDuty) obj;
		if (nameA == null) {
			if (other.nameA != null)
				return false;
		} else if (!nameA.equals(other.nameA))
			return false;
		if (nameB == null) {
			if (other.nameB != null)
				return false;
		} else if (!nameB.equals(other.nameB))
			return false;
		if (nameC == null) {
			if (other.nameC != null)
				return false;
		} else if (!nameC.equals(other.nameC))
			return false;
		return true;
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
