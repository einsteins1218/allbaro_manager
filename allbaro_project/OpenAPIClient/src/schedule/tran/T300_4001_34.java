package schedule.tran;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.TranConsumer;

/**
 * 운반자_수집운반허가증_차량 조회/회신
 * 매일 오전 3시 46분에서 51분 사이의 랜덤한 시간에 실행
 */
public class T300_4001_34 implements Job {
	private Logger logger = Logger.getLogger(T300_4001_34.class);
	private TranConsumer consumer = new TranConsumer();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-TG-006";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}