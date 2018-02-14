# si-tech-test
This project is my answer for si-tech-test that contains 2 exercises, Margin Calculator and File Paginator, that are further described bellow.

## Marign Calculator
Determines the Reveneu based on Cash and margin percentage

### Calculation Limitations
- Interface stated BigDecimal was in java.util.BigDecimal, has to be corrected to java.Math.BigDecimal
- When margin is 100 will throw divided by 0 exception since it's impossible to determine a reveneu value since every value is possible


## File Paginator
Reads a file and outputs a page containing the elements within the defined boundaries

### Process Limitations
- The input file on the exercise was a dirty JSON, I've assumed it as an error since it was a mix between XML and JSON.
- It's the consumer's responsibility to decide how to handle the error (eg.Log it)
- Usually on pagination a pagesize of -1 means infinite page, since it wasn't part of the spec this functionality wasn't added

### Example input file

```
[
    {
      "href" : "https://link/to/result",
      "title" : "Document title",
      "summary" : "Document summary"
    }
]
```

### Result expected when page = 1, pagesize = 1

```
Page {
    previousPage: 
    nextPage:
    pageContents: [ 
                        {
                          "href" : "https://link/to/result",
                          "title" : "Document title",
                          "summary" : "Document summary"
                        }  
                   ]
}
```