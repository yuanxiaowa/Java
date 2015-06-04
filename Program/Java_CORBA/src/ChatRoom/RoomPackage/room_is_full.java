package ChatRoom.RoomPackage;


/**
* ChatRoom/RoomPackage/room_is_full.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午09时32分04秒 CST
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
