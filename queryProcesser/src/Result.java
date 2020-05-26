//This class represents the result form
//One Result has all these attributes
//This class is mainly composed of setters and getters

public class Result {
    private int id;
    private String url;
    private String snippet;
    private String title;
    private double rank;


    Result(int id,double rank,String url){
        this.id=id;
        this.rank=rank;
        this.url=url;
        this.snippet="";
        this.title="";
    }

    public int getId()
    {
        return this.id;
    }
    public double getRank()
    {
        return this.rank;
    }
    public String getUrl()
    {
        return this.url;
    }
    public String getSnippet()
    {
        return this.snippet;
    }
    public String getTitle()
    {
        return this.title;
    }
    void setId(int i)
    {
        this.id=i;
    }
    void setRank(double r)
    {
        this.rank=r;
    }

    void setUrl(String url)
    {
        this.url=url;
    }
    void setSnippet(String snip)
    {
        this.snippet=snip;
    }
    void setTitle(String tit)
    {
        this.title=tit;
    }


}
