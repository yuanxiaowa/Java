# CORBA

## 公共对象请求代理结构

### 定义idl文件 `TestModule.idl`
使用idlj编译把IDL接口编译成Java类， `idlj -fall TestModule.idl`， 生成的Java文件如下
- Test.java
- TestHelper.java
- TestHolder.java
- TestOperations.java
- TestPOA.java
- _TestStub.java

### 服务端
1. 需要 `Test.java` `TestHelper.java` `TestHolder.java` `TestOperations.java` `TestPOA.java` `_TestStub.java`
1. 实现接口类(`TestImpl.java`)继承`TestPOA`
1. 启动orbd服务 `orbd -ORBInitialHost 10.0.0.112 -ORBInitialPort 2500`
1. 启动服务器 `javac TestServer`
```java
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POAManagerPackage.*;
import org.omg.PortableServer.POAPackage.*;

String[] _args = {"-ORBInitialPort", "2500"};
// 初始化ORB对象
ORB orb = ORB.init(_args, null);
// 取得RootPOA引用，并激活POAManager
POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
rootpoa.the_POAManager().activate();

// 建立接口实现类TestImpl对象，并与ORB连接
TestImpl testImpl = new TestImpl();
// 取得对象那个引用
org.omg.CORBA.Object ref = rootpoa.servant_to_reference(testImpl);
Test href = TestHelper.narrow(ref);
// 取得命名上下文的根
org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
// 绑定对象引用
String name = "Test";
NameComponent path[] = ncRef.to_name(name);
ncRef.rebind(path, href);
// 等待客户端调用
orb.run();
```


### 客户端
1. 需要 `Test.java` `TestHelper.java` `TestHolder.java` `TestOperations.java` `_TestStub.java`
1. 启动客户端 `javac TestClient`
```java
String[] _args = {"-ORBInitialHost", "10.0.0.112", "-ORBInitialPort", "2500"};
ORB orb = ORB.init(_args, null);
org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
Test test = TestHelper.narrow(ncRef.resolve_str("Test"));
```