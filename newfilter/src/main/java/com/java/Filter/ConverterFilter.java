package com.java.Filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.java.model.Student;
import com.java.servlet.StudentServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.util.HashMap;

public class ConverterFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String content = req.getHeader("Accept");
        //String id=req.getParameter("searchroll");
        Object data = servletRequest.getAttribute("data");
        PrintWriter out = res.getWriter();

        switch (content) {
            case "application/json":
                ObjectMapper mapper = new ObjectMapper();
                Object json = mapper.writeValueAsString(data);
                servletResponse.setContentType(content);
                out.print(json);
                break;
            case "application/xml":
                XmlMapper xmlMapper = new XmlMapper();
                Object xml = xmlMapper.writeValueAsString(data);
                servletResponse.setContentType(content);
                out.print(xml);
                break;

            default:
                out.print(data);
        }

    }

    @Override
    public void destroy() {

    }
}

