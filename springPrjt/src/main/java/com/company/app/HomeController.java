package com.company.app;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home/home";
	}

	@RequestMapping("/excelUp")
	public void excelUp(HttpServletResponse res) throws MalformedURLException {
		URL url = new URL(
				"http://http://www.kobis.or.kr/kobis/business/mast/thea/findSchedule.do?theaCd=012020&showDt=20180629"); // 요청을
																															// 보낼
																															// URL
		// String sendData = getMdbData();
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.connect();

			// 송신할 데이터 전송.
			send(con, ("theaCd=012020&showDt=20180629").getBytes());

			int resCode = con.getResponseCode();

			if (resCode == HttpURLConnection.HTTP_OK) {
				String result = read(con);
				ServletOutputStream out = res.getOutputStream();
				out.println(result);
			} else {
				throw new IOException("ERROR : Communication Error\nMSG Code : " + resCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
		}
	}

	/**
	 * 전송하는 부분
	 * 
	 * @param p_con
	 * @throws IOException
	 */
	private void send(HttpURLConnection con, byte[] p_writeMsg) throws IOException {
		DataOutputStream dos = new DataOutputStream(con.getOutputStream());
		dos.write(p_writeMsg);
		dos.flush();
	}

	/**
	 * 수신하는 부분
	 * 
	 * @param p_con
	 * @throws IOException
	 */
	private String read(HttpURLConnection con) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String strData = null;
		StringBuffer sb = new StringBuffer();
		while ((strData = br.readLine()) != null) {
			sb.append(strData);
		}
		return new String(sb.toString().getBytes());
	}
}
