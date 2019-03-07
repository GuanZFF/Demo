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