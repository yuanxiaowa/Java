package UpperModule;

/**
* UpperModule/UpperHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��UpperModule.idl
* 2015��5��29�� ������ ����05ʱ05��57�� CST
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
