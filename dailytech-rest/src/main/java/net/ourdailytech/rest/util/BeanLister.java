package net.ourdailytech.rest.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BeanLister {

    private final ApplicationContext ctx;

    public BeanLister(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void listBeans() {
        System.out.println("******* Bean Count *******");
        System.out.println(ctx.getBeanDefinitionCount());
    }
}
