namespace java com.hola.myrpc.dubbo.api.dthrift
 service HelloDthriftApi{
     string hello(1:string name),
     string helloBool(1:bool boo)
 }