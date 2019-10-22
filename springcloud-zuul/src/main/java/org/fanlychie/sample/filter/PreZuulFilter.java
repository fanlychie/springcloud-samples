package org.fanlychie.sample.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PreZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        /*
        RequestContext context = RequestContext.getCurrentContext();
        // 禁止Zuul将请求转发到后端服务
        context.setSendZuulResponse(false);
        context.set("sendForwardFilter.ran", true);
        // 直接设置请求的响应结果
        context.setResponseBody("JSON String");
        context.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        */
        log.info("======>> [Zuul] pre");
        return null;
    }

}