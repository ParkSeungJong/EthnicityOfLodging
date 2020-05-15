package com.hr.json;
import org.apache.log4j.Logger;

import com.google.gson.*;
import com.mal_a.cmn.MessageVO;

public class MsgMain {
	private final static Logger LOG=Logger.getLogger(MsgMain.class);
	public static void main(String[] args) {
		
		
		//Controller ->화면
		Gson gson = new Gson();
		MessageVO msg=new MessageVO("01","등록성공");
		String gsonStr = gson.toJson(msg);
		//gsonStr:{"msgId":"01","msgContents":"등록성공","pageSize":0,"pageNum":0,"total":0,"num":0}

		LOG.debug("gsonStr:"+gsonStr);
		
		
	}

}
