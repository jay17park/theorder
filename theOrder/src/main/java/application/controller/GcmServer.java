package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@Controller
public class GcmServer {
	
	
	public static void push(String regId) {
		// ������Ʈ ���� API key �Է�
		Sender sender = new Sender("AIzaSyDT7ICni8aXVsCbHvQoUtPH3gK7jWs31UA");
		// GCM���κ��� �߱޹��� �ܸ��� RegID �Է�.
		//String regId = " GCMf4x9pFOcXUM:APA91bFBYFuSV-Q2ZRxvXFAS5Clgb4U_lc1EWg8zqBs0wuAmjcoLbmtwOoMIMw72T7SSmVY3CPPh55gej4MsfAX6FKydfm-Pe9XzTkosifeMxfLMVey0GI6c2jWdbpKed8YmgdJX1_Oq";
		Message message = new Message.Builder().addData("msg", "push notify")
				.build();
		List<String> list = new ArrayList<String>();
		list.add(regId);
		MulticastResult multiResult;
		try {
			multiResult = sender.send(message, list, 5);
			if (multiResult != null) {
				List<Result> resultList = multiResult.getResults();
				for (Result result : resultList) {
					System.out.println(result.getMessageId());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
