import java.util.Random;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import schedule.cmmn.T100_3001_00;
import schedule.cmmn.T100_3001_02;
import schedule.emis.T200_4001_01;
import schedule.emis.T200_4001_05;
import schedule.emis.T200_4001_06;
import schedule.emis.T200_4001_08;
import schedule.emis.T200_4001_09;
import schedule.emis.T200_4001_10;
import schedule.emis.T200_4001_12;
import schedule.tran.T300_4001_05;
import schedule.tran.T300_4001_12;
import schedule.tran.T300_4001_20;
import schedule.tran.T300_4001_21;
import schedule.tran.T300_4001_34;
import schedule.trtm.T400_4001_05;
import schedule.trtm.T400_4001_12;
import schedule.trtm.T400_4001_20;
import schedule.trtm.T400_4001_21;
import schedule.trtm.T400_4001_22;
import schedule.trtm.T400_4001_35;

/**
 * 스케줄 관리 클래스
 * 웹 어플리케이션으로 관리 시 HttpServlet을 상속받아 main 함수를 init 함수로 구현한다.
 * 그 후, web.xml에 서블릿을 등록한다.
    <servlet>      
        <servlet-name>StartScheduleMain</servlet-name>
        <servlet-class>StartScheduleMain</servlet-class>
        <init-param>
            <param-name>shutdown-on-unload</param-name>
            <param-value>true</param-value>
        </init-param>
        <load-on-startup>2</load-on-startup>
    </servlet>
 */
public class StartScheduleMain {
	private SchedulerFactory schedulerFactory;
	private Scheduler scheduler;
	
