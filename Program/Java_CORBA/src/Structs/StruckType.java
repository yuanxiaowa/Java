package Structs;


/**
* Structs/StruckType.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Struct.idl
* 2015��6��2�� ���ڶ� ����02ʱ32��12�� CST
*/

public final class StruckType implements org.omg.CORBA.portable.IDLEntity
{
  public int field1 = (int)0;
  public String field2 = null;

  public StruckType ()
  {
  } // ctor

  public StruckType (int _field1, String _field2)
  {
    field1 = _field1;
    field2 = _field2;
  } // ctor

} // class StruckType
