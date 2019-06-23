package com.leetcode.test;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadSafe implements Servlet {
    private final AtomicLong count = new AtomicLong(0);
    public void init(ServletConfig config) throws ServletException {

    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        count.incrementAndGet();
    }

    public String getServletInfo() {
        return null;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void destroy() {

    }
}
