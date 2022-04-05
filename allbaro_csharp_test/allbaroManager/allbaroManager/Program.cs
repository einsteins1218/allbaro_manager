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

//c# rest api 호출하기: https://vmpo.tistory.com/71

namespace allbaroManager
{
    internal class Program
    {
        static string targetURL = "http://data.ex.co.kr/openapi/safeDriving/forecast?key=test&type=json";

        static void Main(string[] args)
        {

            //App.config 파일에서 작성했던 key명을 여기에 넣습니다.
            String data = ConfigurationManager.AppSettings["TestData"];
            // 결과는 Hello world
            Console.WriteLine(data);
            //Console.WriteLine("Press any key...");
            //Console.ReadKey();

            ////////////////////////////////////////////////////////////////////////

            ////1.WebClient 클래스 활용
            //string webClientResult = callWebClient();

           // var r = JObject.Parse(webClientResult);

            //var list = r["list"];

            //Console.WriteLine(r);
            //foreach (var o in list)
            //{
            //    Console.WriteLine(string.Format("{0} : {1}", "날짜", o["sdate"]));
            //    Console.WriteLine(string.Format("{0} : {1}", "전국교통량", o["cjunkook"]));
            //    Console.WriteLine(string.Format("{0} : {1}", "지방교통량", o["cjibangDir"]));
            //    Console.WriteLine(string.Format("{0} : {1}", "서울->대전 소요시간", o["csudj"]));
            //    Console.WriteLine(string.Format("{0} : {1}", "서울->대구 소요시간", o["csudg"]));
            //    Console.WriteLine(string.Format("{0} : {1}", "서울->울산 소요시간", o["csuus"]));
            //}

            Console.WriteLine("*************************************************************");

            string webClientResult = callWebRequest2();

            var r2 = JObject.Parse(webClientResult);

            var list2 = r2["list"];

            Console.WriteLine(r2);
            foreach (var o in list2)
            {
                Console.WriteLine(string.Format("{0} : {1}", "날짜", o["sdate"]));
                Console.WriteLine(string.Format("{0} : {1}", "전국교통량", o["cjunkook"]));
                Console.WriteLine(string.Format("{0} : {1}", "지방교통량", o["cjibangDir"]));
                Console.WriteLine(string.Format("{0} : {1}", "대전->서울 버스 소요시간", o["cdjsu_bus"]));
                Console.WriteLine(string.Format("{0} : {1}", "대구->서울 버스 소요시간", o["cdgsu_bus"]));
                Console.WriteLine(string.Format("{0} : {1}", "울산->서울 버스 소요시간", o["cussu_bus"]));
            }
        }



        public static string callWebClient()
        {
            string result = string.Empty;
            try
            {
                WebClient client = new WebClient();

                //특정 요청 헤더값을 추가해준다. 
                client.Headers.Add("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; .NET CLR 1.0.3705;)");

                using (Stream data = client.OpenRead(targetURL))
                {
                    using (StreamReader reader = new StreamReader(data))
                    {
                        string s = reader.ReadToEnd();
                        result = s;

                        reader.Close();
                        data.Close();
                    }
                }

            }
            catch (Exception e)
            {
                //통신 실패시 처리로직
                Console.WriteLine(e.ToString());
            }
            return result;
        }


        public static string callWebRequest()
        {
            string responseFromServer = string.Empty;

            try
            {

                WebRequest request = WebRequest.Create(targetURL);
                request.Method = "GET";
                request.ContentType = "application/json";

                using (WebResponse response = request.GetResponse())
                using (Stream dataStream = response.GetResponseStream())
                using (StreamReader reader = new StreamReader(dataStream))
                {
                    responseFromServer = reader.ReadToEnd();
                }

            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }

            return responseFromServer;
        }

        public static string callWebRequest2()
        {
            string responseFromServer = string.Empty;

            try
            {

                //
                // ## 예제 A. 인코딩 ##
                // 문자열을 유니코드 인코딩으로 바이트배열로 변환
                string s = "John 굿모닝";
                byte[] bytes = Encoding.Unicode.GetBytes(s);

                // 바이트들을 Base64로 변환
                string base64 = Convert.ToBase64String(bytes);

                // 출력: SgBvAGgAbgAgAH+tqLrdsg==
                Console.WriteLine(base64);


                // ## 예제 B. 디코딩 ##
                // Base64 인코드된 문자열을 바이트배열로 변환
                byte[] orgBytes = Convert.FromBase64String("SgBvAGgAbgAgAH+tqLrdsg==");

                // 바이트들을 다시 유니코드 문자열로
                string orgStr = Encoding.Unicode.GetString(orgBytes);

                // 출력: John 굿모닝
                Console.WriteLine(orgStr);
                //

                String url = ConfigurationManager.AppSettings["apiURL"]+"/select"+ "T100_3001_02";
                Console.WriteLine(url);
                String id = ConfigurationManager.AppSettings["userid"];
                string password = ConfigurationManager.AppSettings["userpassword"];

                WebRequest request = WebRequest.Create(url);
                request.Method = "POST";
                request.ContentType = "application/json;charset=utf-8";
                //request.Headers["Content-Type"] = "application/json;charset=utf-8";
                //request.Headers["Authorization"] = "Basic "+Convert.ToBase64String(Encoding.UTF8.GetBytes(id+":"+ password));
                request.Headers.Add("Authorization", "Basic " + Convert.ToBase64String(Encoding.UTF8.GetBytes(id + ":" + password)));
                Console.WriteLine(request.Headers["Authorization"]);


                //https://forum.worksmobile.com/kr/posts/100114
                String inMsg = " { \"api_cert_key\":\"+WOBv4hD6/ZlhOWctp3U9g==\", \"entn_lkcd\":\"202132969\",\"manf_nums\":\"\",\"page_no\":\"N\", \"req_type\":\"N\", \"period_from_date\":\"\",\"period_to_date\":\"\", \"subcd_include_yn\":\"N\" }";

                byte[] msg = UTF8Encoding.UTF8.GetBytes(inMsg);
                Console.WriteLine(Encoding.UTF8.GetString(msg));
                Console.WriteLine(" --------------- \r\n ");

                //request.ContentLength = msg.Length;


                /////////////////////////////////////////
                /////////////////////////////////////////
                //Stream os = request.GetRequestStream();
                //os.Write(msg, 0, msg.Length);
                //os.Close();





                /* 업체 발급 인증키 */
                /* 업체코드 */
                /* 인계번호 */
                /* 페이지번호(default: N) */
                /* 요청구분(default: N) */
                /* 기간시작일자 */
                /* 기간종료일자 */
                /* 하위업체 포함 여부(default: N) */

                using (WebResponse response = request.GetResponse())
                using (Stream dataStream = response.GetResponseStream())
                using (StreamReader reader = new StreamReader(dataStream))
                {
                    responseFromServer = reader.ReadToEnd();
                }

            }
            catch (Exception e)
            {
            
                Console.WriteLine("\r\n\r\n");
                Console.WriteLine(e.ToString());
            }

            return responseFromServer;
        }

    }

}
