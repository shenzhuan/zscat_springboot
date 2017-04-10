package com.zsTrade.web.sys.utils;

import java.lang.reflect.Member;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import com.zsTrade.common.beetl.utils.BeetlUtils;
import com.zsTrade.common.constant.Constant;
import com.zsTrade.common.spring.utils.SpringContextHolder;
import com.zsTrade.common.utils.CacheUtils;
import com.zsTrade.common.utils.TreeUtils;
import com.zsTrade.web.sys.model.SysOffice;
import com.zsTrade.web.sys.model.SysResource;
import com.zsTrade.web.sys.model.SysRole;
import com.zsTrade.web.sys.model.SysUser;
import com.zsTrade.web.sys.service.SysOfficeService;
import com.zsTrade.web.sys.service.SysResourceService;
import com.zsTrade.web.sys.service.SysRoleService;
import com.zsTrade.web.sys.service.SysUserService;

/**
 * @ClassName:SysUserUtils
 * @date:2015年2月4日 下午8:12:41
 * @author  ?
 */
public class SysUserUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(SysUserUtils.class);

	/**
	 * 得到当前session
	 */
	public static HttpSession getSession() {
		HttpSession session = getCurRequest().getSession();
		return session;
	}
	
	/**
	 * session中的用户
	 */
	public static SysUser getSessionLoginUser(){
		return (SysUser) getSession().getAttribute(Constant.SESSION_LOGIN_USER);
	}
	
	/**
	 * @Title: getCurRequest
	 * @Description:(获得当前的request) 
	 * @param:@return 
	 * @return:HttpServletRequest
	 */
	public static HttpServletRequest getCurRequest(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if(requestAttributes != null && requestAttributes instanceof ServletRequestAttributes){
			ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
			return servletRequestAttributes.getRequest();
		}
		return null;
	}
	
}
