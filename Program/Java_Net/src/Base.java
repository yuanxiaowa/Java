import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Base {
	public static void main(String[] args) {
		ImageForm imageForm = new ImageForm();
	}
	
	public static void getNetFile() {
		try {
			URL url = new URL("http://www.qq.com");
			DataInputStream dis = new DataInputStream(url.openStream());
			String inputLine;
			while ((inputLine = dis.readLine()) != null) {
				System.out.println(inputLine);
			}
			dis.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void opUrl() {
		URL url;
		try {
			url = new URL("http://www.baidu.com:80/user/info#h");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getFile());
			System.out.println(url.getRef());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void opAddr() {
		// TODO Auto-generated method stub
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("本机ip：" + address.getHostAddress());

			address = InetAddress.getByName("www.baidu.com");
			System.out.println("百度主机ip：" + address.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
