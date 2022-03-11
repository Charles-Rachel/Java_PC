import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class PCPostTest {
    public static void main(String[] args) throws Exception {
        //打开浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建请求
        HttpPost httpPost=new HttpPost("http://42.192.37.109:8080/tmall/admin/login/doLogin");
        List<NameValuePair> params=new ArrayList<>();
        params.add(new BasicNameValuePair("username","admin"));
        params.add(new BasicNameValuePair("username","123"));
        UrlEncodedFormEntity formEntity=new UrlEncodedFormEntity(params,"utf-8");
        httpPost.setEntity(formEntity);
//        HttpPost httpPost=new HttpPost("http://www.baidu.com");
        //发起请求
        CloseableHttpResponse response=httpClient.execute(httpPost);
        //解析响应
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntity=response.getEntity();
            String content= EntityUtils.toString(httpEntity,"utf-8");
            System.out.println(content);
        }
    }
}
