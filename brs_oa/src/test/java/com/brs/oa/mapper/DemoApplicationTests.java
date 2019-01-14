//package com.brs.oa.mapper;
//
//import io.github.swagger2markup.Swagger2MarkupConfig;
//import io.github.swagger2markup.Swagger2MarkupConverter;
//import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
//import io.github.swagger2markup.markup.builder.MarkupLanguage;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.net.URL;
//import java.nio.file.Paths;
//
///**
// * @author tiny lin
// * @date 2018/12/14
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//public class DemoApplicationTests {
//
//    @Test
//    public void generateAsciiDocs() throws Exception {
//        //    输出Ascii格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withGeneratedExamples()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://172.18.101.114:8080/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get("src/docs/asciidoc/generated/api"));
//    }
//
//
//}
//
