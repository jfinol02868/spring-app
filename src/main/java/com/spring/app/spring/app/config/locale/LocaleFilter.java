package com.spring.app.spring.app.config.locale;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.i18n.LocaleContextHolder;

import java.io.IOException;
import java.util.Locale;

public class LocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String language = httpRequest.getHeader("Accept-Language");

        if (language != null && !language.isEmpty()) {
            Locale locale = Locale.forLanguageTag(language);
            LocaleContextHolder.setLocale(locale);
        }

        chain.doFilter(request, response);
    }

}
