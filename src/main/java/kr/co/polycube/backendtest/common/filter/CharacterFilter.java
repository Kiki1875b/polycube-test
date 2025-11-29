package kr.co.polycube.backendtest.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class CharacterFilter implements Filter {

  private static final String CHAR_PATTERN = "[^a-zA-Z0-9/?&=:]";
  private static final String ERROR_JSON = """
      {
        "reason": "허용되지 않은 요청입니다."
      }
      """;
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;

    String url = req.getRequestURI();
    String query = req.getQueryString();

    if(query != null) {
      url += "?" + query;
    }

    if(url.matches(".*" + CHAR_PATTERN + ".*")){
      res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      res.setContentType("application/json;charset=UTF-8");
      res.getWriter().write(ERROR_JSON);
      return;
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
