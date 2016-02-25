package web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("Content-type", "text/html");
        ServletOutputStream out = response.getOutputStream();

        if (request.getPathInfo().equals("/Sasha")) {
            renderSashaPage(out);
        } else if (request.getPathInfo().equals("/Natasha")) {
            renderNatashaPage(out);
        } else {
            out.println("Not found!");
        }
    }

    private void renderNatashaPage(ServletOutputStream out) throws IOException {
        out.println("Hello, I'm Nata!");
    }

    private void renderSashaPage(ServletOutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/file.txt"))));
        while (reader.ready()) {
            out.println(reader.readLine());
        }
    }
}
