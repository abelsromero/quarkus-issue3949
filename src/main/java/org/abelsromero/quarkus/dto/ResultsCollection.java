package org.abelsromero.quarkus.dto;

import lombok.Getter;

import java.util.Collection;

@Getter
public class ResultsCollection<T> {

    private final Collection<T> values;
    private final long size;

    public ResultsCollection(Collection<T> values) {
        this.values = values;
        this.size = values == null ? 0 : values.size();
    }

}
