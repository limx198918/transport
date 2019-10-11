package com.sto.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

public class NacosWeightedRule extends AbstractLoadBalancerRule {

	@Autowired
    private  NacosDiscoveryProperties discoveryProperties;

	@Override
	public Server choose(Object key) {
		
		BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
        // 需要请求的微服务名称
        String name = loadBalancer.getName();
        // 获取服务发现的相关API
        NamingService namingService = discoveryProperties.namingServiceInstance();
        try {
            // 调用该方法时nacos client会自动通过基于权重的负载均衡算法选取一个实例
            Instance instance = namingService.selectOneHealthyInstance(name);
            System.out.println(instance.getIp() + ":" + instance.getPort());
            return new NacosServer(instance);
        } catch (NacosException e) {
            return null;
        }
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
	}
}
