package com.nie.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceRegistryImpl implements ServiceRegistry, Watcher {

	private static Logger logger = LoggerFactory.getLogger(ServiceRegistryImpl.class);
	
	private static CountDownLatch latch = new CountDownLatch(1);
	
	private ZooKeeper zk;
	
	private static final int SESSION_TIMEOUT = 5000;
	
	private static final String REGISTRY_PATH = "/registry";
	
	public ServiceRegistryImpl() {
		
	}
	public ServiceRegistryImpl(String zkServices) {
		try {
		    zk = new ZooKeeper(zkServices, SESSION_TIMEOUT, this);
		    latch.await();
		    logger.debug("connected to zookeeper");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void register(String serviceName, String serviceAddress) {
		try {
			String registryPath = REGISTRY_PATH;
			if (zk.exists(registryPath, false) == null) {
				zk.create(registryPath, null,  ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				logger.debug("create registry node {}", registryPath);
			}
			
			String servicePath = registryPath + "/" + serviceName;
			if (zk.exists(servicePath, false) == null) {
				zk.create(servicePath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				logger.debug("create service node {}", servicePath);
			}
			
			String addressPath = servicePath + "/address-";
			String addressNode = zk.create(addressPath, serviceAddress.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			logger.debug("create address node {} => {}", addressNode, serviceAddress);
		} catch (Exception e) {
			
		}
		
	}
	@Override
	public void process(WatchedEvent event) {
		if (event.getState() == Event.KeeperState.SyncConnected) {
			latch.countDown();
		}
		
	}

}