	public StartScheduleMain() {
		try {
			schedulerFactory = new StdSchedulerFactory();
			scheduler = schedulerFactory.getScheduler();
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 공통 스케줄 관리
	 */
	public void getCmmnScheduler() {
		try {
			Random random = new Random();
			
			// 매주 일요일 0시 0분에서 20분 사이의 랜덤한 시간에 실행
			JobDetail t100_3001_02 = new JobDetail("T100_3001_02_JOB", Scheduler.DEFAULT_GROUP, T100_3001_02.class);
			CronTrigger t100_3001_02_trigger = new CronTrigger("T100_3001_02_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20)) + " 0 ? * SUN");
			
			scheduler.scheduleJob(t100_3001_02, t100_3001_02_trigger);
			
			// 매일  7, 12, 19시 35분에서 55분 사이의 랜덤한 시간에 실행
			JobDetail t100_3001_00 = new JobDetail("T100_3001_00_JOB", Scheduler.DEFAULT_GROUP, T100_3001_00.class);
			CronTrigger t100_3001_00_trigger = new CronTrigger("T100_3001_00_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 35) + " 7,12,19 * * ?");
			
			scheduler.scheduleJob(t100_3001_00, t100_3001_00_trigger);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 배출자 스케줄 관리
	 */
	public void getEmisScheduler() {
		try {
			Random random = new Random();
			
			// 매일 오전 3시 40분에서 4시 0분 사이의 랜덤한 시간에 실행
			//CronTrigger t200_4001_01_trigger = new CronTrigger("T200_4001_01_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 40) + " 3 * * ?");
			
			// 매 시간 10초마다 T200_4001_01 인터페이스에 대한 JOB 호출하도록 스케줄러에 등록
			JobDetail t200_4001_01 = new JobDetail("T200_4001_01_JOB", Scheduler.DEFAULT_GROUP, T200_4001_01.class);
			CronTrigger t200_4001_01_trigger = new CronTrigger("T200_4001_01_CRON", Scheduler.DEFAULT_GROUP, "10 * * * * ?");
			scheduler.scheduleJob(t200_4001_01, t200_4001_01_trigger);
			
			// 매일 오전 3시 41분에서 4시 0분 사이의 랜덤한 시간에 실행
			JobDetail t200_4001_05 = new JobDetail("T200_4001_05_JOB", Scheduler.DEFAULT_GROUP, T200_4001_05.class);
			CronTrigger t200_4001_05_trigger = new CronTrigger("T200_4001_05_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(19) + 41) + " 3 * * ?");
			
			scheduler.scheduleJob(t200_4001_05, t200_4001_05_trigger);
			
			// 매일 오전 3시 42분에서 4시 0분 사이의 랜덤한 시간에 실행
			JobDetail t200_4001_06 = new JobDetail("T200_4001_06_JOB", Scheduler.DEFAULT_GROUP, T200_4001_06.class);
			CronTrigger t200_4001_06_trigger = new CronTrigger("T200_4001_06_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(18) + 42) + " 3 * * ?");
			
			scheduler.scheduleJob(t200_4001_06, t200_4001_06_trigger);
			
			// 매일 오전 8시 0분에서 20분 사이의 랜덤한 시간에 실행
			JobDetail t200_4001_12 = new JobDetail("T200_4001_12_JOB", Scheduler.DEFAULT_GROUP, T200_4001_12.class);
			CronTrigger t200_4001_12_trigger = new CronTrigger("T200_4001_12_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20)) + " 8 * * ?");
			
			scheduler.scheduleJob(t200_4001_12, t200_4001_12_trigger);
			
			// 매일  7, 12, 19시 0분에서 20분 사이의 랜덤한 시간에 실행
			JobDetail t200_4001_08 = new JobDetail("T200_4001_08_JOB", Scheduler.DEFAULT_GROUP, T200_4001_08.class);
			CronTrigger t200_4001_08_trigger = new CronTrigger("T200_4001_08_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20)) + " 7,12,19 * * ?");
			
			scheduler.scheduleJob(t200_4001_08, t200_4001_08_trigger);
			
			// 매일  7, 12, 19시 5분에서 25분 사이의 랜덤한 시간에 실행
			JobDetail t200_4001_09 = new JobDetail("T200_4001_09_JOB", Scheduler.DEFAULT_GROUP, T200_4001_09.class);
			CronTrigger t200_4001_09_trigger = new CronTrigger("T200_4001_09_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 5) + " 7,12,19 * * ?");
			
			scheduler.scheduleJob(t200_4001_09, t200_4001_09_trigger);
			
			// 매일  오전 3시 44분에서 4시 0분 사이의 랜덤한 시간에 실행
			JobDetail t200_4001_10 = new JobDetail("T200_4001_10_JOB", Scheduler.DEFAULT_GROUP, T200_4001_10.class);
			CronTrigger t200_4001_10_trigger = new CronTrigger("T200_4001_10_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(16) + 44) + " 3 * * ?");
			
			scheduler.scheduleJob(t200_4001_10, t200_4001_10_trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 운반자 스케줄 관리
	 */
	public void getTranScheduler() {
		try {
			Random random = new Random();
			
			// 매일 오전 3시 45분에서 4시 0분 사이의 랜덤한 시간에 실행
			JobDetail t300_4001_05 = new JobDetail("T300_4001_05_JOB", Scheduler.DEFAULT_GROUP, T300_4001_05.class);
			CronTrigger t300_4001_05_trigger = new CronTrigger("T300_4001_05_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(15) + 45) + " 3 * * ?");
			
			scheduler.scheduleJob(t300_4001_05, t300_4001_05_trigger);
			
			// 매일 오전 8시 10분에서 30분 사이의 랜덤한 시간에 실행
			JobDetail t300_4001_12 = new JobDetail("T300_4001_12_JOB", Scheduler.DEFAULT_GROUP, T300_4001_12.class);
			CronTrigger t300_4001_12_trigger = new CronTrigger("T300_4001_12_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 10) + " 8 * * ?");
			
			scheduler.scheduleJob(t300_4001_12, t300_4001_12_trigger);
			
			// 매일 오전 3시 46분에서 4시 0분 사이의 랜덤한 시간에 실행
			JobDetail t300_4001_34 = new JobDetail("T300_4001_34_JOB", Scheduler.DEFAULT_GROUP, T300_4001_34.class);
			CronTrigger t300_4001_34_trigger = new CronTrigger("T300_4001_34_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(14) + 46) + " 3 * * ?");
			
			scheduler.scheduleJob(t300_4001_34, t300_4001_34_trigger);
			
			// 매일  7, 12, 19시 10분에서 30분 사이의 랜덤한 시간에 실행
			JobDetail t300_4001_20 = new JobDetail("T300_4001_20_JOB", Scheduler.DEFAULT_GROUP, T300_4001_20.class);
			CronTrigger t300_4001_20_trigger = new CronTrigger("T300_4001_20_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 10) + " 7,12,19 * * ?");
			
			scheduler.scheduleJob(t300_4001_20, t300_4001_20_trigger);
			
			// 매일  7, 12, 19시 15분에서 35분 사이의 랜덤한 시간에 실행
			JobDetail t300_4001_21 = new JobDetail("T300_4001_21_JOB", Scheduler.DEFAULT_GROUP, T300_4001_21.class);
			CronTrigger t300_4001_21_trigger = new CronTrigger("T300_4001_21_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 15) + " 7,12,19 * * ?");
			
			scheduler.scheduleJob(t300_4001_21, t300_4001_21_trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 처리자 스케줄 관리
	 */
	public void getTrtmScheduler() {
		try {
			Random random = new Random();
			
			// 매일 오전 3시 47분에서 4시 0분 사이의 랜덤한 시간에 실행
			JobDetail t400_4001_05 = new JobDetail("T400_4001_05_JOB", Scheduler.DEFAULT_GROUP, T400_4001_05.class);
			CronTrigger t400_4001_05_trigger = new CronTrigger("T400_4001_05_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(13) + 47) + " 3 * * ?");
			
			scheduler.scheduleJob(t400_4001_05, t400_4001_05_trigger);
			
			// 매일 오전 8시 20분에서 40분 사이의 랜덤한 시간에 실행
			JobDetail t400_4001_12 = new JobDetail("T400_4001_12_JOB", Scheduler.DEFAULT_GROUP, T400_4001_12.class);
			CronTrigger t400_4001_12_trigger = new CronTrigger("T400_4001_12_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 20) + " 8 * * ?");
			
			scheduler.scheduleJob(t400_4001_12, t400_4001_12_trigger);
			
			// 매일 오전 3시 48분에서 4시 0분 사이의 랜덤한 시간에 실행
			JobDetail t400_4001_35 = new JobDetail("T400_4001_35_JOB", Scheduler.DEFAULT_GROUP, T400_4001_35.class);
			CronTrigger t400_4001_35_trigger = new CronTrigger("T400_4001_35_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(12) + 48) + " 3 * * ?");
			
			scheduler.scheduleJob(t400_4001_35, t400_4001_35_trigger);
			
			// 매일  7, 12, 19시 20분에서 40분 사이의 랜덤한 시간에 실행
			JobDetail t400_4001_20 = new JobDetail("T400_4001_20_JOB", Scheduler.DEFAULT_GROUP, T400_4001_20.class);
			CronTrigger t400_4001_20_trigger = new CronTrigger("T400_4001_20_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 20) + " 7,12,19 * * ?");
			
			scheduler.scheduleJob(t400_4001_20, t400_4001_20_trigger);
			
			// 매일  7, 12, 19시 25분에서 45분 사이의 랜덤한 시간에 실행
			JobDetail t400_4001_21 = new JobDetail("T400_4001_21_JOB", Scheduler.DEFAULT_GROUP, T400_4001_21.class);
			CronTrigger t400_4001_21_trigger = new CronTrigger("T400_4001_21_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 25) + " 7,12,19 * * ?");
			
			scheduler.scheduleJob(t400_4001_21, t400_4001_21_trigger);
			
			// 매일  7, 12, 19시 30분에서 50분 사이의 랜덤한 시간에 실행
			JobDetail t400_4001_22 = new JobDetail("T400_4001_22_JOB", Scheduler.DEFAULT_GROUP, T400_4001_22.class);
			CronTrigger t400_4001_22_trigger = new CronTrigger("T400_4001_22_CRON", Scheduler.DEFAULT_GROUP, String.valueOf(random.nextInt(60)) + " " + String.valueOf(random.nextInt(20) + 30) + " 7,12,19 * * ?");
			
			scheduler.scheduleJob(t400_4001_22, t400_4001_22_trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		StartScheduleMain main = new StartScheduleMain();
		
		System.out.println("실행!!!!!!");
		
//		main.getCmmnScheduler();
		main.getEmisScheduler();
//		main.getTranScheduler();
//		main.getTrtmScheduler();
		
		System.out.println("실행2!!!!!!");
	}
}
