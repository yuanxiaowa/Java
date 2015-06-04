package Structs;

/**
* Structs/StruckTypeHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Struct.idl
* 2015年6月2日 星期二 下午02时32分12秒 CST
*/

public final class StruckTypeHolder implements org.omg.CORBA.portable.Streamable
{
  public Structs.StruckType value = null;

  public StruckTypeHolder ()
  {
  }

  public StruckTypeHolder (Structs.StruckType initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Structs.StruckTypeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Structs.StruckTypeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Structs.StruckTypeHelper.type ();
  }

}
