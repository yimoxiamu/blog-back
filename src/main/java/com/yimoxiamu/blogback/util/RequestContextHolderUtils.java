package com.yimoxiamu.blogback.util;

import org.slf4j.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestContextHolderUtils {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(RequestContextHolderUtils.class);
	public static final String TOKEN_KEYWORD = "Authorization";
	public static String getAuthorizationToken() {
		String token = "";
		
		HttpServletRequest request = RequestContextHolderUtils.getServletRequest();
		if(request != null) {
			token = request.getHeader(TOKEN_KEYWORD);
		}
		return token;
	}
	
	/**
	 * 获取request
	 * @return
	 */
	public static HttpServletRequest getServletRequest() {
		RequestAttributes requestAttributes = null;
		try{
			requestAttributes = RequestContextHolder.currentRequestAttributes();
		}catch (Exception e) {
			logger.error("error:", e);
		}

		if (requestAttributes != null) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			return request;
		} else {
			logger.error("请求上下文为空");
		}
		return null;
	}
	
}
