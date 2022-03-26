import java.util.List;
import java.util.Map;

import mb.fw.restapi.common.ClientConfigureLoader;
import mb.fw.restapi.consumer.CmmnConsumer;
import mb.fw.restapi.consumer.EmisConsumer;
import mb.fw.restapi.consumer.TranConsumer;
import mb.fw.restapi.consumer.TrtmConsumer;
import mb.fw.restapi.message.T200_5001_01_ListReq;
import mb.fw.restapi.message.T200_5001_02_ListReq;
import mb.fw.restapi.message.T300_5001_01_ListReq;
import mb.fw.restapi.message.T400_5001_01_ListReq;
import mb.fw.restapi.message.T400_5001_02_ListReq;

public class OpenAPIClientTest {
	private ClientConfigureLoader properties = new ClientConfigureLoader();
	// 공통처리 클라이언트
	private CmmnConsumer cmmnConsumer = new CmmnConsumer();
	// 배출자 클라이언트
	private EmisConsumer emisConsumer = new EmisConsumer();
	// 운반자 클라이언트
	private TranConsumer tranConsumer = new TranConsumer();
	// 처리자 클라이언트
	private TrtmConsumer trtmConsumer = new TrtmConsumer();
	
	// Get 방식 신규 조회
	public void getTest() {
		// 정보연계ID(또는 인터페이스ID), 인계번호, 요청구분(Default "N"), 페이지번호(Default "N"), 기간시작일자, 기간종료일자
		// 신규 데이터 조회
		Map message = (Map)emisConsumer.get("T200_4001_01", null, "N", "N", null, null, null);
			
		if("0000".equals((String)message.get("resultCode"))) {
			// 정상 처리
			List<Map> dataList = (List<Map>)message.get("dataList");
			
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
		} else if("9011".equals((String)message.get("resultCode"))) {
			// 요청 파라미터 오류
			String resultMsg = (String)message.get("resultMessage");
		} else {
			// 오류 처리
			String txid = (String)message.get("txid");
			String resultMsg = (String)message.get("resultMessage");
		}
		
		Map message1 = (Map)emisConsumer.get("T200_4001_05", null, null, null, null, null, null);
		if("0000".equals((String)message1.get("resultCode"))) {
			// 정상 처리
			List<Map> dataList = (List<Map>)message1.get("dataList");
			
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
		} else if("9011".equals((String)message.get("resultCode"))) {
			// 요청 파라미터 오류
			String resultMsg = (String)message.get("resultMessage");
		} else {
			// 오류 처리
			String txid = (String)message1.get("txid");
			String resultMsg = (String)message1.get("resultMessage");
		}
		
		Map message2 = (Map)emisConsumer.get("T200_4001_06", null, null, null, null, null, null);
		if("0000".equals((String)message2.get("resultCode"))) {
			// 정상 처리
			List<Map> dataList = (List<Map>)message2.get("dataList");
			
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
		} else if("9011".equals((String)message.get("resultCode"))) {
			// 요청 파라미터 오류
			String resultMsg = (String)message.get("resultMessage");
		} else {
			// 오류 처리
			String txid = (String)message2.get("txid");
			String resultMsg = (String)message2.get("resultMessage");
		}
		
		//==============================================================
				
		Map message3 = (Map)tranConsumer.get("T300_4001_05", null, null, null, null, null, null);
		if("0000".equals((String)message3.get("resultCode"))) {
			// 정상 처리
			List<Map> dataList = (List<Map>)message3.get("dataList");
			
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
		} else if("9011".equals((String)message.get("resultCode"))) {
			// 요청 파라미터 오류
			String resultMsg = (String)message.get("resultMessage");
		} else {
			// 오류 처리
			String txid = (String)message3.get("txid");
			String resultMsg = (String)message3.get("resultMessage");
		}
		
		Map message4 = (Map)tranConsumer.get("T300_4001_34", null, null, null, null, null, null);
		if("0000".equals((String)message4.get("resultCode"))) {
			// 정상 처리
			List<Map> dataList = (List<Map>)message4.get("dataList");
			
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
		} else if("9011".equals((String)message.get("resultCode"))) {
			// 요청 파라미터 오류
			String resultMsg = (String)message.get("resultMessage");
		} else {
			// 오류 처리
			String txid = (String)message4.get("txid");
			String resultMsg = (String)message4.get("resultMessage");
		}		
		
		//==============================================================
		Map message5 = (Map)trtmConsumer.get("T400_4001_05", null, null, null, null, null, null);
		if("0000".equals((String)message5.get("resultCode"))) {
			// 정상 처리
			List<Map> dataList = (List<Map>)message5.get("dataList");
			
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
		} else if("9011".equals((String)message.get("resultCode"))) {
			// 요청 파라미터 오류
			String resultMsg = (String)message.get("resultMessage");
		} else {
			// 오류 처리
			String txid = (String)message5.get("txid");
			String resultMsg = (String)message5.get("resultMessage");
		}
		
		Map message6 = (Map)trtmConsumer.get("T400_4001_35", null, null, null, null, null, null);
		if("0000".equals((String)message6.get("resultCode"))) {
			// 정상 처리
			List<Map> dataList = (List<Map>)message6.get("dataList");
			
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
		} else if("9011".equals((String)message.get("resultCode"))) {
			// 요청 파라미터 오류
			String resultMsg = (String)message.get("resultMessage");
		} else {
			// 오류 처리
			String txid = (String)message6.get("txid");
			String resultMsg = (String)message6.get("resultMessage");
		}
		
//		System.out.println(consumer.get("API-IFR-MG-001", null, "N", "N", null, null, null));
//		System.out.println(consumer.get("API-IFR-MG-003", null, "N", "N", null, null, null));
//		System.out.println(consumer.get("API-IFR-MG-004", null, "A", null, null, null, null));
//		System.out.println(consumer.get("API-IFR-MG-005", null, "A", null, null, null, null));
//		System.out.println(consumer.get("API-IFR-MG-006", null, null, null, null, null, null));
//		System.out.println(consumer.get("API-IFR-MG-007", "2008134712", "A", "1", null, null, null));
//		System.out.println(consumer.get("API-IFR-MG-008", "2008134712", "A", "N", null, null, null));
//		System.out.println(consumer.get("API-IFR-MG-009", null, "A", "N", "20200701", "20200722", null));
	}
	
