package Web;

import Domain.User;
import Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkCode = request.getParameter("checkCode");
        String checkCode1 = (String)request.getSession().getAttribute("checkCode");
        System.out.println(checkCode1);
        if(!checkCode1.equalsIgnoreCase(checkCode)){
            request.setAttribute("checkCode_err","验证码错误");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setPassword(password);
        user.setUsername(username);
        UserService userService = new UserService();
        User user1 = userService.selectByUsername(user);
        System.out.println(user1);
        if(user1!=null){
            request.setAttribute("reg_err","该用户名已被注册");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
        userService.add(user);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
