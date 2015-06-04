package Example;


/**
* Example/_ModesStub.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Example.idl
* 2015年6月2日 星期二 下午02时23分19秒 CST
*/

public class _ModesStub extends org.omg.CORBA.portable.ObjectImpl implements Example.Modes
{

  public int operation (int inArg, org.omg.CORBA.IntHolder outArg, org.omg.CORBA.IntHolder inoutArg)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("operation", true);
                $out.write_long (inArg);
                $out.write_long (inoutArg.value);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                outArg.value = $in.read_long ();
                inoutArg.value = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return operation (inArg, outArg, inoutArg        );
            } finally {
                _releaseReply ($in);
            }
  } // operation

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Example/Modes:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ModesStub
