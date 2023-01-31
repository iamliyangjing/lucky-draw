package cn.j3code.gateway.resolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-01-31 14:30
 **/
public class IpKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        //return Mono.just(exchange.getRequest().getPath().value());
        return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
