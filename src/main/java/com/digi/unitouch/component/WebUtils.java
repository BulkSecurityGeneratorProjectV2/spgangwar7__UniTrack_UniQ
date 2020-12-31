package com.digi.unitouch.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.UserTracker;

@Component
@Service
public class WebUtils {

	//private static DatabaseReader dbReader;
	private static HttpServletRequest request;

	@Autowired
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}



	public static UserTracker getClientIp(Integer userid) {
		UserTracker userTracker = new UserTracker();
		String remoteAddr = "";

		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			userTracker.setEmail_id(request.getRemoteUser());
			request.getServerName();
			request.getScheme();
			request.getAttributeNames();
			request.getContextPath();
			userTracker.setLogin_ip(request.getLocalAddr());
			request.getLocalName();
			request.getRemoteHost();
			String ip = request.getRemoteAddr();

			request.getRequestURL();
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}
	//	getIpLocation(remoteAddr);
		 SimpleDateFormat sd = new SimpleDateFormat(
		            "yyyy.MM.dd G 'at' HH:mm:ss z");
		        Date date = new Date();
		        sd.setTimeZone(TimeZone.getTimeZone("IST"));
		        System.out.println(sd.format(date));
		userTracker.setUser_name(userid.toString());
		userTracker.setLogin_at(sd.format(date));
		Map<String, String> userApplication=getRequestHeadersInMap(request);
		userTracker.setUserApplication(userApplication.toString());
		//System.out.println("userTracker--------->"+userTracker.toString());
		return userTracker;
	}

	private static Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

		Map<String, String> result = new HashMap<>();
		
		Enumeration headerNames = request.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			result.put(key, value);
		}

		return result;
	}
}