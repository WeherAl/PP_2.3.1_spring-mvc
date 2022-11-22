package web.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Задание:
     1. Написать CRUD-приложение. Использовать Spring MVC + Hibernate. +
     2. Должен быть класс User с произвольными полями (id, name и т.п.). +
     3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и изменять юзера. +
     4. Конфигурация Spring через JavaConfig и аннотации, по аналогии с предыдущими проектами. Без использования xml. Без Spring Boot. +

     5. Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен использоваться EntityManager.
     * @return
     *
     *      **      *
     *      * почему методы не объявлены в дао интерфейсе и в сервисе?
     *      *
     *      * Названия методов должны звучать как глаголы и отражать суть выполнения
     *      *
     *      * отсутствует иквалс и хешкод в модели
     *      *
     *      * Все поля должны быть приватизированы там где это необходимо
     *      *
     *      *
     *      *
     *      * bean - зависимости подтягиваем либо через конструктор либо через setter https://springframework.guru/best-practices-for-dependency-injection-with-spring/ (код что не был тобой написан тоже редактируй)
     *      *
     *      *
     *      *
     *      * не инициализировать вручную поля класса, которые можно подтянуть спомощью спринга и Dependency Injection
     *      *
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