package Web;

import Domain.User;
import Service.UserService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        System.out.println(remember);
        UserService userService = new UserService();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userService.selectOneUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        if(user1!=null){
            if("on".equals(remember)) {
                Cookie cookie = new Cookie("un", username);
                response.addCookie(cookie);
                Cookie pw = new Cookie("pw", password);
                Cookie rem = new Cookie("rem","on");
                response.addCookie(pw);
                response.addCookie(rem);
            }
            response.sendRedirect("selectAllBrand");
        }else {
            request.setAttribute("login_esm","用户名或密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
