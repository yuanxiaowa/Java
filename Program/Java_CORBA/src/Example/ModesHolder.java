package Example;

/**
* Example/ModesHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Example.idl
* 2015年6月2日 星期二 下午02时23分19秒 CST
*/

public final class ModesHolder implements org.omg.CORBA.portable.Streamable
{
  public Example.Modes value = null;

  public ModesHolder ()
  {
  }

  public ModesHolder (Example.Modes initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Example.ModesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Example.ModesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Example.ModesHelper.type ();
  }

}
