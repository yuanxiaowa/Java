package ChatRoom.RoomPackage;


/**
* ChatRoom/RoomPackage/invalid_name.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午10时50分17秒 CST
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
