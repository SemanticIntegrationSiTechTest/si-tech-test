package com.semantic.pagination;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.semantic.pagination.domain.Page;
import com.semantic.pagination.domain.Result;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class PaginatedFileReader {

    public static Page readJsonStream(InputStream stream, int startAtPage) throws IOException, JsonIOException, JsonSyntaxException {
        return readJsonStream(stream, startAtPage, 20);
    }

    public static Page readJsonStream(InputStream stream, int startAtPage, int pageSize) throws IOException {

        Page page = new Page(pageSize);

        int retrieveFrom = (startAtPage - 1) * pageSize;

        try (JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"))) {
            Gson gson = new GsonBuilder().create();
            reader.beginArray();
            int index = 0;
            while (reader.hasNext()) {
                Result element = gson.fromJson(reader, Result.class);
                if (index >= retrieveFrom && !page.addElement(element)) {
                    page.setNextPage(calculateNextPage(startAtPage));
                    break;
                }
                index++;
            }
            page.setPreviousPage(calculatePreviousPage(startAtPage, page));
        }
        return page;
    }

    private static int calculateNextPage(int page) {
        return page + 1;
    }

    private static Integer calculatePreviousPage(int page, Page response) {
        if ((page > 1) && !response.getPageContents().isEmpty()) {
            return page - 1;
        }
        return null;
    }
}
