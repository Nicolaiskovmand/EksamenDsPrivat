import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import JsonClasses.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		String modifiedSentence;
		Gson gson = new GsonBuilder().create();
		// DETTE ER TIL AT TESTE BRUGER
		/*AuthUser user = new AuthUser();
		user.setAuthUserEmail("nsn@msn.dk");
		user.setAuthUserPassword("1234");
		user.setAuthUserIsAdmin(false);
		
		String gsonString = gson.toJson(user);
		System.out.println(user);
		System.out.println(gsonString);*/
		
		//DETTE ER TIL AT TESTE CALENDER
		CreateCalendar Cal = new CreateCalendar();
		Cal.setCalendarName("CBS");
		Cal.setUserName("NSN@msn.dk");
		Cal.setPublicOrPrivate(0);
		
		String CalJson = gson.toJson(Cal);
		
		System.out.println(CalJson);
		
				
		

		Socket clientSocket = new Socket("localhost", 8888);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		byte[] input = CalJson.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);

		outToServer.write(encrypted);
		outToServer.flush();
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		modifiedSentence = inFromServer.readLine();
		System.out.println(modifiedSentence);
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}
}