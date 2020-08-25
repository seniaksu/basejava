package com.urise.webapp.model;

public enum ContactsType {
    PHONE("Номер телефона"),
    SKYPE("Скайп"),
    MAIL("Электронная почта"),
    LINKEDIN("Страница на LinkedIn"),
    GITHUB("Репозиторий на GitHub"),
    OTHER_HOMEPAGE("Другая информация");

    private String title;

    ContactsType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
