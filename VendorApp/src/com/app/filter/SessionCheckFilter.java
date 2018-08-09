package com.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheckFilter implements Filter {

	private List<String> noCheckUris=null;

	public void init(FilterConfig fConfig) throws ServletException {
		noCheckUris=new ArrayList<String>();

		String uris=fConfig.getInitParameter("noCheckUrls");
		StringTokenizer str=new StringTokenizer(uris,",");
		while (str.hasMoreTokens()) {
			String s=str.nextToken();
			noCheckUris.add(s);
		}
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;

		//cache clear lines
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		res.setHeader("Pragma", "no-cache");	
		res.setDateHeader("Expires", 0); 
		
		
		String uri=req.getRequestURI();

		
		boolean status=noCheckUris.contains(uri);
		try {

			if(!status){
				//System.out.println("session check need:"+uri);
				//read current session
				HttpSession ses=req.getSession(false);
				if(ses==null || ses.getAttribute("userName")==null){
					//goto Home...
					res.sendRedirect(req.getContextPath());
				}
			}
			/*else{
				System.out.println("no session check required"+uri);	
			}*/
		} catch (Exception e) {	}
		//process to Servlet
		chain.doFilter(request, response);
	}


	public void destroy() {
	}

}
