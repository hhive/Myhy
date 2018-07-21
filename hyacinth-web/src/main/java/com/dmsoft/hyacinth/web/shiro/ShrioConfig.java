package com.dmsoft.hyacinth.web.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShrioConfig {

        @Bean
        public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
            System.out.println("ShiroConfiguration.shirFilter()");
            ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
            shiroFilterFactoryBean.setSecurityManager(securityManager);
            //拦截器.
            Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
            // 配置不会被拦截的链接 顺序判断
            filterChainDefinitionMap.put("/user/**", "authc");
            filterChainDefinitionMap.put("/staff/**", "authc");
            //filterChainDefinitionMap.put("/log/**", "authc");
            filterChainDefinitionMap.put("/user/userView", " perms[userInfo:view]");
            filterChainDefinitionMap.put("/user/deleteOne", " perms[userInfo:del]");
            filterChainDefinitionMap.put("/user/insertUser", " perms[userInfo:add]");
            filterChainDefinitionMap.put("/user/updateUser", " perms[userInfo:modify]");
            //配置退出 过滤器,其中的具体的退出代码idShiro已经替我们实现了
           filterChainDefinitionMap.put("/logout", "logout");
            //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
            //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
            //filterChainDefinitionMap.put("/**", "anon");
            // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
            shiroFilterFactoryBean.setLoginUrl("/login");
            // 登录成功后要跳转的链接
            shiroFilterFactoryBean.setSuccessUrl("/index");

            //未授权界面;
            shiroFilterFactoryBean.setUnauthorizedUrl("/user/error");
            shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
            return shiroFilterFactoryBean;
        }

        @Bean
        public MyShiroRealm myShiroRealm(){
            MyShiroRealm myShiroRealm = new MyShiroRealm();
            return myShiroRealm;
        }


        @Bean
        public SecurityManager securityManager(){
            DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
            securityManager.setRealm(myShiroRealm());
            return securityManager;
        }
}
