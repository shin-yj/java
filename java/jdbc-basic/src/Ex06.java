import java.util.List;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		
		JobsDao dao = new JobsDao();
		
		//1. 신규 데이터 추가 (insert)
		Job job = new Job();
		job.setJobId("DB_ADMIN");
		job.setJobTitle("Database Administrator");
		job.setMinSalary(8000);
		job.setMaxSalary(14000);
		
		dao.insertJob(job);
		System.out.println("신규 데이터를 저장했습니다.");
		// 결과는 SQLDeveloper를 사용해서 확인
		
		//1-1. 추가된 데이터 조회
		//     SELECT * FROM JOBS WHERE JOB_ID = ?
		Job rjob = dao.selectJobById("DB_ADMIN");
		if (rjob == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rjob.toString());
		}		
		
		//2. 기존 데이터 수정 (update)
		// UPDATE JOBS 
		// SET JOB_TITLE = ?, MAX_SALARY = ?, MIN_SALARY = ?
		// WHERE JOB_ID = ?
		Job job2 = new Job();
		job2.setJobId("DB_ADMIN"); // where 절에서 사용할 데이터
		job2.setJobTitle("Database Administrator 2"); // set 절에서 사용할 데이터
		job2.setMinSalary(7500); // set 절에서 사용할 데이터
		job2.setMaxSalary(13500); // set 절에서 사용할 데이터
		
		dao.updateJob(job2);
		System.out.println("데이터를 수정했습니다.");
		
		//2-1. 수정된 데이터 조회
		//     SELECT * FROM JOBS WHERE JOB_ID = ?
		Job rjob2 = dao.selectJobById("DB_ADMIN");
		if (rjob2 == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rjob2.toString());
		}
		
		//3. 기존 데이터 삭제 (delete)
		//DELETE FROM JOBS WHERE JOB_ID = ?
		String jobId = "DB_ADMIN";
		dao.deleteById(jobId);
		System.out.println("데이터를 삭제했습니다.");
		
		//3-1. 삭제 확인
		//     SELECT * FROM JOBS WHERE JOB_ID = ?
		Job rjob3 = dao.selectJobById("DB_ADMIN");
		if (rjob3 == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rjob3.toString());
		}
		
	}

}








