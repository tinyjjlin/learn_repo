package com.beruosi.oav1.interceptor;

import com.beruosi.oav1.annotation.NoNeedToken;
import com.beruosi.oav1.annotation.UserToken;
import com.beruosi.oav1.exception.CustomException;
import com.beruosi.oav1.util.JwtSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // http header get the token
        String token = request.getHeader("token");
        logger.info("---------------->interceptor:"+token);

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method  = handlerMethod.getMethod();
        logger.info("interceptor function------>"+method.getName());
        Annotation[] annotations =method.getAnnotations();
        for(int i=0;i<annotations.length;i++){
            logger.info(annotations[i].toString());

        }
        //通过注解的方式标注可以不用token 访问的方法
        if(method.isAnnotationPresent(NoNeedToken.class)){
            NoNeedToken noNeedToken = method.getAnnotation(NoNeedToken.class);
            if(noNeedToken.required()){
                return true;
            }
        }
        //通过注解的方式，检查需要用户权限方法
        if(method.isAnnotationPresent(UserToken.class)){
            UserToken userToken = method.getAnnotation(UserToken.class);
            if(userToken.required()){
                if(token==null){
                   throw new CustomException("token 不存在");
                }
                if(JwtSupport.verify(token)){
                    logger.info("flag--------------------------------->");
                }else{
                    throw  new CustomException("token 不一致！");
                }


            }
        }



        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
