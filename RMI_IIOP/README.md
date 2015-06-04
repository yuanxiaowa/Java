# RMI_IIOP

## Java RMI-IIOP是CORBA的一种实现技术，是Java和CORBA一种融合的技术

### 服务端
1. 远程接口定义(`ITest.java`)需要继承 `java.rmi.Remote`
2. 远程接口实现类(`TestImpl.java`)需要继承 `javax.rmi.server.PortableRemoteObject` 并实现 `ITest.java`
3. 使用命令 `rmic -iiop TestImpl` 编译远程接口实现类的字节码文件 `TestImpl.class` 生成 `_TestImpl_Stub.class` 和 `_TestImpl_Tie.class` 文件，这两个文件为客户端需要用到的
4. 使用命令 `tnameserv` 启动服务，默认运行在 `900` 端口
5. 启动服务器 `javac TestServer`，代码如下
```java
import javax.naming.*;

// 生成命名服务上下文对象
Context initialNamingContext = new InitialContext();
TestImpl obj = new TestImpl();
// 用命名服务把远程对象obj和TestString绑定
initialNamingContext.rebind("iiop://10.0.0.112:900/TestString", obj);
```

### 客户端
1. 需要 `ITest.java` 和 `_TestImpl_Stub.class` 以及 `_TestImpl_Tie.class` 文件
2. 启动客户端 `javac TestClient`，代码如下
```java
import javax.naming.*;

Context initialContext = new InitialContext();
// 查找远程对象 TestString
ITest upper = (ITest) initialContext.lookup("iiop://10.0.0.112:900/TestString");
// 调用远程方法
System.out.println(upper.method());
```