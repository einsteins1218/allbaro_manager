package schedule.tran;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.TranConsumer;

/**
 * 운반자_인계실적(적법입력) 조회/회신
 * 매일  7, 12, 19시 15분에서 20분 사이의 랜덤한 시간에 실행
 */
public class T300_4001_21 implements Job {
	private Logger logger = Logger.getLogger(T300_4001_21.class);
	private TranConsumer consumer = new TranConsumer();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-TG-005";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}