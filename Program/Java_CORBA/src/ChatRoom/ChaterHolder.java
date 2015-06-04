package ChatRoom;

/**
* ChatRoom/ChaterHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午09时32分04秒 CST
*/

public final class ChaterHolder implements org.omg.CORBA.portable.Streamable
{
  public ChatRoom.Chater value = null;

  public ChaterHolder ()
  {
  }

  public ChaterHolder (ChatRoom.Chater initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ChatRoom.ChaterHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ChatRoom.ChaterHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ChatRoom.ChaterHelper.type ();
  }

}
