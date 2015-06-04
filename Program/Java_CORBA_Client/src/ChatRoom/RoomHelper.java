package ChatRoom;


/**
* ChatRoom/RoomHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����10ʱ50��17�� CST
*/

abstract public class RoomHelper
{
  private static String  _id = "IDL:ChatRoom/Room:1.0";

  public static void insert (org.omg.CORBA.Any a, ChatRoom.Room that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ChatRoom.Room extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (ChatRoom.RoomHelper.id (), "Room");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ChatRoom.Room read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_RoomStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ChatRoom.Room value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static ChatRoom.Room narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ChatRoom.Room)
      return (ChatRoom.Room)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ChatRoom._RoomStub stub = new ChatRoom._RoomStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static ChatRoom.Room unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof ChatRoom.Room)
      return (ChatRoom.Room)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      ChatRoom._RoomStub stub = new ChatRoom._RoomStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
