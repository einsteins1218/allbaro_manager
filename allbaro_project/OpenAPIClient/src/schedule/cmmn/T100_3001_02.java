package schedule.cmmn;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.CmmnConsumer;

/**
 * 공통 코드 조회/회신
 * 매주 일요일 0시 0분에서 5분 사이의 랜덤한 시간에 실행
 */
public class T100_3001_02 implements Job {
	private Logger logger = Logger.getLogger(T100_3001_02.class);
	private CmmnConsumer consumer = new CmmnConsumer();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-CG-001";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}