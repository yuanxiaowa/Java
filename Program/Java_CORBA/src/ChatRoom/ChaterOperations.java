package ChatRoom;


/**
* ChatRoom/ChaterOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��ChatRoom.idl
* 2015��6��3�� ������ ����09ʱ32��04�� CST
*/

public interface ChaterOperations 
{
  String chaterName ();
  void chaterName (String newChaterName);
  void strReceived (String str, String name);
} // interface ChaterOperations
