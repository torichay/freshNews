import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentGetter {
    private String header, bodier;
    private int number;

    public ContentGetter(Integer num){
        header = "";
        bodier = "";
        //this.number = Integer.parseInt(number);
        this.number = num;
    }

    public String getHead(){
        return header;
    }

    public String getBody(){
        return bodier;
    }

    public void setContent() throws Exception{
        URL mainPage = new URL("http://olegmakarenko.ru/news/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(mainPage.openStream()));

        String inputLine;
        StringBuilder mainContent = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            mainContent.append(inputLine);
        }
        in.close();
        String mainPageContent = mainContent.toString();

        Pattern p = Pattern.compile("\"/news(.*?)\"");
        Matcher m = p.matcher(mainPageContent);
        List<String> listLinks = new ArrayList<String>();
        while(m.find()){
            int start = m.start();
            int end = m.end();
            listLinks.add(mainPageContent.substring(start+1, end-1));
        }

        URL newsUrl = new URL("http://olegmakarenko.ru" + listLinks.get(number-1));
        in = new BufferedReader(
                new InputStreamReader(newsUrl.openStream()));
        StringBuilder newsContent = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            newsContent.append(inputLine);
        }
        in.close();

        String newsPageContent = newsContent.toString();

        int start, end;
        Pattern head = Pattern.compile("<h2 class=\"news_headline\">(.*?)</h2>");
        Matcher mHead = head.matcher(newsPageContent);
        while(mHead.find()){
            start = mHead.start();
            end = mHead.end();
            header = newsPageContent.substring(start+26, end-5);
        }
        //Pattern body = Pattern.compile("<div>([А-Яа-я ]+)");
        Pattern body = Pattern.compile("meta property=\"og:description\" content=\"(.*?)\">");
        Matcher mBody = body.matcher(newsPageContent);
        while(mBody.find()){
            start = mBody.start();
            end = mBody.end();
            //bodier = newsPageContent.substring(start+5, end);
            bodier = newsPageContent.substring(start+40, end-2);
        }
    }
}
