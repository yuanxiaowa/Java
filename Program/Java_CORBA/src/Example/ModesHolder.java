package Example;

/**
* Example/ModesHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Example.idl
* 2015��6��2�� ���ڶ� ����02ʱ23��19�� CST
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
