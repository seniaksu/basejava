package com.urise.webapp.model;

import java.io.Serializable;
import java.time.Month;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.urise.webapp.util.DateUtil.NOW;
import static com.urise.webapp.util.DateUtil.of;

public class Experience implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Link homepage;
    private final List<Position> positions;

    public Experience(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Experience(Link homepage, List<Position> positions) {
        Objects.requireNonNull(homepage, "homepage must not be null");
        Objects.requireNonNull(positions, "positions must not be null");
        this.homepage = homepage;
        this.positions = positions;
    }

    public Link getHomepage() {
        return homepage;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(homepage, that.homepage) &&
                Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homepage, positions);
    }

    @Override
    public String toString() {
        return "Experience{" + homepage + ", " + positions + '}';
    }

    public static class Position implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String title;
        private final YearMonth startDate;
        private final YearMonth endDate;
        private final String description;

        public Position(String title, int startYear, Month startMonth, String description) {
            this(title, of(startYear, startMonth), NOW, description);
        }

        public Position(String title, int startYear, Month startMonth, int endYear, Month endMonth, String description) {
            this(title, of(startYear, startMonth), of(endYear, endMonth), description);
        }

        public Position(String title, YearMonth startDate, YearMonth endDate, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            this.title = title;
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
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
            Position position = (Position) o;
            return Objects.equals(title, position.title) &&
                    Objects.equals(startDate, position.startDate) &&
                    Objects.equals(endDate, position.endDate) &&
                    Objects.equals(description, position.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, startDate, endDate, description);
        }

        @Override
        public String toString() {
            return "Position{" + title + ", " + startDate + ", " + endDate + ", " + description + '}';
        }
    }
}