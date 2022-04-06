using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using Newtonsoft.Json.Linq;
using System.IO;
using System.Net;
using System.Net.Http;



namespace allbaroManager
{

    // 배출자 클라이언트
    public class EmisConsumer : CommonMsg
    {

        public override bool check_if_id(string if_id)
        {
            // 배출자 전용 if_id 체크 함수
            switch (if_id)
            {
                case "T100_3001_00":
                case "T100_3001_02":

                case "T200_4001_01":
                case "T200_4001_05":
                case "T200_4001_06":
                case "T200_4001_08":
                case "T200_4001_09":
                case "T200_4001_10":
                case "T200_4001_12":
                case "T200_5001_01":
                case "T200_5001_02":
                    break;

                default:
                    return false;
                    break;
            }

            return true;
        }

        public bool print_result(string result)
        {

            // 배출자 전용 if_id 체크 함수
            switch (this.if_id)
            {
                case "T100_3001_00":
                case "T100_3001_02":

                case "T200_4001_01":

                    var json_var = JObject.Parse(result);

                    var json_list = json_var["DataList"];

                    Console.WriteLine("*************************************************************");

                    Console.WriteLine(string.Format("{0} : {1}", "인터페이스 ID", json_var["ifid"]));
                    Console.WriteLine(string.Format("{0} : {1}", "트랜젝션 ID", json_var["txid"]));
                    Console.WriteLine(string.Format("{0} : {1}", "총 페이지 번호", json_var["total_page_no"])); // 이건 어떤식으로 들어오는지 모르겠음.
                    Console.WriteLine(string.Format("{0} : {1}", "연계 결과 코드", json_var["resultCode"]));
                    Console.WriteLine(string.Format("{0} : {1}", "연계 결과 메시지", json_var["resultMessage"]));
                    Console.WriteLine(string.Format("{0} : {1}", "오류 메시지", json_var["errorMessage"]));

                    Console.WriteLine("*************************************************************");



                    if (json_list == null) return false; // 데이터가 없으면 리턴한다.

                    foreach (var o in json_list)
                    {
                        Console.WriteLine("* 데이터 목록 LIST *");
                        Console.WriteLine(string.Format("{0} : {1}", "연계업체코드", o["entn_lkcd"]));
                        Console.WriteLine(string.Format("{0} : {1}", "배출업체코드", o["emis_chrg"]));
                        Console.WriteLine(string.Format("{0} : {1}", "폐기물코드", o["wste_code"]));
                        Console.WriteLine(string.Format("{0} : {1}", "성상", o["gntp"]));
                        Console.WriteLine(string.Format("{0} : {1}", "배출주기", o["emis_perd"]));
                        Console.WriteLine(string.Format("{0} : {1}", "처리구분", o["trtm_type"]));
                        Console.WriteLine(string.Format("{0} : {1}", "처리업체코드", o["trtm_chrg"]));
                        Console.WriteLine(string.Format("{0} : {1}", "처리방법코드", o["trtm_ways"]));
                        Console.WriteLine(string.Format("{0} : {1}", "처리량", o["trtm_ways"]));
                        Console.WriteLine(string.Format("{0} : {1}", "운반구분", o["trtm_qunt"]));
                        Console.WriteLine(string.Format("{0} : {1}", "운반업체코드", o["tran_type"]));
                        Console.WriteLine(string.Format("{0} : {1}", "관할관청코드", o["cmpt_auth"]));
                        Console.WriteLine(string.Format("{0} : {1}", "필증종류", o["certform_info"]));
                        Console.WriteLine(string.Format("{0} : {1}", "필증발급일", o["cert_pdate"]));
                        Console.WriteLine(string.Format("{0} : {1}", "관리(신고)번호", o["cert_pinfo"]));
                        Console.WriteLine(string.Format("{0} : {1}", "폐기물 Remark", o["wste_remk"]));
                    }

                    

                    break;

                case "T200_4001_05":
                case "T200_4001_06":
                case "T200_4001_08":
                case "T200_4001_09":
                case "T200_4001_10":
                case "T200_4001_12":
                case "T200_5001_01":
                case "T200_5001_02":
                    break;

                default:
                    return false;
                    break;
            }

            return true;
        }

        

    }

    // 운반자 클라이언트
    public class TransConsumer : CommonMsg
    {
        public override bool check_if_id(string if_id)
        {
            // 배출자 전용 if_id 체크 함수
            switch (if_id)
            {
                case "T100_3001_00":
                case "T100_3001_02":

                case "T300_4001_05":
                case "T300_4001_12":
                case "T300_4001_20":
                case "T300_4001_21":
                case "T300_4001_34":
                case "T300_5001_01":
                    break;

                default:
                    return false;
                    break;
            }

            return true;
        }

    }

    // 처리자 클라이언트
    public class TrtmConsumer : CommonMsg
    {
        public override bool check_if_id(string if_id)
        {
            // 배출자 전용 if_id 체크 함수
            switch (if_id)
            {
                case "T100_3001_00":
                case "T100_3001_02":

                case "T400_4001_05":
                case "T400_4001_12":
                case "T400_4001_20":
                case "T400_4001_21":
                case "T400_4001_22":
                case "T400_4001_35":
                case "T200_4001_12":
                case "T400_5001_02":
                case "T400_5001_01":
                    break;

                default:
                    return false;
                    break;
            }

            return true;
        }

    }


