
/**
 * 데이터베이스의 Jobs 테이블의 데이터를 저장하기 위한 클래스
 * 
 * @author shoseo
 */
public class Job {
	
	//이 클래스의 필드(변수)는 테이블의 컬럼과 일치하도록 구현
	private String jobId;
	private String jobTitle;
	private int minSalary;
	private int maxSalary;
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	// Object 클래스에서 상속 받은 메서드 : 객체의 정보를 간단한 문자열로 반환
	@Override
	public String toString() {
		return String.format("[%10s][%35s][%,6d][%,6d]",
			jobId, jobTitle, minSalary, maxSalary);
	}

}







