package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletResponse;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        resp.setHeader("Access-Control-Allow-Origin", "*");
        if (req.getMethod().equals("Options")) {
            resp.setHeader("Access-Control-Allow-Methods", "*");
            resp.setHeader("Access-Control-Allow-Headers", "*");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
