1.该包（DBSource）为数据库连接类（直接与数据库发生关系）的存放地
2.拥有必须实现的通用接口DBConnect(如果还需再加入数据库连接的封装类)则必须实现DBConnect接口，请参照DBApi类！)
3.DBPropertie为数据库连接池(durid)的获取配置信息类，从application.properties获取信息
4.DBSource为数据库连接池(durid)的配置类，从DBPropertie获取配置信息，并配置durid。注意该类为单例！所有需要使用该连接池的类需要保持该类（DBSource）的一个引用
5.DB类为外界可直接访问的数据库的最终封装类，可扩展，或者新加类，但请遵守第二条。
6.其他的包仅能访问DBConnect以及类似于DBApi的最终封装类，不暴露数据库连接池。
7.DBSource 类仅允许初始化一次