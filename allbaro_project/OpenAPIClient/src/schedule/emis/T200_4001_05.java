package schedule.emis;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.EmisConsumer;

/**
 * 배출자_업체정보 조회/회신
 * 매일 오전 3시 41분에서 46분 사이의 랜덤한 시간에 실행
 */
public class T200_4001_05 implements Job {
	private Logger logger = Logger.getLogger(T200_4001_05.class);
	private EmisConsumer consumer = new EmisConsumer();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-EG-002";

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}