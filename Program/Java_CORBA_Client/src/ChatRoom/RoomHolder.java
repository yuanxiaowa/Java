package ChatRoom;

/**
* ChatRoom/RoomHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����10ʱ50��17�� CST
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
