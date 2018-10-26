package com.bdi.sp.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bdi.sp.vo.Chat;
import com.fasterxml.jackson.databind.ObjectMapper;

@ServerEndpoint(value="/chat")
public class WebSocket {
	private static final Logger logger = LoggerFactory.getLogger(WebSocket.class);
	private static List<Session> ssList = Collections.synchronizedList(new ArrayList<Session>());
	private static ObjectMapper om = new ObjectMapper();
	
	@OnMessage
	public void onMessage(String text, Session ss) throws IOException {
		logger.info("msg : {}", text);
		//Chat chat = om.readValue(text, Chat.class);
		logger.info("session list size=>{}",ssList.size());
			synchronized(ssList) {
				for(Session s : ssList) {
					if(s!=ss) {
						s.getBasicRemote().sendText(text);
					}
				}
			}
		}
	@OnError
	public void onError(Throwable e) {
		logger.error("websocket error=>{}",e);
	}
	@OnOpen
	public void onOpen(Session ss) {
		logger.info("WebSession=>{}",ss);
		ssList.add(ss);
	}
	@OnClose
	public void onClose(Session ss) {
		ssList.remove(ss);
	}
}
