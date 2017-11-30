package com.gome.lark.role.controller;


import com.gome.lark.common.utils.R;
import com.gome.lark.role.auth.ShiroUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录相关
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@Controller
public class SysLoginController {
	@Autowired
	private Producer producer;

//	@ResponseBody
	@RequestMapping(value = "/user/captcha" ,method = RequestMethod.GET)
	public void postCaptcha(HttpServletResponse response)throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("application/json;charset=UTF8");

        //生成文字验证码
        String text = producer.createText();
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        
//        ServletOutputStream out = response.getOutputStream();
		PrintWriter pw = response.getWriter();
		pw.print("{\"msg\":\""+text+"\",\"code\":200}");
		pw.flush();
	}

	@RequestMapping(value = "/user/captcha.jpg", method = RequestMethod.GET)
	public void getCaptcha(HttpServletResponse response)throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//生成文字验证码
		String text = producer.createText();
		//生成图片验证码
		BufferedImage image = producer.createImage(text);
		//保存到shiro session
		ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}

	@ResponseBody
	@RequestMapping(value = "/user/token", method = RequestMethod.GET)
	public void getToken(HttpServletRequest request, HttpServletResponse response, String username, String password)throws ServletException, IOException{

//		Assert.isBlank(username, "用户名不能为空");
//		Assert.isBlank(password, "密码不能为空");
//
//		//用户登录
//		long userId = userService.login(username, password);
//
//		//生成token
//		String token = jwtUtils.generateToken(userId);
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("token", token);
//		map.put("expire", jwtUtils.getExpire());
//
//		return R.ok(map);

	}
	
	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public R login(String username, String password, String captcha)throws IOException {
		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}
		
		try{
			Subject subject = ShiroUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
		}catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			return R.error("账号或密码不正确");
		}catch (LockedAccountException e) {
			return R.error("账号已被锁定,请联系管理员");
		}catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}
	    
		return R.ok();
	}
	
	/**
	 * 退出
	 */
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:login.html";
	}
	
}
