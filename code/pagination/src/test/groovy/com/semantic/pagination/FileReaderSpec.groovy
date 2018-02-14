package com.semantic.pagination

import spock.lang.Specification
import spock.lang.Unroll

class FileReaderSpec extends Specification {

    @Unroll
    def "Read sample File #desc"() {
        given:
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data.json").getFile())
        FileInputStream fis = new FileInputStream(file)

        when:
        def result = PaginatedFileReader.readJsonStream fis, page, pageSize
        then:
        result.pageContents.size() == resultsize
        result.previousPage == resultPrevious
        result.nextPage == resultnext

        where:
        desc               | page | pageSize | resultsize | resultPrevious | resultnext
        "All elements"     | 1    | 3        | 3          | null           | null
        "Only last"        | 3    | 1        | 1          | 2              | null
        "Only first"       | 1    | 1        | 1          | null           | 2
        "between pages"    | 2    | 1        | 1          | 1              | 3
        "Outside Boundary" | 4    | 1        | 0          | null           | null
        "Huge pagesize"    | 1    | 50       | 3          | null           | null
    }

}
