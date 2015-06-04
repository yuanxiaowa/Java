import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class FileUtilClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "rmi://10.0.0.112:1099/FileUtilServer";
		IFileUtil fileUtil;
		try {
			fileUtil = (IFileUtil)Naming.lookup(name);
			byte[] filedata = fileUtil.downloadFile("x.png");
			if (filedata == null) {
				System.out.println("Error: <filedata is null!>");
				System.exit(0);
			}
			File file = new File("y.png");
			System.out.println("file.getAbosolutePath() = " + file.getAbsolutePath());
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
			output.write(filedata, 0, filedata.length);
			output.flush();
			output.close();
			System.out.println("~~~~~~~~~~~~End~~~~~~~~~~~~");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
