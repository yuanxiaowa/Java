package ChatRoom.RoomPackage;


/**
* ChatRoom/RoomPackage/invalid_name.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����10ʱ50��17�� CST
*/

public final class invalid_name extends org.omg.CORBA.UserException
{
  public String message = null;

  public invalid_name ()
  {
    super(invalid_nameHelper.id());
  } // ctor

  public invalid_name (String _message)
  {
    super(invalid_nameHelper.id());
    message = _message;
  } // ctor


  public invalid_name (String $reason, String _message)
  {
    super(invalid_nameHelper.id() + "  " + $reason);
    message = _message;
  } // ctor

} // class invalid_name
