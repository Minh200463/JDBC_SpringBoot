package edu.poly.lab.lab7;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("mailer")
public class MailerController {
	@Autowired
	MailerService mailer;
	
	@RequestMapping("form")
	public String form() {
		
		return "lab7/form";
	}
	
	
	@RequestMapping("send")
	public String send(@RequestParam("from") String from,
            @RequestParam(value =  "to", required = false) String to,
            @RequestParam(value = "cc", required = false) String cc,
            @RequestParam(value = "bcc", required = false) String bcc,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body,
            @RequestParam("attachments") MultipartFile[] attachments,
            Model model) {
		
			MailInfo mailinfo = new MailInfo();
			mailinfo.setFrom(from);
			mailinfo.setTo(to);
			mailinfo.setCc(cc != null ? cc.split(",") : new String[0]);
			mailinfo.setBcc(bcc != null ? bcc.split(",") : new String[0]);
			mailinfo.setSubject(subject);
			mailinfo.setBody(body);
			mailinfo.setAttachments(Arrays.stream(attachments).map(MultipartFile::getOriginalFilename).toArray(String[] :: new));
		
			
		try {
			mailer.send(mailinfo, attachments);
			model.addAttribute("message","Email của bạn sẽ được gửi trong giây lát!");
		} catch (Exception e) {
			model.addAttribute("message", "Thất bại!"+e.getMessage());
		}
		return "lab7/form";
	}
	
	
}
