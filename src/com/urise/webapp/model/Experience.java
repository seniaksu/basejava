package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Experience {
    private final Link homepage;
    private final String title;
    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String description;

    public Experience(String name, String url, String title, YearMonth startDate, YearMonth endDate, String description) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(description, "description must not be null");
        this.homepage = new Link(name, url);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public Link getHomepage() {
        return homepage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public YearMonth getEndDate() {
        return endDate;
    }

    public YearMonth getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return homepage.equals(that.homepage) &&
                title.equals(that.title) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homepage, title, startDate, endDate, description);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "homepage=" + homepage +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
