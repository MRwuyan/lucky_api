package com.exhk.robot.order.utils.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * httpclient请求4.1版本
 * 
 * @author chenqing.chang
 *
 */
public class HttpTool {
	private static final Log log = LogFactory.getLog(HttpTool.class);

	private static HttpTool instance;
	private static ThreadSafeClientConnManager cm = null;

	private HttpTool() {
	}

	public synchronized static HttpTool getInstance() {
		if (instance == null) {
			init();
			instance = new HttpTool();
		}
		return instance;
	}

	@SuppressWarnings("deprecation")
	private static void init() {
		Scheme https = new Scheme("https", SSLSocketFactory.getSocketFactory(),
				443);
		Scheme http = new Scheme("http", 80,
				PlainSocketFactory.getSocketFactory());

		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(https);
		schemeRegistry.register(http);
		cm = new ThreadSafeClientConnManager(schemeRegistry);
		cm.setMaxTotal( com.exhk.robot.order.utils.http.Consts.MAXTOTALCONNECTIONS);
		// 每条通道的并发连接数设置（连接池）
		cm.setDefaultMaxPerRoute( com.exhk.robot.order.utils.http.Consts.MAXCONNECTIONPERHOST);

	}

	private HttpClient getHttpClient() {
		HttpParams params = new BasicHttpParams();
		params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION,
				HttpVersion.HTTP_1_1);
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,
		 com.exhk.robot.order.utils.http.Consts.CONNECTIONTIMEOUT);// 设置连接超时时间
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT,
		 com.exhk.robot.order.utils.http.Consts.SOCKETTIMEOUT);// 数据读取超时时间

		DefaultHttpClient defaultHttpClient = new DefaultHttpClient(cm, params);

		return defaultHttpClient;

	}

	public void release() {
		if (cm != null) {
			cm.shutdown();
		}
	}

	public String get(String url) throws Exception {
		return get(url,   com.exhk.robot.order.utils.http.Consts.UTF_8_ENCODING);
	}

	public String post(String url, Map<String, List<String>> parmMap)
			throws Exception {
		return post(url, parmMap, Consts.UTF_8_ENCODING);
	}

	private String get(String url, String encode) throws Exception {
		HttpClient client = getHttpClient();
		HttpGet get = null;
		try {
			get = new HttpGet(url);
			HttpResponse response = client.execute(get);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				String res = EntityUtils.toString(entity, encode);
				return res;
			} else {
				log.error(url + "请求页面错误状态码为:" + statusLine.getStatusCode());
			}

		} catch (Exception e) {
			log.error("请求页面出现异常---" + e);
			throw e;
		} finally {
			if (get != null)
				get.abort();
		}
		return null;
	}

	private String post(String url, Map<String, List<String>> parmMap,
			String encode) throws Exception {
		HttpClient client = getHttpClient();
		HttpPost post = null;
		try {
			post = new HttpPost(url);

			if (parmMap != null && parmMap.size() > 0) {
				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				for (Entry<String, List<String>> map : parmMap.entrySet()) {
					String name = map.getKey();
					List<String> valueList = map.getValue();
					for (String value : valueList) {
						BasicNameValuePair nameValuePair = new BasicNameValuePair(
								name, value);
						formparams.add(nameValuePair);
					}
				}
				UrlEncodedFormEntity uefentity = new UrlEncodedFormEntity(
						formparams, encode);
				post.setEntity(uefentity);
			}

			HttpResponse response = client.execute(post);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				String res = EntityUtils.toString(entity, encode);
				return res;
			} else {
				log.error(url + "请求页面错误状态码为:" + statusLine.getStatusCode());
			}
		} catch (Exception e) {
			log.error("请求页面出现异常---" + e);
			throw e;
		} finally {
			if (post != null)
				post.abort();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(URLDecoder.decode("%CE%B4%D6%AAip%CD%F8%C2%E7",
				"gbk"));
		System.out
				.println(HttpTool
						.getInstance()
						.get("http://php.weather.sina.com.cn/xml.php?city=%CA%A1%D6%B1%CF%BD%D0%D0%D5%FE%B5%A5%CE%BB&password=DJOYnieT8234jlsK&day=0",
								"utf-8"));
	}

	public   String sendHttpsJson(String url, String jsonStr, String encode) {
		HttpPost httppost = new HttpPost(url);
		try {

			HttpClient httpclient = new DefaultHttpClient();
			SSLContext ctx = SSLContext.getInstance("SSL");
			X509TrustManager tm = new X509TrustManager() {

				public void checkClientTrusted(X509Certificate[] xcs,
						String string) throws CertificateException {

				}

				public void checkServerTrusted(X509Certificate[] xcs,
						String string) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(ctx);

			ClientConnectionManager ccm = httpclient.getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, ssf));

			StringEntity s = new StringEntity(jsonStr, "utf-8");
			s.setContentEncoding(encode);
			s.setContentType("application/json");
			httppost.setEntity(s);

			System.out.println("REQUEST:" + httppost.getURI());
			String responseBody;
			HttpResponse response = 	httpclient.execute(httppost );
			HttpEntity entity = response.getEntity();
			responseBody = EntityUtils.toString(entity, encode);

			System.out.println(responseBody);

			// Create a response handler

			return responseBody;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (httppost != null)
				httppost.abort();
		}
		return null;
	}

	public static HttpClient getHttpsClient() throws NoSuchAlgorithmException,
			KeyManagementException {
		HttpClient httpclient = new DefaultHttpClient();
		SSLContext ctx = SSLContext.getInstance("SSL");
		X509TrustManager tm = new X509TrustManager() {

			public void checkClientTrusted(X509Certificate[] xcs, String string)
					throws CertificateException {

			}

			public void checkServerTrusted(X509Certificate[] xcs, String string)
					throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		ctx.init(null, new TrustManager[] { tm }, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx);

		ClientConnectionManager ccm = httpclient.getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", 443, ssf));
		return httpclient;
	}

}
