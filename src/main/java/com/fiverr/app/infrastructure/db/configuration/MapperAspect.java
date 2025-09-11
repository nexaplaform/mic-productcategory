package com.fiverr.app.infrastructure.db.configuration;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class MapperAspect {

    private final ObjectFactory<CycleAvoidingMappingContext> contextFactory;

    @Around(
            "execution(* com.fiverr.app..*Mapper.toDomain(..)) || " +
                    "execution(* com.fiverr.app..*Mapper.toEntity(..)) || " +
                    "execution(* com.fiverr.app..*Mapper.toDomainList(..))"
    )
    public Object injectContext(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();

        boolean hasContext = Arrays.stream(args)
                .anyMatch(a -> a instanceof CycleAvoidingMappingContext);

        if (!hasContext) {
            Object[] newArgs = Arrays.copyOf(args, args.length + 1);
            newArgs[args.length] = contextFactory.getObject();
            return pjp.proceed(newArgs);
        }
        return pjp.proceed();
    }
}
