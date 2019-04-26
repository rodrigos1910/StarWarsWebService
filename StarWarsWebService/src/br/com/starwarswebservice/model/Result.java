
package br.com.starwarswebservice.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class Result {
    private long count;
    private String next;
    private String previous;
    private ResultElement[] results;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("next")
    public String getNext() { return next; }
    @JsonProperty("next")
    public void setNext(String value) { this.next = value; }

    @JsonProperty("previous")
    public String getPrevious() { return previous; }
    @JsonProperty("previous")
    public void setPrevious(String value) { this.previous = value; }

    @JsonProperty("results")
    public ResultElement[] getResults() { return results; }
    @JsonProperty("results")
    public void setResults(ResultElement[] value) { this.results = value; }
}
