package com.github.rodolfoba.helloworld.adapter.audit;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.github.rodolfoba.helloworld.infrastructure.audit.Audit;

@Audit
@Interceptor
public class ConsoleAuditAdapter {
    
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        Logger.getLogger(this.getClass().getSimpleName()).info("Auditing method call");
        return context.proceed();
    }
    
}
