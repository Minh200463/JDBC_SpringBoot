package edu.poly.lab.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import edu.poly.lab.model.Accounts;
import edu.poly.lab.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SessionService session;	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		Accounts user = session.get("user", null); // lấy từ session
		String error = "";
		if (user == null) { // chưa đăng nhập
			error = "Please login!";	
		}
		// không đúng vai trò
		else if (!user.isAdmin()) {
			 error = "Access denied!";
			 System.out.println("Error: "+error);
		}
		System.out.println("Error: "+error);
		if (error.length() > 0) { // có lỗi
			session.set("security-uri", uri);
			response.sendRedirect("/account/login?error=" + error);
			return false;
		}
		return true;
	}

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		  String uri = request.getRequestURI();
//		  String error = "";
//	        // Kiểm tra user trong session
//	        Accounts user = session.get("user", null);
//	        if (user == null) {
//	            // Nếu user không tồn tại, chuyển hướng đến trang đăng nhập và lưu URI vào session
//	            error = "Please login!";
//	            session.set("security-uri", uri);
//	            response.sendRedirect("/account/login?error=" + error);
//	            return false;
//	        } else {
//	            // Kiểm tra quyền truy cập nếu user tồn tại
//	            if (!user.isAdmin() && uri.startsWith("/account/admin/")) {
//	                error = "Access denied!";
//	                session.set("security-uri", uri);
//	                response.sendRedirect("/account/login?error=" + error);
//	                return false;
//	            }
//	        }
//	        System.out.println("Error: "+error);
//	        session.set("security-uri", null);
//	        return true;
//	}
}
