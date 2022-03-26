package schedule.tran;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.TranConsumer;

/**
 * 운반자_업체정보 조회/회신
 * 매일 오전 3시 45분에서 50분 사이의 랜덤한 시간에 실행
 */
public class T300_4001_05 implements Job {
	private Logger logger = Logger.getLogger(T300_4001_05.class);
	private TranConsumer consumer = new TranConsumer();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-TG-001";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}