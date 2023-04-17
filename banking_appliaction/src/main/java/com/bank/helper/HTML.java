package com.bank.helper;

public class HTML {
	
	public static String htmlEmailTemplate(String token,String code) {
		
		String url ="http://localhost:8080/verify?token="+ token +"&code="+code;
		
		String emailTemplate="<!DOCTYPE html>\r\n"
				+ "<html lang='en'>\r\n"
				+ "<head>\r\n"
				+ "    <meta charset='UTF-8'>\r\n"
				+ "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\r\n"
				+ "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <!-- <link rel='stylesheet' href='/css/email.css'> -->\r\n"
				+ "\r\n"
				+ "    <style>\r\n"
				+ "        *{\r\n"
				+ "            box-sizing: border-box;\r\n"
				+ "            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;\r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "        body{\r\n"
				+ "            height: 100vh;\r\n"
				+ "            background-color: rgba(14, 14, 225, 0.256);\r\n"
				+ "            display: flex;\r\n"
				+ "            align-items: center;\r\n"
				+ "            justify-content: center;\r\n"
				+ "        }\r\n"
				+ "        .wrapper{\r\n"
				+ "            width: 550PX;\r\n"
				+ "            height: auto;\r\n"
				+ "            padding: 15px;\r\n"
				+ "            background-color: whitesmoke;\r\n"
				+ "            border-radius: 15px;\r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "        .email-msg-header{\r\n"
				+ "            text-align: center;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .wrapper span{\r\n"
				+ "            font-size: 30px;\r\n"
				+ "            color: rgb(102, 83, 198);\r\n"
				+ "            display: block;\r\n"
				+ "            margin: 7px 0px;\r\n"
				+ "        }\r\n"
				+ "        .welcome-text{\r\n"
				+ "            text-align: center;\r\n"
				+ "            font-size: 20px;\r\n"
				+ "            margin-top: 5px;\r\n"
				+ "            margin-bottom: -1px;\r\n"
				+ "            display: inline-block;\r\n"
				+ "        }\r\n"
				+ "        .varify-account-btn{\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            padding: 10px;\r\n"
				+ "            display: inline-block;\r\n"
				+ "            \r\n"
				+ "           \r\n"
				+ "            align-items: center;\r\n"
				+ "            background-color: rgb(62, 103, 192);\r\n"
				+ "            color: white;\r\n"
				+ "            border-radius: 6px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .copy-right{\r\n"
				+ "            /* text-align: center; */\r\n"
				+ "            padding: 15px;\r\n"
				+ "            color: grey;\r\n"
				+ "            font-size: 14px;\r\n"
				+ "            margin:10px 0px;\r\n"
				+ "            display: flex;\r\n"
				+ "            align-items: center;\r\n"
				+ "            justify-content: center;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "    \r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class='wrapper'>\r\n"
				+ "        <!-- email msg header -->\r\n"
				+ "        <h2 class='email-msg-header'>\r\n"
				+ "            Welcome and Thank You ! for choosing\r\n"
				+ "            <br>\r\n"
				+ "            <span>Easy Way Bank</span>\r\n"
				+ "        </h2>\r\n"
				+ "        <hr>\r\n"
				+ "        <p class='welcome-text'>\r\n"
				+ "            Your Account has been successfully rgistered, please click below to verify your account\r\n"
				+ "        </p>\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "\r\n"
				+ "        <center> <a href='"+ url+"' class='varify-account-btn' role='button'>Verify Account</a></center>\r\n"
				+ "        <div class='copy-right'>\r\n"
				+ "            &copy; copy right 2023. All Rights Reserved.\r\n"
				+ "        </div>\r\n"
				+ "    \r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		
		return "";
	}

}
