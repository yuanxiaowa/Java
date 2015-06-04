package ChatRoom.RoomPackage;

/**
* ChatRoom/RoomPackage/invalid_nameHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午10时50分17秒 CST
*/

public final class invalid_nameHolder implements org.omg.CORBA.portable.Streamable
{
  public ChatRoom.RoomPackage.invalid_name value = null;

  public invalid_nameHolder ()
  {
  }

  public invalid_nameHolder (ChatRoom.RoomPackage.invalid_name initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ChatRoom.RoomPackage.invalid_nameHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ChatRoom.RoomPackage.invalid_nameHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ChatRoom.RoomPackage.invalid_nameHelper.type ();
  }

}
