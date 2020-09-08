package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Experience {
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
        return homepage.equals(that.homepage) &&
                positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homepage, positions);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "homepage=" + homepage +
                ", positions=" + positions +
                '}';
    }

    public static class Position {
        private final String title;
        private final YearMonth startDate;
        private final YearMonth endDate;
        private final String description;

        public Position(String title, YearMonth startDate, YearMonth endDate, String description) {
            Objects.requireNonNull(title, "title must not be null");
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(description, "description must not be null");
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
            return title.equals(position.title) &&
                    startDate.equals(position.startDate) &&
                    endDate.equals(position.endDate) &&
                    description.equals(position.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, startDate, endDate, description);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "title='" + title + '\'' +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}

