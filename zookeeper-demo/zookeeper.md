### Zookeeper知识图谱

- zkCli客户端，可以通过启动ZookeeperMain的main方法启动客户端，主要线程（sendThread、eventThread）
- zkServer服务端，可以通过启动QuorumPeerMain启动，主要线程（PrepRequestProcessor -> SyncRequestProcessor -> FinalRequestProcessor）

#### 客户端启动主要流程

1. 创建ZooKeeper对象
2. 加载ClientCnxnSocketNIO对象用于和服务器通信
3. 创建ClientCnxn对象，初始配置信息，创建线程（sendThread和eventThread）
4. 启动（sendThread、eventThread）
5. sendThread启动时，

#### 服务端启动主要流程


#### 领导者选举
1. 启动时的领导者选举算法规则
    1. 先投票给自己
    2. 判断epoch大小，大的优先选为leader
    3. 若epoch相同，判断zxid大小，大的优先选为leader
    4. 若epoch相同，zxid也相同，判断server id大小，大的优先选为leader
    5. 当投票箱中某一个票数过半时，选举成leader
    6. 进行数据同步
2. 运行时期出现leader挂掉
    1. 同启动时领导者选举，然后进行重新的leader选举
3. 运行时期出现follower挂掉
    2. 如果依然满足过半机制，能够正常工作，leader不进行重新选举
    
    
    
    
### zkCli流程

#### 启动zkCli初始化工作
1. parseOptions解析参数
2. ZooKeeper对象被创建
    1. ConnectStringParser解析链接信息
    2. 创建ClientCnxnSocketNIO（用于和server的通信），后续在sendThread中使用
    2. ClientCnxn对象被创建
        1. 初始化一些配置
        2. 创建线程SendThread
        3. 创建线程EventThread
    3. 调用ClientCnxn的start()
        1. 启动线程sendThread
            1. ClientCnxnSocketNIO.connect()链接服务器
            2. 发送ping命令
            3. 调用ClientCnxnSocketNIO.doTransport() -> ClientCnxnSocketNIO.doIO()使用NIO发送package给服务器（发送的是outgoingQueue中packet数据）
            4. ClientCnxnSocketNIO中判断channel中是否有数据可读，有数据时读出来交给SendThread.readResponse()处理
            5. 判断response中是否有事件处理，有时交给EventThread处理，如watch
        2. 启动线程eventThread
            1. 判断队列waitingEvents中是否有数据，有时处理事件，没有时阻塞
3. ZooKeeperMain.run()方法被调用
    1. 阻塞等待接受命令
    2. 接受到命令
        1. 调用processCmd() -> processZKCmd()找到相应的处理方案
        2. 调用submitRequest()提交请求
        3. 生成Packet包放入outgoingQueue队列中
        
        
#### 启动zkServer工作原理
1. ZooKeeperServer对象被创建
2. FileTxnSnapLog生成日志文件
3. 调用ZooKeeperServer.startup()方法，创建3个requestProcessor
    1. 创建FinalRequestProcessor，头结点是SyncRequestProcessor
    2. 创建SyncRequestProcessor（是线程），头结点PrepRequestProcessor
    3. 创建PrepRequestProcessor（是线程）
    
#### 启动zkServer集群工作原理
1. 启动时leader选举
2. 数据同步
3. leader发起提议需改数据


### ZKClient和KZServer整理

QuorumPeerMain -> ZooKeeperServerMain -> ZooKeeperServer(设置配置)
                                            -> 启动RequestProcessor
                                      -> ServerCnxnFactory（NIOServerCnxnFactory）
                                            -> 开启线程NIOServerCxn.Factory:
                                            -> 调用ZKDatabase加载数据