	// Get 방식 전체 조회
	public void getTest_All() {
		// 정보연계ID(또는 인터페이스ID), 인계번호, 요청구분(Default "N"), 페이지번호(Default "N"), 기간시작일자, 기간종료일자
		// 전체 조회
		Map message = (Map)emisConsumer.get("API-IFR-EG-002", null, "A", "1", null, null, null);
		
		// 특정 인계번호 데이터 조회
//		Map message = (Map)emisConsumer.get("API-IFR-EG-002", "2044824416", "A", "N", null, null, null);
		
		// 특정 기간 데이터 전체 조회
//		String fromDate = "20200101";
//		String toDate = "20201231";
//		Map message = (Map)emisConsumer.get("API-IFR-EG-002", null, "A", "1", fromDate, toDate, null);
		
		if("0000".equals((String)message.get("resultCode"))) {
			// 정상 처리
			List<Map> dataList = (List<Map>)message.get("dataList");
			
			if(dataList.size() == 0) {
				String resultCd = "9010";
				String resultMsg = "Open API Client_연계 성공_조회결과 0건";
			}
			
			int totalPageNo = Integer.parseInt((String)message.get("totalPageNo"));
			if(totalPageNo > 1) {
				for (int i = 2; i <= totalPageNo; i++) {
					Map nextMessage = (Map)emisConsumer.get("API-IFR-EG-002", null, "A", String.valueOf(i), null, null, null);
//					Map nextMessage = (Map)emisConsumer.get("API-IFR-EG-002", null, "A", String.valueOf(i), fromDate, toDate, null);
					
					if("0000".equals((String)nextMessage.get("resultCode"))) {
						// 정상 처리
						List<Map> nextDataList = (List<Map>)nextMessage.get("dataList");
					} else if("9011".equals((String)message.get("resultCode"))) {
						// 요청 파라미터 오류
						String resultMsg = (String)message.get("resultMessage");
					} else {
						// 오류 처리
						String txid = (String)nextMessage.get("txid");
						String resultMsg = (String)nextMessage.get("resultMessage");
					}
				}
			}
		} else if("9011".equals((String)message.get("resultCode"))) {
			// 요청 파라미터 오류
			String resultMsg = (String)message.get("resultMessage");
		} else {
			// 오류 처리
			String txid = (String)message.get("txid");
			String resultMsg = (String)message.get("resultMessage");
		}
	}
	
