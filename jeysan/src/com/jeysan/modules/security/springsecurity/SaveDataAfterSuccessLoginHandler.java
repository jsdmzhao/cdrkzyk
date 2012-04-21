package com.jeysan.modules.security.springsecurity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.jeysan.cpf.security.entity.Resource;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.cpf.security.service.ResourceManager;
import com.jeysan.cpf.security.service.UserManager;
import com.jeysan.modules.cookie.CookieUtils;

public class SaveDataAfterSuccessLoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private UserManager userManager;
	private ResourceManager resourcManager;
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
		//扩展
        HttpSession session = request.getSession();
        String orgcode = request.getParameter("j_orgcode").trim();
		String username = request.getParameter("j_username").trim();
        User user = userManager.getUser(orgcode, username);
        Map<Resource,List> hasResources = resourcManager.getAllResources(user.getId(), null);
        session.setAttribute("_js_user", user);
        session.setAttribute("_js_hasResources", hasResources);
        
        CookieUtils.addEffectiveSessionId(request,response, username,"j_username");
        CookieUtils.addEffectiveSessionId(request,response, orgcode,"j_orgcode");
        
        
        SavedRequest savedRequest = getRequest(request, response);
        if (savedRequest == null) {
            super.onAuthenticationSuccess(request, response, authentication);
            return;
        }
        if (isAlwaysUseDefaultTargetUrl() || StringUtils.hasText(request.getParameter(getTargetUrlParameter()))) {
            removeRequest(request, response);
            super.onAuthenticationSuccess(request, response, authentication);
            return;
        }
        clearAuthenticationAttributes(request);
        
        
        // Use the DefaultSavedRequest URL
        String targetUrl = savedRequest.getRedirectUrl();
        logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
	
	public SavedRequest getRequest(HttpServletRequest currentRequest, HttpServletResponse response) {
        HttpSession session = currentRequest.getSession(false);
        if (session != null) {
            return (DefaultSavedRequest) session.getAttribute(WebAttributes.SAVED_REQUEST);
        }
        return null;
    }
	
	public void removeRequest(HttpServletRequest currentRequest, HttpServletResponse response) {
        HttpSession session = currentRequest.getSession(false);
        if (session != null) {
            logger.debug("Removing DefaultSavedRequest from session if present");
            session.removeAttribute(WebAttributes.SAVED_REQUEST);
        }
    }
	
	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	@Autowired
	public void setResourcManager(ResourceManager resourcManager) {
		this.resourcManager = resourcManager;
	}
	
	
}
