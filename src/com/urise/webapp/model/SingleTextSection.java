package com.urise.webapp.model;

import java.util.Objects;

public class SingleTextSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    public static final SingleTextSection EMPTY = new SingleTextSection("");
    private String content;

    public SingleTextSection() {
    }

    public SingleTextSection(String content) {
        Objects.requireNonNull(content, "content must not be null");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleTextSection that = (SingleTextSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return content;
    }
}
