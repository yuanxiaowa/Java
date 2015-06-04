# RMI

## 远程方法调用

### 服务器端
1. 远程接口定义(`ITest.java`)需要继承 `java.rmi.Remote`
2. 远程接口实现类(`TestImpl.java`)需要继承 `java.rmi.server.UnicastRemoteObject` 并实现 `ITest.java`
3. 使用命令 `rmic -v1.2 TestImpl` 生成 `TestImpl_Stub.class` 文件（其中包含客户Stub和服务器Stub两者的功能）
4. 启动服务器 `javac TestServer`，代码如下
```java
// System.setSecurityManager(new RMISecurityManager());
ITest test = new TestImpl();

// 如果在命令行启动JRMI服务器 `rmiregistry 1099`，不加上这句， 1099为默认端口
LocateRegistry.createRegistry(1099);

// 将TestString与test对象绑定, TestString 或是 rmi://10.0.0.112:1099/TestString 或 //10.0.0.112:1099/TestString
Naming.rebind("TestString", test);
```

### 客户端
1. 需要 `ITest.java` 和 `TestImpl_Stub.class`
2. 启动客户端 `javac TestClient`，代码如下
```java
// System.setSecurityManager(new RMISecurityManager());
// 根据服务名查询远程对象， rmi://10.0.0.112:1099/TestString 或 //10.0.0.112:1099/TestString
ITest test = (ITest) Naming.lookup("rmi://10.0.0.112:1099/UpperString");
// 调用方法
System.out.println(test.method());
```