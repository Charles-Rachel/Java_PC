import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;

public class PCTest {
    public static void main(String[] args) throws Exception {
        //打开浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建请求
        HttpGet httpGet=new HttpGet("http://www.baidu.com");
        //发起请求
        CloseableHttpResponse response=httpClient.execute(httpGet);
        //解析响应
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntity=response.getEntity();
            String content= EntityUtils.toString(httpEntity,"utf-8");
            System.out.println(content);
        }
    }
}
