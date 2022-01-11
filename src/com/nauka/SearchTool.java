package com.nauka;

import java.util.List;

//Context class
public class SearchTool {

    private SearchStrategy searchStrategy;

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<String> find(String data) {
        return this.searchStrategy.find(data);
    }

}
