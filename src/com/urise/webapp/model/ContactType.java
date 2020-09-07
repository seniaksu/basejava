package com.urise.webapp.model;

public enum ContactType {
    PHONE("Номер телефона"),
    SKYPE("Скайп"),
    MAIL("Электронная почта"),
    LINKEDIN("Страница на LinkedIn"),
    GITHUB("Репозиторий на GitHub"),
    STACKOVERFLOW ("Профиль Stackoverflow"),
    OTHER_HOMEPAGE("Другая информация");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
