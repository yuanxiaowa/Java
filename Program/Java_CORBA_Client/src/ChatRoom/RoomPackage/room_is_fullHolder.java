package ChatRoom.RoomPackage;

/**
* ChatRoom/RoomPackage/room_is_fullHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午10时50分17秒 CST
*/

public final class room_is_fullHolder implements org.omg.CORBA.portable.Streamable
{
  public ChatRoom.RoomPackage.room_is_full value = null;

  public room_is_fullHolder ()
  {
  }

  public room_is_fullHolder (ChatRoom.RoomPackage.room_is_full initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ChatRoom.RoomPackage.room_is_fullHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ChatRoom.RoomPackage.room_is_fullHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ChatRoom.RoomPackage.room_is_fullHelper.type ();
  }

}
