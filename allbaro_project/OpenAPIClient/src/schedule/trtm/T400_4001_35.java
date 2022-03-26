package schedule.trtm;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.TrtmConsumer;

/**
 * 처리자_처리업허가증_수집운반장비 조회/회신
 * 매일 오전 3시 48분에서 53분 사이의 랜덤한 시간에 실행
 */
public class T400_4001_35 implements Job {
	private Logger logger = Logger.getLogger(T400_4001_35.class);
	private TrtmConsumer consumer = new TrtmConsumer();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-MG-009";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}