	// Put 방식
	public void putTest() {
		T200_5001_01_ListReq reqMessage = new T200_5001_01_ListReq();
		reqMessage.setEntn_lkcd(properties.entnLkcd); 
		reqMessage.setManf_nums("2043827150");
		reqMessage.setEmis_chrg("200523144"); 
		reqMessage.setWste_code("510301");
		reqMessage.setGntp("고상");
		reqMessage.setGive_qunt("0");
		reqMessage.setGive_qunt_unit("02");
		reqMessage.setTran_chrg("110466455"); 
		reqMessage.setTrtm_chrg("110466455");
		reqMessage.setGive_date("2020-07-03 09:13:09");
		reqMessage.setGive_chrg_name("홍길동"); 
		reqMessage.setTrtm_ways("2003");
		reqMessage.setCmpt_auth("253"); 
		reqMessage.setTrtm_site("충청남도 천안시 서북구 성환읍");
		reqMessage.setVehc_nums("90고5470"); 
		reqMessage.setWste_remk("석탄재");
		reqMessage.setManb_type("0"); 
		reqMessage.setCertform_info("D20");
		reqMessage.setCert_pdate("제05-5호"); 
		reqMessage.setCert_pinfo("100");
		
		// 정보연계ID, PUT메시지(JSON Object)
		Map message = (Map)emisConsumer.put("API-IFR-EP-001", reqMessage);
		// 실적 로그 조회
		Map logMessage = (Map)emisConsumer.get("API-IFR-EG-007", reqMessage.getManf_nums(), "A", "N", null, null, null);
		
//		T200_5001_02_ListReq reqMessage1 = new T200_5001_02_ListReq();
//		reqMessage1.setEntn_lkcd(properties.entnLkcd);
//		reqMessage1.setEmis_chrg("200002262");
//		reqMessage1.setManb_date("2020-07-06 16:00:00");
//		reqMessage1.setWste_code("40-02-06");
//		reqMessage1.setGntp("고상");
//		reqMessage1.setWste_remk("");
//		reqMessage1.setSelf_trtm_ways("0000");
//		reqMessage1.setSelf_trtm_qunt("12730");
//		reqMessage1.setManb_type("1");
//		Map message = (Map)emisConsumer.put("API-IFR-EP-002", reqMessage1);
		
//		T300_5001_01_ListReq reqMessage2 = new T300_5001_01_ListReq();
//		reqMessage2.setEntn_lkcd(properties.entnLkcd);
//		reqMessage2.setManf_nums("2043827140");
//		reqMessage2.setTran_chrg("200523144");
//		reqMessage2.setTran_nums("90가1092");
//		reqMessage2.setRecv_date("2020-07-03 09:13:09");
//		reqMessage2.setRecv_qunt("0");
//		reqMessage2.setRecv_unit("");
//		reqMessage2.setDpst_ysno("");
//		reqMessage2.setGive_date("2020-07-03 09:13:09");
//		reqMessage2.setGive_chrg_name("심현우");
//		reqMessage2.setManb_type("2");
//		Map message = (Map)tranConsumer.put("API-IFR-TP-001", reqMessage2);
//		Map logMessage = (Map)tranConsumer.get("API-IFR-TG-002", reqMessage2.getManf_nums(), "A", "N", null, null, null);
		
//		T400_5001_01_ListReq reqMessage3 = new T400_5001_01_ListReq();
//		reqMessage3.setEntn_lkcd("202063376");
//		reqMessage3.setManf_nums("2008134963");
//		reqMessage3.setWeit_nums("1");
//		reqMessage3.setSeqx("1");
//		reqMessage3.setTrtm_chrg("202063376");
//		reqMessage3.setRecv_date("20200818174000");
//		reqMessage3.setRecv_qunt("1000");
//		reqMessage3.setRecv_qunt_unit("02");
//		reqMessage3.setRecv_chrg_name("테스트");
//		reqMessage3.setTran_nums("999건3084");
//		reqMessage3.setFull_weit_date("20200818174000");
//		reqMessage3.setFull_qunt("700");
//		reqMessage3.setEmty_weit_date("20200818174000");
//		reqMessage3.setEmty_qunt("300");
//		reqMessage3.setLoad_qunt("700");
//		reqMessage3.setOrgl_load_qunt("700");
//		reqMessage3.setManb_type("3");
//		System.out.println(consumer.put("API-IFR-MP-001", reqMessage3));
//		System.out.println(consumer.get("API-IFR-MG-004", reqMessage3.getManf_nums(), "A", "N", null, null, null));
		
//		T400_5001_02_ListReq reqMessage4 = new T400_5001_02_ListReq();
//		reqMessage4.setEntn_lkcd("202063376");
//		reqMessage4.setManf_nums("2008134963");
//		reqMessage4.setTrtm_chrg("202063376");
//		reqMessage4.setTrtm_date("20200818174100");
//		reqMessage4.setNums("1");
//		reqMessage4.setTrtm_ways("2102");
//		reqMessage4.setTrtq("400");
//		reqMessage4.setTrtq_unit("02");
//		reqMessage4.setLeft_qunt("300");
//		reqMessage4.setManb_type("2");
//		System.out.println(consumer.put("API-IFR-MP-002", reqMessage4));
//		System.out.println(consumer.get("API-IFR-MG-005", reqMessage4.getManf_nums(), "A", "N", null, null, null));
		
//		T400_5001_02_ListReq reqMessage4 = new T400_5001_02_ListReq();
//		reqMessage4.setEntn_lkcd("202063376");
//		reqMessage4.setManf_nums("2008134963");
//		reqMessage4.setTrtm_chrg("202063376");
//		reqMessage4.setTrtm_date("20200818174100");
//		reqMessage4.setNums("2");
//		reqMessage4.setTrtm_ways("2102");
//		reqMessage4.setTrtq("300");
//		reqMessage4.setTrtq_unit("02");
//		reqMessage4.setLeft_qunt("0");
//		reqMessage4.setManb_type("1");
//		System.out.println(consumer.put("API-IFR-MP-002", reqMessage4));
//		System.out.println(consumer.get("API-IFR-MG-005", reqMessage4.getManf_nums(), "A", "N", null, null, null)); 
		
		if("0000".equals((String)message.get("resultCode"))) {
			// 정상 처리
		} else {
			// 오류 처리
			String txid = (String)message.get("txid");
			String resultMsg = (String)message.get("resultMessage");
		}

	}
}
