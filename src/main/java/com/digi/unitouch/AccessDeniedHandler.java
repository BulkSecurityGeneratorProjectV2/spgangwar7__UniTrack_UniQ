package com.digi.unitouch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;

@Component("accessDeniedHandler")
public class AccessDeniedHandler extends AccessDeniedHandlerImpl {

	private static final Logger log = LogManager.getLogger(AccessDeniedHandler.class);

	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

		log.info("Error in AccessDeniedHandler" + request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION"));

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {

			redirectStrategy.sendRedirect(request, response, "/login");
		}

		super.handle(request, response, accessDeniedException);
	}
}
