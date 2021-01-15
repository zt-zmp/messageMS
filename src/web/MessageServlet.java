package web;

import dao.MessageDao;
import entity.MessageBean;
import util.FastJsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<MessageBean> messages = new MessageDao().getMessages();
            resp.getWriter().write(FastJsonUtil.ok(messages).toJSON());
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().write(FastJsonUtil.err(222, exception.getMessage()).toJSON());
        }
    }
}
