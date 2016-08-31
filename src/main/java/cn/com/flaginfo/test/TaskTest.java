package cn.com.flaginfo.test;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import cn.com.flaginfo.util.HttpClientUtil;

public class TaskTest {
	
	private static Logger logger = Logger.getLogger(TaskTest.class);  
	private String url = "http://localhost:8080/yzhw-app-web/";
	private HttpClientUtil clientUtil = null;
	
	//状态码
	private String resultCode;
	private String stateCode;

	@Before
	public void init() {
		clientUtil = HttpClientUtil.getInstance();
		stateCode = "200";
	}

	@Test
	public void testTaskList() {
		url += "/task/taskList";
		String str = clientUtil.sendHttpPost(url, "");
		JSONObject object = new JSONObject(str);
		if(object.has("head")){
			JSONObject headObj = object.getJSONObject("head");
			if(headObj.has("resultCode")){
				resultCode = headObj.getString("resultCode");
			}
		}
		logger.info("str:" + str);
		assertEquals(stateCode, resultCode);
	}
}
