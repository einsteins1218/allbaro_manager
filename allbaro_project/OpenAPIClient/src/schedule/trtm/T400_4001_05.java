package schedule.trtm;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.TrtmConsumer;

/**
 * 처리자_업체정보 조회/회신
 * 매일 오전 3시 47분에서 52분 사이의 랜덤한 시간에 실행
 */
public class T400_4001_05 implements Job {
	private Logger logger = Logger.getLogger(T400_4001_05.class);
	private TrtmConsumer consumer = new TrtmConsumer();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-MG-001";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}