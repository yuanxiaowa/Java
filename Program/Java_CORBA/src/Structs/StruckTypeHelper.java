package Structs;


/**
* Structs/StruckTypeHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Struct.idl
* 2015年6月2日 星期二 下午02时32分12秒 CST
*/

abstract public class StruckTypeHelper
{
  private static String  _id = "IDL:Structs/StruckType:1.0";

  public static void insert (org.omg.CORBA.Any a, Structs.StruckType that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Structs.StruckType extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "field1",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "field2",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (Structs.StruckTypeHelper.id (), "StruckType", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Structs.StruckType read (org.omg.CORBA.portable.InputStream istream)
  {
    Structs.StruckType value = new Structs.StruckType ();
    value.field1 = istream.read_long ();
    value.field2 = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Structs.StruckType value)
  {
    ostream.write_long (value.field1);
    ostream.write_string (value.field2);
  }

}
