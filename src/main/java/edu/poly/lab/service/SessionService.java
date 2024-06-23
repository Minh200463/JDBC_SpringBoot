package edu.poly.lab.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
	HttpSession session;

	public SessionService(HttpSession session) {
		this.session = session;
	}
	
	public void remove(String name) {
		session.removeAttribute(name);
	}
	
	public void set(String name, Object value) {
		session.setAttribute(name, value);
	}
	
	public <T> T get(String name, T defaultValue) {
        T value = (T) session.getAttribute(name);
        return value != null ? value : defaultValue;
    }
	
}
