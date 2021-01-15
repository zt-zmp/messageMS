package web;

import dao.MessageDao;
import util.FastJsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/del")
public class MessageDelServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mid = Integer.parseInt(req.getParameter("mid"));
        try {
            //new MessageDao().delete(mid);
            resp.getWriter().write(FastJsonUtil.ok(1).toJSON());
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().write(FastJsonUtil.err(2, exception.getMessage()).toJSON());
        }
    }
}
