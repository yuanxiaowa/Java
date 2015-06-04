package UpperModule;

/**
* UpperModule/UpperHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从UpperModule.idl
* 2015年5月29日 星期五 下午05时05分57秒 CST
*/

public final class UpperHolder implements org.omg.CORBA.portable.Streamable
{
  public UpperModule.Upper value = null;

  public UpperHolder ()
  {
  }

  public UpperHolder (UpperModule.Upper initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = UpperModule.UpperHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    UpperModule.UpperHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return UpperModule.UpperHelper.type ();
  }

}
