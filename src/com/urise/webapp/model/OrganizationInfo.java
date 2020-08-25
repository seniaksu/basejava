package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class OrganizationInfo {
    private final String name;
    private final String title;
    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String description;

    public OrganizationInfo(String name, String title, YearMonth startDate, YearMonth endDate, String description) {
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(description, "description must not be null");
        this.name = name;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public YearMonth getStartDate() {
        return startDate;
    }

    public YearMonth getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationInfo that = (OrganizationInfo) o;
        return name.equals(that.name) &&
                title.equals(that.title) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, startDate, endDate, description);
    }

    @Override
    public String toString() {
        return "OrganizationInfo{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