    // 공통으로 사용되는 변수, 기능, 함수들을 모아놓은 클래스
    public class CommonMsg
    {

        // header info
        public string authorization;
        public string content_type;
        public string get_url;
        public string put_url;

        // Request Body
        public string api_cert_key;    // 업체 인증키
        public string entn_lkcd;       // 업체코드
        public string manf_nums;       // 인계번호
        public string req_type;        // 요청 구분 ("N" 신규, "A" 전체, "P" 수집 )
        public string page_no;         // 페이지 번호
        public string period_from_date;// 기간 시작일( 예, "20220405" )
        public string period_to_date;  // 기간 종료일( 예, "20220406" )
        public string subcd_include_yn;// 하위 업체 포함 여부 ( "Y" or "N" )

        // Request Body
        public string if_id;           // 연계 인터페이스 ID
        public string tx_id;           // 트랜젝션 ID
        public string total_page_no;   // 총 페이지 번호
        public string result_code;     // 연계 결과 코드
        public string result_message;  // 연계 결과 메시지
        public string error_message;   // 오류 메시지
        public string DataList;        // 데이터 목록



        public virtual bool check_if_id(string if_id)
        {

            switch (if_id)
            {
                case "T100_3001_00":
                case "T100_3001_02":
                    break;

                default:
                    return false;
                    break;
            }

            return true;
        }

        public string get(string if_id, string manf_nums, string req_type, string page_no, string period_from, string period_to, string subcd_include)
        {

            string responseFromServer;

            try
            {

                if (manf_nums == null) manf_nums = "";
                if (req_type == null) return "error req_type";
                if (page_no == null) page_no = "";
                if (period_from == null) period_from = "";
                if (period_to == null) period_to = "";
                if (subcd_include == null) subcd_include = "N"; // null이여도 N로 처리


                // 인터페이스 ID가 명확한지 체크
                if (check_if_id(if_id) == false)
                {
                    return "if_id error";
                }
                else
                {
                    this.if_id = if_id;
                    update_url(if_id);
                }

                WebRequest request = WebRequest.Create(get_url);
                request.Method = "POST";    //  POST 방식으로 메시지를 보낸다, GET 방식은 캐쉬를 이용할수도 있어서 안전하지 않음.
                request.ContentType = this.content_type;

                request.Headers.Add("Authorization", this.authorization);   // Rest API 메시지 헤더에 인증 값을 넣는다.
                //Console.WriteLine(request.Headers["Authorization"]);    // 디버깅용 


                var json_request = new JObject();

                json_request.Add("api_cert_key", this.api_cert_key);
                json_request.Add("entn_lkcd", this.entn_lkcd);
                json_request.Add("manf_nums", manf_nums);
                json_request.Add("req_type", req_type);
                json_request.Add("page_no", page_no);
                json_request.Add("period_from_date", period_from);
                json_request.Add("period_to_date", period_to);
                json_request.Add("subcd_include_yn", subcd_include);

                /* 업체 발급 인증키 */
                /* 업체코드 */
                /* 인계번호 */
                /* 페이지번호(default: N) */
                /* 요청구분(default: N) */
                /* 기간시작일자 */
                /* 기간종료일자 */
                /* 하위업체 포함 여부(default: N) */


                byte[] msg = UTF8Encoding.UTF8.GetBytes(json_request.ToString());
                /////////////////////////////////////////

                Stream os = request.GetRequestStream();
                os.Write(msg, 0, msg.Length);

                os.Close();

                using (WebResponse response = request.GetResponse())
                using (Stream dataStream = response.GetResponseStream())
                using (StreamReader reader = new StreamReader(dataStream))
                {
                    responseFromServer = reader.ReadToEnd();
                }

                return responseFromServer;

            }
            catch (Exception e)
            {

                Console.WriteLine("\r\n\r\n");
                Console.WriteLine(e.ToString());
            }

            return "error";

        }


        // 생성자
        public CommonMsg()
        {
            this.api_cert_key = ConfigurationManager.AppSettings["apiKey"];
            this.entn_lkcd = ConfigurationManager.AppSettings["usercode"];

            // 올바로 개발 가이드 17페이지
            this.get_url = ConfigurationManager.AppSettings["apiURL"] + "/select"; // + "T100_3001_02";
            this.put_url = ConfigurationManager.AppSettings["apiURL"] + "/insert"; // + "T100_3001_02";
            
            String id = ConfigurationManager.AppSettings["userid"];
            string password = ConfigurationManager.AppSettings["userpassword"];

            this.content_type = "application/json;charset=utf-8";

            this.authorization = "Basic " + Convert.ToBase64String(Encoding.UTF8.GetBytes(id + ":" + password));

        }

        public int update_url(string if_id)
        {
            this.get_url = ConfigurationManager.AppSettings["apiURL"] + "/select" + if_id;
            this.put_url = ConfigurationManager.AppSettings["apiURL"] + "/insert" + if_id;

            return 0;
        }

    }

    internal class Program
    {

        static void Main(string[] args)
        {


            EmisConsumer client = new EmisConsumer();

            string result = client.get("T100_3001_02", null, "N", "N", null, null, "N");
            Console.WriteLine(result);
            client.print_result(result);

            return;
        }



    }
}
