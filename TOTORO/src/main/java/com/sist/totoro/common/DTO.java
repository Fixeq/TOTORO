package com.sist.totoro.common;

public class DTO {
	private int no;
	private int totalCnt;
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DTO [no=" + no + ", total_cnt=" + totalCnt + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTO other = (DTO) obj;
		if (no != other.no)
			return false;
		if (totalCnt != other.totalCnt)
			return false;
		return true;
	}
	
	
	
}
