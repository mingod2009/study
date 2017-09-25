package com.nie.zookeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.AsyncCallback.ChildrenCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZookeeperDemo {

	private static final String CONNECTION_STRING = "192.168.0.107:2181,192.168.0.108:2181,192.168.0.109:2181";
	private static final int SESSION_TIMEOUT = 5000;
	
	private static CountDownLatch latch = new CountDownLatch(1);
	
	public static void main(String[] args) {
		try {
			ZooKeeper zk = new ZooKeeper(CONNECTION_STRING, SESSION_TIMEOUT, new Watcher() {

				@Override
				public void process(WatchedEvent event) {
					if (event.getState() == Event.KeeperState.SyncConnected) {
						latch.countDown();
					}
					
				}
				
			});
			latch.await();
			System.out.println(zk);
			
			List<String> children = zk.getChildren("/", null);
			for (String node : children) {
				System.out.println(node);
			}
			
			zk.getChildren("/", null, new ChildrenCallback() {
				
				@Override
				public void processResult(int rc, String path, Object ctx, List<String> childrenL) {
					for (String node: childrenL) {
						System.out.println(node);
					}
					
				}
			}, null);
			
			Stat stat = zk.exists("/", null);
			if (stat != null) {
				System.out.println("node exists");
			} else {
				System.out.println("node does not exist");
			}
			
			zk.exists("/", null, new AsyncCallback.StatCallback() {
				
				@Override
				public void processResult(int rc, String path, Object ctx, Stat stat) {
					if (stat != null) {
						System.out.println("node is exists sync");
					} else {
						System.out.println("node does not exist sync");
					}
					
				}
			}, null);
			
//			String name = zk.create("/f3", "f3-he".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//			System.out.println(name);
//			
//			zk.create("/f2", "f2-he-sys".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
//				
//				@Override
//				public void processResult(int rc, String path, Object ctx, String namef2) {
//					System.out.println(namef2);
//					
//				}
//			}, null);
			
			//byte[] data = zk.getData("/f1", null, null);
			//System.out.println(new String(data));
			
			zk.getData("/f2", null, new AsyncCallback.DataCallback() {
				
				@Override
				public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
					System.out.println(new String(data));
					
				}
			}, null);
			
			//Stat sf1 = zk.setData("/f1", "f1-s".getBytes(), -1);
			//System.out.println(sf1 != null);
			
			zk.setData("/f2", "f2-s".getBytes(), -1,new AsyncCallback.StatCallback() {
				
				@Override
				public void processResult(int rc, String path, Object ctx, Stat statf2) {
					System.out.println(statf2 != null);
					
				}
			},null);
			
			//zk.delete("/f1", -1);
			//System.out.println(true);
			
			zk.delete("/f2", -1, new AsyncCallback.VoidCallback() {
				
				@Override
				public void processResult(int rc, String path, Object ctx) {
					System.out.println(rc == 0);
					
				}
			}, null);
			Thread.sleep(Long.MAX_VALUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
