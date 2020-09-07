package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.YearMonth;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1", "Григорий Кислин");
        r1.saveContact(ContactType.PHONE, "+7(921) 855-0482");
        r1.saveContact(ContactType.MAIL, "gkislin@yandex.ru");
        r1.saveContact(ContactType.SKYPE, "grigory.kislin");
        r1.saveContact(ContactType.LINKEDIN, "Профиль LinkedIn");
        r1.saveContact(ContactType.GITHUB, "Профиль GitHub");
        r1.saveContact(ContactType.STACKOVERFLOW, "Профиль Stackoverflow");
        r1.saveContact(ContactType.OTHER_HOMEPAGE, "Домашняя страница");

        r1.saveSection(SectionType.OBJECTIVE, new SingleTextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        r1.saveSection(SectionType.PERSONAL, new SingleTextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        r1.saveSection(SectionType.ACHIEVEMENT, new ListSection("С 2013 года: разработка проектов 'Разработка Web приложения','Java Enterprise', 'Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)'. Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));
        r1.saveSection(SectionType.QUALIFICATIONS, new ListSection("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle",
                "MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский 'upper intermediate'"));
        r1.saveSection(SectionType.EXPERIENCE, new OrganizationSection(new Experience("Java Online Projects", "","Автор проекта.",  YearMonth.of(2013, 10), YearMonth.of(2020, 8), "Создание, организация и проведение Java онлайн проектов и стажировок."),
                new Experience("Wrike", "", "Старший разработчик (backend)", YearMonth.of(2014, 10), YearMonth.of(2016, 1), "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."),
                new Experience("RIT Center", "", "Java архитектор", YearMonth.of(2012, 4), YearMonth.of(2014, 10), "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"),
                new Experience("Luxoft (Deutsche Bank)", "", "Ведущий программист",  YearMonth.of(2010, 12), YearMonth.of(2012, 4), "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."),
                new Experience("Yota", "","Ведущий специалист",  YearMonth.of(2008, 6), YearMonth.of(2010, 12), "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"),
                new Experience("Enkata", "","Разработчик ПО",  YearMonth.of(2007, 3), YearMonth.of(2008, 6), "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."),
                new Experience("Siemens AG", "","Разработчик ПО",  YearMonth.of(2005, 1), YearMonth.of(2007, 2), "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."),
                new Experience("Alcatel", "","Инженер по аппаратному и программному тестированию",  YearMonth.of(1997, 9), YearMonth.of(2005, 1), "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")));
        r1.saveSection(SectionType.EDUCATION, new OrganizationSection(new Experience("Coursera", "","",  YearMonth.of(2013, 3), YearMonth.of(2013, 5), "'Functional Programming Principles in Scala' by Martin Odersky"),
                new Experience("Luxoft", "","",  YearMonth.of(2011, 3), YearMonth.of(2011, 4), "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML."),
                new Experience("Siemens AG", "","",  YearMonth.of(2005, 1), YearMonth.of(2005, 4), "3 месяца обучения мобильным IN сетям (Берлин)"),
                new Experience("Alcatel", "","",  YearMonth.of(1997, 9), YearMonth.of(1998, 3), "6 месяцев обучения цифровым телефонным сетям (Москва)"),
                new Experience("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "","",  YearMonth.of(1987, 9), YearMonth.of(1993, 7), "Инженер (программист Fortran, C)"),
                new Experience("Заочная физико-техническая школа при МФТИ", "","",  YearMonth.of(1984, 9), YearMonth.of(1987, 6), "Закончил с отличием")));

        System.out.println("Uuid: " + r1.getUuid() + ", FileName: " + r1.getFullName());
        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle() + ": " + r1.getContact(type));
        }
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle() + ": " + r1.getSection(type) + "\n");
        }
    }
}
