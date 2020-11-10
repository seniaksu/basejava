insert into resume (uuid, full_name)
values ('uuid1', 'Name1'),
       ('uuid2', 'Name2'),
       ('uuid3', 'Name3'),
       ('uuid4', 'Name4');
insert into contact (id, resume_uuid, type, value)
values ('1', '9ed36dd6-a7e9-4105-a53b-014028f14a6c', 'PHONE', '+7(921) 855-0482'),
       ('2', '9ed36dd6-a7e9-4105-a53b-014028f14a6c', 'MAIL', 'gkislin@yandex.ru'),
       ('3', '9ed36dd6-a7e9-4105-a53b-014028f14a6c', 'SKYPE', 'grigory.kislin'),
       ('4', '9ed36dd6-a7e9-4105-a53b-014028f14a6c', 'LINKEDIN', 'LinkedIn'),
       ('5', '9ed36dd6-a7e9-4105-a53b-014028f14a6c', 'GITHUB', 'GitHub'),
       ('6', '9ed36dd6-a7e9-4105-a53b-014028f14a6c', 'STACKOVERFLOW', 'Stackoverflow"'),
       ('7', '9ed36dd6-a7e9-4105-a53b-014028f14a6c', 'OTHER_HOMEPAGE', 'Homepage');

insert into section (id, resume_uuid, type, content)
values ('1', '5e72be8a-4b1b-4b5d-9469-16964369b4ed', 'OBJECTIVE', 'Ведущий стажировок и корпоративного обучения по ' ||
                                                                  'Java Web и Enterprise технологиям'),
       ('2', '5e72be8a-4b1b-4b5d-9469-16964369b4ed', 'PERSONAL',
        'Аналитический склад ума, сильная логика, креативность, ' ||
        'инициативность. Пурист кода и архитектуры.'),
       ('3', '5e72be8a-4b1b-4b5d-9469-16964369b4ed', 'ACHIEVEMENT',
        'Реализация двухфакторной аутентификации для онлайн ' ||
        'платформы управления проектами Wrike. Интеграция с ' ||
        'Twilio, DuoSecurity, Google Authenticator, Jira,'),
       ('4', '5e72be8a-4b1b-4b5d-9469-16964369b4ed', 'QUALIFICATIONS',
        'JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat,' ||
        ' Jetty, WebLogic, WSO2');