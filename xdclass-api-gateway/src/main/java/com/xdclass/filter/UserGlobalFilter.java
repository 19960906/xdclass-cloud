//package com.xdclass.filter;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * 全局过滤器
// */
//@Component
//public class UserGlobalFilter implements GlobalFilter, Ordered{
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //也业务逻辑
//        String token = exchange.getRequest().getHeaders().getFirst("token");
//        //TODO 根据业务开发对应的权鉴
//        if (StringUtils.isBlank(token)){
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//        //继续往下执行
//        return chain.filter(exchange);
//    }
//
//    /**
//     * 数字越小，优先级越高
//     * @return
//     */
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
