package ChatRoom.RoomPackage;

/**
* ChatRoom/RoomPackage/room_is_fullHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����10ʱ50��17�� CST
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
