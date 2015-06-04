package ChatRoom.RoomPackage;


/**
* ChatRoom/RoomPackage/room_is_full.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����09ʱ32��04�� CST
*/

public final class room_is_full extends org.omg.CORBA.UserException
{
  public String message = null;

  public room_is_full ()
  {
    super(room_is_fullHelper.id());
  } // ctor

  public room_is_full (String _message)
  {
    super(room_is_fullHelper.id());
    message = _message;
  } // ctor


  public room_is_full (String $reason, String _message)
  {
    super(room_is_fullHelper.id() + "  " + $reason);
    message = _message;
  } // ctor

} // class room_is_full
