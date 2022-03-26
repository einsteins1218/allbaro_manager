package schedule.emis;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import mb.fw.restapi.consumer.EmisConsumer;

/**
 * 배출자_처리계획서 조회/회신
 * 매일 오전 3시 40분에서 45분 사이의 랜덤한 시간에 실행
 */
public class T200_4001_01 implements Job {
	private Logger logger = Logger.getLogger(T200_4001_01.class);
	private EmisConsumer consumer = new EmisConsumer();

	// 정보연계 ID
	private final static String API_ID = "API-IFR-EG-001";

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println(" job 시작!!! ");
		
		// 정보연계ID(또는　인터페이스ID), 인계번호, 페이지번호, 기간시작일자, 기간종료일자
		// 신규 데이터 조회
		Map message = (Map)consumer.get("API-IFR-EG-001", null, "N", "N", null, null, null);
		
		String temp2 = message.toString();
		System.out.println("111");
		System.out.println(temp2);
		
		if("0000".equals((String)message.get("resultCode"))) {
			// 정상 처리
			
			System.out.println("222");
			
			List<Map> dataList = (List<Map>)message.get("dataList");
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
			
			System.out.println("333");
			
			String temp = dataList.toString();
			
			System.out.println(temp);
			
		} else {
			
			System.out.println("444");
			// 오류 처리
			String txid = (String)message.get("txid");
			String resultMsg = (String)message.get("resultMessage");
		}

	}
}