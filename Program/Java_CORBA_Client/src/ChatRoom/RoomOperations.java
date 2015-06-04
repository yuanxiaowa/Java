package ChatRoom;


/**
* ChatRoom/RoomOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����10ʱ50��17�� CST
*/

public interface RoomOperations 
{
  void register (ChatRoom.ChaterHolder aChater) throws ChatRoom.RoomPackage.room_is_full, ChatRoom.RoomPackage.invalid_name;
  void unregister (ChatRoom.ChaterHolder aChater);
  void StrReceived (String name, String sentence);
  void shutdown ();
} // interface RoomOperations
