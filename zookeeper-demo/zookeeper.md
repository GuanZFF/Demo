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