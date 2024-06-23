//package edu.poly.lab.lab7;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import edu.poly.lab.repository.CategoryRepository;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Service
//public class GlobalInterceptor implements HandlerInterceptor {
//	@Autowired
//	CategoryRepository categoryrepository;
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		System.out.println("URIIIIIIII: "+request.getRequestURI());
//		request.setAttribute("uri", request.getRequestURI());
//		return true;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mv)
//			throws Exception {
//		req.setAttribute("categories", categoryrepository.findAll());
//	}
//
//}
