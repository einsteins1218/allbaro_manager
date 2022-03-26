package schedule.cmmn;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.common.ClientConfigureLoader;
import mb.fw.restapi.consumer.CmmnConsumer;

/**
 * 공지사항 조회/회신
 * 매일  7, 12, 19시 35분에서 55분 사이의 랜덤한 시간에 실행
 */
public class T100_3001_00 implements Job {
	private Logger logger = Logger.getLogger(T100_3001_00.class);
	private CmmnConsumer consumer = new CmmnConsumer();
	private ClientConfigureLoader properties = new ClientConfigureLoader();
	
	// 정보연계 ID
	private final static String API_ID = "API-IFR-CG-000";

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
	}

}
