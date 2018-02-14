package com.semantic.pagination.domain;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Result {
    String href;
    String title;
    String summary;
}