package ChatRoom.RoomPackage;

/**
* ChatRoom/RoomPackage/invalid_nameHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����10ʱ50��17�� CST
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
