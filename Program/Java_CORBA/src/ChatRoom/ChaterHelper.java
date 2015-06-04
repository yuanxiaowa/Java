package ChatRoom;


/**
* ChatRoom/ChaterHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午09时32分04秒 CST
*/

abstract public class ChaterHelper
{
  private static String  _id = "IDL:ChatRoom/Chater:1.0";

  public static void insert (org.omg.CORBA.Any a, ChatRoom.Chater that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ChatRoom.Chater extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ChatRoom.ChaterHelper.id (), "Chater");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ChatRoom.Chater read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ChaterStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ChatRoom.Chater value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ChatRoom.Chater narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ChatRoom.Chater)
      return (ChatRoom.Chater)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ChatRoom._ChaterStub stub = new ChatRoom._ChaterStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ChatRoom.Chater unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ChatRoom.Chater)
      return (ChatRoom.Chater)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ChatRoom._ChaterStub stub = new ChatRoom._ChaterStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
