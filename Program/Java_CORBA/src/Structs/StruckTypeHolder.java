package Structs;

/**
* Structs/StruckTypeHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Struct.idl
* 2015��6��2�� ���ڶ� ����02ʱ32��12�� CST
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
