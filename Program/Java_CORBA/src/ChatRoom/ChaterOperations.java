package ChatRoom;


/**
* ChatRoom/ChaterOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午09时32分04秒 CST
*/

public interface ChaterOperations 
{
  String chaterName ();
  void chaterName (String newChaterName);
  void strReceived (String str, String name);
} // interface ChaterOperations
