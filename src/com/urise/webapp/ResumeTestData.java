package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.Month;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = fillResume("uuid1", "Name1");
        System.out.println("Uuid: " + resume.getUuid() + ", FileName: " + resume.getFullName());
        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle() + ": " + resume.getContact(type));
        }
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle() + ": " + resume.getSection(type) + "\n");
        }
    }

    public static Resume fillResume(String uuid, String fullname) {
        Resume resume = new Resume(uuid, fullname);
        resume.addContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        resume.addContact(ContactType.SKYPE, "grigory.kislin");
        resume.addContact(ContactType.LINKEDIN, "Профиль LinkedIn");
        resume.addContact(ContactType.GITHUB, "Профиль GitHub");
        resume.addContact(ContactType.STACKOVERFLOW, "Профиль Stackoverflow");
        resume.addContact(ContactType.OTHER_HOMEPAGE, "Домашняя страница");
        resume.addSection(SectionType.OBJECTIVE,
                new SingleTextSection("Ведущий стажировок и корпоративного обучения по Java Web " +
                        "и Enterprise технологиям"));
        resume.addSection(SectionType.PERSONAL,
                new SingleTextSection("Аналитический склад ума, сильная логика, креативность, инициативность. " +
                        "Пурист кода и архитектуры."));
        resume.addSection(SectionType.ACHIEVEMENT,
                new ListSection(
                        "С 2013 года: разработка проектов 'Разработка Web приложения'," +
                                "'Java Enterprise', 'Многомодульный maven. Многопоточность. XML (JAXB/StAX). " +
                                "Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)'. " +
                                "Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                        "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                        "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с" +
                                " 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: " +
                                "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных " +
                                "ERP модулей, интеграция CIFS/SMB java сервера.",
                        "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, GWT," +
                                " Spring-MVC, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                        "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
                                "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и " +
                                "информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента " +
                                "для администрирования и мониторинга системы по JMX (Jython/ Django).",
                        "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat," +
                                " Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));
        resume.addSection(SectionType.QUALIFICATIONS,
                new ListSection("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                        "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                        "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle",
                        "MySQL, SQLite, MS SQL, HSQLDB",
                        "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                        "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                        "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, " +
                                "Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, " +
                                "ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium " +
                                "(htmlelements).",
                        "Python: Django.",
                        "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                        "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                        "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, " +
                                "XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, " +
                                "LDAP, OAuth1, OAuth2, JWT.",
                        "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                        "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, " +
                                "iReport, OpenCmis, Bonita, pgBouncer.",
                        "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, " +
                                "архитектурных шаблонов, UML, функционального программирования",
                        "Родной русский, английский 'upper intermediate'"));
        resume.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Experience("Java Online Projects", null,
                                new Experience.Position("Автор проекта.",
                                        2013, Month.OCTOBER,
                                        "Создание, организация и проведение Java онлайн проектов и стажировок.")),
                        new Experience("Wrike", null,
                                new Experience.Position("Старший разработчик (backend)",
                                        2014, Month.OCTOBER, 2016, Month.JANUARY,
                                        "Проектирование и разработка онлайн платформы управления проектами " +
                                                "Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL," +
                                                " Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2," +
                                                " JWT SSO.")),
                        new Experience("RIT Center", null,
                                new Experience.Position("Java архитектор",
                                        2012, Month.APRIL, 2014, Month.OCTOBER,
                                        "Организация процесса разработки системы ERP для разных окружений: " +
                                                "релизная политика, версионирование, ведение CI (Jenkins), миграция " +
                                                "базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx)," +
                                                " AAA via SSO. Архитектура БД и серверной части системы. " +
                                                "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), " +
                                                "сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
                                                "Интеграция Alfresco JLAN для online редактирование из браузера " +
                                                "документов MS Office. Maven + plugin development, Ant, Apache Commons," +
                                                " Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita," +
                                                "Python scripting, Unix shell remote scripting via ssh tunnels, " +
                                                "PL/Python")),
                        new Experience("Luxoft (Deutsche Bank)", null,
                                new Experience.Position("Ведущий программист",
                                        2010, Month.DECEMBER, 2012, Month.APRIL,
                                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, " +
                                                "Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и " +
                                                "серверной части CRM. Реализация RIA-приложения для администрирования," +
                                                " мониторинга и анализа результатов в области алгоритмического " +
                                                "трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
                                                "Commet, HTML5.")),
                        new Experience("Yota", null,
                                new Experience.Position("Ведущий специалист",
                                        2008, Month.JUNE, 2010, Month.DECEMBER,
                                        "Дизайн и имплементация Java EE фреймворка для отдела " +
                                                "\"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, " +
                                                "Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, " +
                                                "статистики и мониторинга фреймворка. Разработка online JMX клиента " +
                                                "(Python/ Jython, Django, ExtJS)")),
                        new Experience("Enkata", null,
                                new Experience.Position("Разработчик ПО",
                                        2007, Month.MARCH, 2008, Month.JUNE,
                                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, " +
                                                "Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения " +
                                                "(OLAP, Data mining).")),
                        new Experience("Siemens AG", null,
                                new Experience.Position("Разработчик ПО",
                                        2005, Month.JANUARY, 2007, Month.FEBRUARY,
                                        "Разработка информационной модели, проектирование интерфейсов, " +
                                                "реализация и отладка ПО на мобильной IN платформе Siemens @vantage " +
                                                "(Java, Unix).")),
                        new Experience("Alcatel", null,
                                new Experience.Position("Инженер по аппаратному и программному тестированию",
                                        1997, Month.SEPTEMBER, 2005, Month.JANUARY,
                                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции " +
                                                "Alcatel 1000 S12 (CHILL, ASM)."))));
        resume.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Experience("Coursera", null,
                                new Experience.Position(null,
                                        2013, Month.MARCH, 2013, Month.MAY,
                                        "'Functional Programming Principles in Scala' by Martin Odersky")),
                        new Experience("Luxoft", null,
                                new Experience.Position(null,
                                        2011, Month.MARCH, 2011, Month.APRIL,
                                        "Курс 'Объектно-ориентированный анализ ИС. Концептуальное " +
                                                "моделирование на UML.")),
                        new Experience("Siemens AG", null,
                                new Experience.Position(null,
                                        2005, Month.JANUARY, 2005, Month.APRIL,
                                        "3 месяца обучения мобильным IN сетям (Берлин)")),
                        new Experience("Alcatel", null,
                                new Experience.Position(null,
                                        1997, Month.SEPTEMBER, 1998, Month.MARCH,
                                        "6 месяцев обучения цифровым телефонным сетям (Москва)")),
                        new Experience("Санкт-Петербургский национальный исследовательский университет " +
                                "информационных технологий, механики и оптики", null,
                                new Experience.Position(null,
                                        1993, Month.SEPTEMBER, 1996, Month.JULY,
                                        "Аспирантура (программист С, С++)"),
                                new Experience.Position(null,
                                        1987, Month.SEPTEMBER, 1993, Month.JULY,
                                        "Инженер (программист Fortran, C)")),
                        new Experience("Заочная физико-техническая школа при МФТИ", null,
                                new Experience.Position(null,
                                        1984, Month.SEPTEMBER, 1987, Month.JUNE,
                                        "Закончил с отличием"))));
        return resume;
    }
}