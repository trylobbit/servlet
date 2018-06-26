package com.satyla.hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class RateForDateUploader extends HttpServlet {

    private RateService rateService;

    @Override
    public void init() {
        rateService = new RateService();
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {

        String date = httpServletRequest.getParameter("date");
        if(!(DateValidator.isDateCorrect(date))){
            httpServletRequest.setAttribute("error", "Invalid date");
            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);

        }
        else{
        Rate rate = null;
        try {
            rate = rateService.getRateForDate(date);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        httpServletResponse.setContentType("text/html;charset=UTF-8");
        httpServletRequest.setAttribute("date", date);
        httpServletRequest.setAttribute("symbol", "&#8364");
        httpServletRequest.setAttribute("message", rate.getRates().get(0).getAsk());
        httpServletRequest.getRequestDispatcher("result.jsp").forward(httpServletRequest, httpServletResponse);

    }
    }
}
