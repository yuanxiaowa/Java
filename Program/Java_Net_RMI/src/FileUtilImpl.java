
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class FileUtilImpl extends UnicastRemoteObject implements IFileUtil {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected FileUtilImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] downloadFile(String fileName) throws RemoteException {
		File file = new File(fileName);
		byte buffer[] = new byte[(int)file.length()];
		int size = buffer.length;
		System.out.println("download file size = " + size + "b");
		if (size > 1024 * 1024 * 10) {
			throw new RemoteException("Error:<The File is too big!>");
		}
		try {
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
			input.read(buffer, 0, size);
			input.close();
			System.out.println("Info:<downloadFile() hed execute successful!>");
			return buffer;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
