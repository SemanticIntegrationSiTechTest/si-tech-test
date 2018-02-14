package com.semantic.pagination.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Page {

    private Integer previousPage;
    private Integer nextPage;
    private List<Result> pageContents = new ArrayList<>();
    private int size;

    public Page(int size) {
        this.size = size;
    }

    private boolean hasSpaceLeft() {
        return pageContents.size() < size;
    }

    public boolean addElement(Result element) {
        if (hasSpaceLeft()) {
            pageContents.add(element);
            return true;
        }
        return false;
    }
}