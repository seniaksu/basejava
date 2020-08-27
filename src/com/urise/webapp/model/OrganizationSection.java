package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private final List<Experience> positions;

    public OrganizationSection(List<Experience> positions) {
        Objects.requireNonNull(positions, "positions must not be null");
        this.positions = positions;
    }

    public List<Experience> getPositions() {
        return positions;
    }

    public OrganizationSection(Experience... positions) {
        this(Arrays.asList(positions));
    }

    @Override
    public String toString() {
        return positions.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
