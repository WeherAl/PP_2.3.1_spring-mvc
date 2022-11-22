package web.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     *      *
     *      * отсутствует иквалс и хешкод в модели
     *      *
     *      * Все поля должны быть приватизированы там где это необходимо
     *      *
     *      *
     * *      *
     *      * корректно расставить подходящие для каждого слоя аннотации спринга для поиска бинов, а точнее @Component и его производные
     */

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }


    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}