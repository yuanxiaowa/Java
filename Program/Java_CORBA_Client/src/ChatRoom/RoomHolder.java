package ChatRoom;

/**
* ChatRoom/RoomHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午10时50分17秒 CST
*/

public final class RoomHolder implements org.omg.CORBA.portable.Streamable
{
  public ChatRoom.Room value = null;

  public RoomHolder ()
  {
  }

  public RoomHolder (ChatRoom.Room initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ChatRoom.RoomHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ChatRoom.RoomHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ChatRoom.RoomHelper.type ();
  }

}
