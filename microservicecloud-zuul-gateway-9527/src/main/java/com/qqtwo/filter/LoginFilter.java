package com.qqtwo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 姜光明
 * @Date: 2019/4/27 1:17
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        // 获取request对象
        HttpServletRequest request = ctx.getRequest();
        // 获取请求参数
        String token = request.getParameter("access-token");
        //判断是否存在
        if (StringUtils.isBlank(token)) {
            //不存在，未登录，拦截
            ctx.setSendZuulResponse(false);
            //设置返回状态码
            ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }

        return null;
    }
}
