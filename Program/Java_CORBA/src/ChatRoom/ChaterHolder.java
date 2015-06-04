package ChatRoom;

/**
* ChatRoom/ChaterHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����09ʱ32��04�� CST
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
