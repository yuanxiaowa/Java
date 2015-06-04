package ChatRoom;


/**
* ChatRoom/RoomOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午10时50分17秒 CST
*/

public interface RoomOperations 
{
  void register (ChatRoom.ChaterHolder aChater) throws ChatRoom.RoomPackage.room_is_full, ChatRoom.RoomPackage.invalid_name;
  void unregister (ChatRoom.ChaterHolder aChater);
  void StrReceived (String name, String sentence);
  void shutdown ();
} // interface RoomOperations
