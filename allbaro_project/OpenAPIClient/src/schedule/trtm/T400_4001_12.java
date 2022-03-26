package schedule.trtm;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.TrtmConsumer;

/**
 * 처리자_오류내역 조회/회신
 * 매일 오전 8시 20분에서 25분 사이의 랜덤한 시간에 실행
 */
public class T400_4001_12 implements Job {
	private Logger logger = Logger.getLogger(T400_4001_12.class);
	private TrtmConsumer consumer = new TrtmConsumer();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-MG-003";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}